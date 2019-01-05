package servlet;

import Dao.OrderFormDao;
import Dao.RoomtypeordercheckDao;
import Dao.Tools.LogOut;
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

@WebServlet(name = "bookRoomServlet", urlPatterns = "/bookRoomServlet")
public class bookRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogOut.Info("in bookRoomServlet!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        //处理数据
        String jsonStr = request.getParameter("jsondata");
        LogOut.Info("JsonStr", jsonStr);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonStr).getAsJsonObject();

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
//        endDateU.setTime(endDateU.getTime() - (1000 * 60 * 60 * 24));
        Date startDate = new Date(startDateU.getTime());
        Date endDate = new Date(endDateU.getTime() - ADATE);
        LogOut.Info("checkoutDate", checkoutDate);
        LogOut.Info("checkinDate", checkinDate);
        LogOut.Info("startDate", startDate);
        LogOut.Info("endDate", endDate);
        LogOut.Info("inLenth", inLenth);

        //获取房间类型
        int roomtype = jsonObject.get("roomtype").getAsInt();
        LogOut.Info("roomtype", roomtype);

        //获取价格
        double price = jsonObject.get("price").getAsDouble() * inLenth;
        LogOut.Info("price", price);

        //获取phone
        String phone = jsonObject.get("phone").getAsString();
        LogOut.Info("phone", phone);

        //获取单号
        java.util.Date date = new java.util.Date();
        Random random = new Random();
        int randomNum = random.nextInt(9999) % (9999 - 1000 + 1) + 1000;
        String orderNum = date.getTime() + String.valueOf(randomNum);
        LogOut.Info("orderNum", orderNum);

        //SQL
        int success1 = OrderFormDao.insertForm(orderNum, checkinDate, checkoutDate, roomtype, phone, price);
        int success2 = RoomtypeordercheckDao.UpdateRoomtypeOfOrdernum(roomtype, startDate, endDate);
        LogOut.Info("success1", success1);
        LogOut.Info("success2", success2);

        //out
        if (success1 == 0 || success2 == 0)
            out.print(0);
        else out.print(1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
