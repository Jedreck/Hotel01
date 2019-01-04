package servlet;

import Dao.OrderFormDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectRoomCanCheckInServlet",urlPatterns = "/SelectRoomCanCheckInServlet")
public class SelectRoomCanCheckInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        int page = Integer.valueOf(request.getParameter("page"));
        String O_num = request.getParameter("order_number");


        int total = 0;//用来获取客户个人订单的总数

        PrintWriter out = response.getWriter();
        List<Map<String,Object>> orderformList = null;
        Gson gson = new GsonBuilder().create();
        OrderFormDao ofd = new OrderFormDao();
        try{
            orderformList = ofd.SelectRoomCanCheckIn(page * 10,O_num);
            total = ofd.SelectTotalRoomCanCheckInNum(O_num);
            System.out.println("page:"+page+"total"+total);
        }catch(IOException e){
            System.out.println("查询出错 - GetOrderInfoServlet");
        }
        if(orderformList == null){
            System.out.println("查询orderform出错");
        }else{
            //System.out.println(gson.toJson(orderformList)+"23413241324");
            out.print(gson.toJson(orderformList)+"!"+total);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
