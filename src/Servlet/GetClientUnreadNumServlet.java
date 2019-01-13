package servlet;

import Dao.OrderFormDao;
import Dao.Tools.LogOut;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "GetClientUnreadNumServlet",urlPatterns = "/GetClientUnreadNumServlet")
public class GetClientUnreadNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogOut.Info("in GetClientUnreadNumServlet!!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String jsonStr = request.getParameter("jsondata");
        LogOut.Info("jsonStr" + jsonStr);

        //查东西
        int flag = OrderFormDao.selectCustomerUnacceptOrderByPhone(jsonStr);

        //返回东西
        out.print(flag);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
