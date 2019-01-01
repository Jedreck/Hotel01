package servlet;

import Bean.Customer;
import Dao.CustomerDao;
import Dao.Tools.LogOut;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RigisterServlet",urlPatterns = "/RigisterServlet")
public class RigisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogOut.Info("in RigisterServlet!!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        //处理数据
        String jsonStr = request.getParameter("jsondata");
        LogOut.Info("JsonStr",jsonStr);
        Gson gson = new GsonBuilder().create();
        Customer customer = gson.fromJson(jsonStr,Customer.class);
        LogOut.Info("got customer from json",customer);

        //插入
        int flag = CustomerDao.Register(customer);
        LogOut.Info("flag",flag);
        out.print(flag);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
