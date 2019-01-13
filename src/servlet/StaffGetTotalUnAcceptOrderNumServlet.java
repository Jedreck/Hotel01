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

@WebServlet(name = "StaffGetTotalUnAcceptOrderNumServlet",urlPatterns = "/StaffGetTotalUnAcceptOrderNumServlet")
public class StaffGetTotalUnAcceptOrderNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        int total = 0;//用来获取客户已接受订单的总数

        PrintWriter out = response.getWriter();
        OrderFormDao ofd = new OrderFormDao();
        try{
            total = ofd.StaffGetTotalUnAcceptOrderNum();
        }catch(IOException e){
            System.out.println("查询出错 - SelectAllAcceptedOrderServlet");
        }
        out.print(total);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
