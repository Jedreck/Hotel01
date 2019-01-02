package servlet;

import Bean.Customer;
import Dao.CustomerDao;
import Dao.Tools.LogOut;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ModifyCustomerServlet",urlPatterns ="/ModifyCustomerServlet" )
public class ModifyCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogOut.Info("in ModifyCustomerServlet!!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        //处理数据
        String jsonStr = request.getParameter("jsondata");
        LogOut.Info("JsonStr", jsonStr);
        Gson gson = new GsonBuilder().create();
        Customer customer = gson.fromJson(jsonStr, Customer.class);
        LogOut.Info("customer",customer);

        int flag = CustomerDao.ModifyInfo(customer);

        LogOut.Info("flag",flag);
        out.print(flag);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
