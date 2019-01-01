package servlet;

import Bean.Customer;
import Dao.CustomerDao;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in LoginServlet!!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String jsonStr = request.getParameter("jsondata");
        System.out.println("jsonStr"+jsonStr);

        JsonElement jsonElement = new JsonParser().parse(jsonStr);
        String phone = jsonElement.getAsJsonObject().get("phone").toString();
        phone = phone.substring(1,phone.length()-1);
        String password = jsonElement.getAsJsonObject().get("password").toString();
        password = password.substring(1,password.length()-1);
        Logger.getRootLogger().info("phone:"+phone+"--pwd:"+password);
        Logger.getRootLogger().info("phone:"+phone.length());

        if(phone.length()==11){
            //Customer登录
            //创建customer用于查询
            Customer customer = new Customer();
            customer.setCPhone(phone);
            customer.setCPassword(password);
            //访问数据库
            customer = CustomerDao.Login(customer);
            Logger.getRootLogger().info("Result--"+customer);
            System.out.println(customer);

            if(customer==null){
                Logger.getRootLogger().info("Login Fail");
                out.print(0);  //返回插入结果
            }else{
                Logger.getRootLogger().info("Login Success");
                out.print(customer.getCPhone());
            }
        }else if(phone.length()==7){
            //employee登录
        }else
            out.print(0);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
