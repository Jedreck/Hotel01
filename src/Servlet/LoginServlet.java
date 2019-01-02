package servlet;

import Bean.Customer;
import Dao.CustomerDao;
import Dao.Tools.LogOut;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogOut.Info("in LoginServlet!!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String jsonStr = request.getParameter("jsondata");
        LogOut.Info("jsonStr" + jsonStr);

        JsonElement jsonElement = new JsonParser().parse(jsonStr);
        String phone = jsonElement.getAsJsonObject().get("phone").toString();
        phone = phone.substring(1, phone.length() - 1);
        String password = jsonElement.getAsJsonObject().get("password").toString();
        password = password.substring(1, password.length() - 1);
        LogOut.Info(phone, password);
        LogOut.Info("idLenth", String.valueOf(phone.length()));

        if (phone.length() == 11&&password.length()!=0) {
            //Customer登录
            //创建customer用于查询
            Customer customer = new Customer();
            customer.setCPhone(phone);
            customer.setCPassword(password);
            //访问数据库
            customer = CustomerDao.getProfile(customer);
            LogOut.Info("Result--", customer);

            if (customer == null) {
                LogOut.Info("Login Fail");
                out.print(0);  //返回结果
            } else {
                LogOut.Info("Login Success");
                out.print(customer.getCPhone());
            }
        } else if (phone.length() == 7&&password.length()!=0) {
            //employee登录
        } else
            out.print(0);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
