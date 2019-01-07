package servlet;

import Bean.Customer;
import Bean.Orderform;
import Bean.RoomType;
import Dao.OrderFormDao;
import Dao.RoomTypeDao;
import Dao.Tools.LogOut;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

@WebServlet(name = "StaffInsertCustomerNServlet",urlPatterns = "/StaffInsertCustomerNServlet")
public class StaffInsertCustomerNServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();

        //获取员工编号
        String E_num = request.getParameter("E_num");
        LogOut.Info("E_num", E_num);
        //获取客户信息
        String CustomerInfo = request.getParameter("CustomerInfo");
        LogOut.Info("CustomerInfo", CustomerInfo);
        //获取房间号
        String R_num = request.getParameter("R_num");
        LogOut.Info("R_num", R_num);
        //获取房间类型
        int R_roomtype = Integer.valueOf(request.getParameter("R_roomtype"));
        LogOut.Info("R_roomtype", R_roomtype);
        //获取房间类型一部分信息
        String bookInfo = request.getParameter("bookInfo");
        LogOut.Info("bookInfo", bookInfo);
        //生成订单号
        java.util.Date date = new java.util.Date();
        Random random = new Random();
        int randomNum = random.nextInt(9999) % (9999 - 1000 + 1) + 1000;
        String orderNum = date.getTime() + String.valueOf(randomNum);
        LogOut.Info("orderNum", orderNum);

        //处理数据
        LogOut.Info("bookInfo", bookInfo);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(bookInfo).getAsJsonObject();

        //获取入住日期
        long ADATE = 1000 * 60 * 60 * 24;
        String inDate = jsonObject.get("inDate").getAsString();
        String strStartDate = inDate.substring(0, 10);
        String strEndDate = inDate.substring(inDate.length() - 10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        java.util.Date startDateU = null;
        java.util.Date endDateU = null;
        try {
            startDateU = simpleDateFormat.parse(strStartDate);
            endDateU = simpleDateFormat.parse(strEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int inLenth = (int) ((endDateU.getTime() - startDateU.getTime()) / ADATE);
        if(inLenth==0){
            out.print(0);
        }
        Timestamp checkinDate = new Timestamp(startDateU.getTime() + ADATE / 2);
        Timestamp checkoutDate = new Timestamp(endDateU.getTime() + ADATE / 2);
  //      endDateU.setTime(endDateU.getTime() - (1000 * 60 * 60 * 24));
        Date startDate = new Date(startDateU.getTime());
        Date endDate = new Date(endDateU.getTime() - ADATE);
        LogOut.Info("checkoutDate", checkoutDate);
        LogOut.Info("checkinDate", checkinDate);
        LogOut.Info("startDate", startDate);
        LogOut.Info("endDate", endDate);
        LogOut.Info("inLenth", inLenth);

        int index = -1;
        Customer customer = new Customer();
        try {
            Gson gson = new GsonBuilder().create();
             customer = gson.fromJson(CustomerInfo, Customer.class);
             LogOut.Info("customer : " + customer);
            //插入获取到的客户信息
            index = new OrderFormDao().CheckCustomerRegister(customer.getCId());
            if(index == 1){
                LogOut.Info("客户已经存在不用插入");
            }else if(index == 0){
                new OrderFormDao().StaffInsertCustomerN(customer);
            }else {
                LogOut.Info("客户表重复出错");
            }
            //
        }catch (Exception e) {
            System.out.println("插入数据出现异常--StaffInsertCustomerNServlet");
            //e.printStackTrace();
        }

        //生成一个新订单
        Orderform orderform = new Orderform();
        orderform.setO_num(orderNum);
        orderform.setCheckintime(checkinDate);
        orderform.setCheckouttime(checkoutDate);
        orderform.setR_type(R_roomtype);
        orderform.setR_num(R_num);
        orderform.setC_ID(customer.getCId());
        orderform.setE_num(E_num);

        //订单价格输入入住的天数以便运算
        orderform.setO_price(inLenth);
        //订单状态改为已入住状态“3”
        orderform.setO_status(3);
        LogOut.Info("orderform", orderform);

        //添加新的订单
        try {
            new OrderFormDao().StaffInsertOrderformN(orderform);
            new OrderFormDao().StaffChangeRoomstateForCheckIn(orderform.getR_num());
            new OrderFormDao().StaffChangeRoomOrderForCheckIn(orderform);
        }catch (Exception e) {
            System.out.println("员工添加订单】出现异常--StaffInsertCustomerNServlet");
        }

        out.print("入住成功");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
