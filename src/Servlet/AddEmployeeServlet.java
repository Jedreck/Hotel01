package servlet;

import Bean.Employee;
import Dao.EmployeeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddEmployeeServlet", urlPatterns = {"/AddEmployeeServlet"})
public class AddEmployeeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String json = request.getParameter("employee");
        //System.out.println(json);
        int result = 0;// 插入结果
        try {
            Gson gson = new GsonBuilder().create();
            Employee employee = gson.fromJson(json, Employee.class);
            result = new EmployeeDao().InsertEmployee(employee);
        }catch (Exception e) {
            System.out.println("插入员工出现异常--AddEmployeeServlet");
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.print(result);// 返回结果
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
