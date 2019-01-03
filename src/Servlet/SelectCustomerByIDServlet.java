package servlet;

import Bean.Customer;
import Dao.CustomerDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectCustomerByIDServlet", urlPatterns = {"/SelectCustomerByIDServlet"})
public class SelectCustomerByIDServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String C_ID = request.getParameter("C_ID");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().create();
        Customer customer = null;
        try {
            CustomerDao cd = new CustomerDao();
            customer = cd.SelectCustomerByID(C_ID);
        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectCustomerByIDServlet");
            //e.printStackTrace();
        }
        if(customer == null) {
            out.print("Error"); // 查询数据库出错
        } else {
            out.print(gson.toJson(customer).toString()); // 返回查询到的json数组
        }
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
