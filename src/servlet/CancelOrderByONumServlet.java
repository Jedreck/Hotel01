package servlet;

import Dao.OrderFormDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CancelOrderByONumServlet",urlPatterns = "/CancelOrderByONumServlet")
public class CancelOrderByONumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String O_num = request.getParameter("O_num");
        PrintWriter out = response.getWriter();
        try{
            OrderFormDao ofd = new OrderFormDao();
            ofd.CancelOrderByOnumber(O_num);

            out.print("取消订单成功");
        }catch (IOException e){
            System.out.println("取消订单异常--CancelOrderByONumServlet");
        }


        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
