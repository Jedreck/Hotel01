package servlet;

import Dao.OrderFormDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StaffRejectionOfOrderServlet",urlPatterns = "/StaffRejectionOfOrderServlet")
public class StaffRejectionOfOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String O_num = request.getParameter("O_num");
        PrintWriter out = response.getWriter();
        int inde = 0;
        try{
            OrderFormDao ofd = new OrderFormDao();
            inde = ofd.RejectionOfOrder(O_num);
            out.print(inde);
        }catch (IOException e){
            System.out.println("拒绝订单异常--StaffRejectionOfOrderServlet");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
