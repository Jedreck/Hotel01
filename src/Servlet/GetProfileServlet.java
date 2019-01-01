package servlet;

import Bean.Customer;
import Dao.CustomerDao;
import Dao.Tools.LogOut;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Currency;

@WebServlet(name = "GetProfileServlet", urlPatterns = "/GetProfileServlet")
public class GetProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogOut.Info("in GetProfileServlet!!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        String jsonStr = request.getParameter("jsondata");
        LogOut.Info("jsonStr" ,jsonStr);

        Customer customer = new Customer();
        customer.setCPhone(jsonStr);

        customer = CustomerDao.getProfile(customer);

        if(customer!=null){
            //成功 传回信息
            customer.setCPassword("");
            Gson gson = new Gson();
            String info = gson.toJson(customer);
            LogOut.Info("toJSON",info);
            out.print(info);
        }else{
            //失败 传回null
            LogOut.Info("fail to get info");
            out.print(0);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
