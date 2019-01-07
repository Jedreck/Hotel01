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

@WebServlet(name = "StaffSelectRoomCanCheckInServlet",urlPatterns = "/StaffSelectRoomCanCheckInServlet")
public class StaffSelectRoomCanCheckInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        int page = Integer.valueOf(request.getParameter("page"));
        String R_roomtype = request.getParameter("R_roomtype");


        int total = 0;//用来获取客户个人订单的总数

        PrintWriter out = response.getWriter();
        List<Map<String,Object>> orderformList = null;
        Gson gson = new GsonBuilder().create();
        OrderFormDao ofd = new OrderFormDao();
        try{
            orderformList = ofd.StaffSelectRoomCanCheckIn(page * 10,R_roomtype);
            total = ofd.StaffSelectTotalRoomCanCheckInNum(R_roomtype);
            System.out.println("page:"+page+"total"+total);
        }catch(IOException e){
            System.out.println("查询出错 - StaffSelectRoomCanCheckInServlet");
        }
        if(orderformList == null){
            System.out.println("查询orderform出错");
        }else{
            out.print(gson.toJson(orderformList)+"!"+total);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
