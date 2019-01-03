package servlet;

import Bean.Employee;
import Dao.EmployeeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateEmployeeInfoServlet", urlPatterns = {"/UpdateEmployeeInfoServlet"})
public class UpdateEmployeeInfoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String json = request.getParameter("employee");
        int result = 0;
        try {
            Gson gson = new GsonBuilder().create();
            Employee employee = gson.fromJson(json, Employee.class);
            System.out.println(employee.toString());
            result = new EmployeeDao().UpdateEmployeeInfo(employee);
        }catch (Exception e) {
            System.out.println("更新数据出现异常--UpdateEmployeeInfoServlet");
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
