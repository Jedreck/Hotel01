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

@WebServlet(name = "StaffAcceptOrderServlet",urlPatterns = "/StaffAcceptOrderServlet")
public class StaffAcceptOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String O_num = request.getParameter("O_num");

        PrintWriter out = response.getWriter();
        OrderFormDao ofd = new OrderFormDao();
        try{
            ofd.AcceptOrder(O_num);
            out.print("接受预订成功");
        }catch(IOException e){
            System.out.println("接收订单出错 - StaffAcceptOrderServlet");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
