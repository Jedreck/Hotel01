package servlet;

import Bean.Customer;
import Dao.CustomerDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SelectAllClientServlet", urlPatterns = {"/SelectAllClientServlet"})
public class SelectAllClientServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int page = Integer.valueOf(request.getParameter("page"));// 获取要查找的页号
        String name = request.getParameter("name");
        PrintWriter out = response.getWriter();
        List<Customer> roomList = null;
        Gson gson = new GsonBuilder().create();
        int total = 0;
        try {
            CustomerDao cd = new CustomerDao();
            System.out.println("name" + name);
            roomList = cd.SelectCustomerByFuzzyName(page * 10, name);
            total = cd.GetTotalDatas(name);
        }catch (Exception e) {
            System.out.println("查询客户数据出现异常--SelectAllClientServlet");
            //e.printStackTrace();
        }
        if(roomList == null) {
            out.print("Error" + "!" + total); // 查询数据库出错
        } else {
            out.print(gson.toJson(roomList).toString() + "!" + total); // 返回查询到的json数组
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
