package servlet;

import Bean.Employee;
import Dao.EmployeeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 根据员工编号选择对应的员工信息
 */
@WebServlet(name = "SelectEmployeeByENServlet", urlPatterns = {"/SelectEmployeeByENServlet"})
public class SelectEmployeeByENServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String E_num = request.getParameter("E_num");
        PrintWriter out = response.getWriter();
        Employee employee = null;
        Gson gson = new GsonBuilder().create();
        try {
            EmployeeDao ed = new EmployeeDao();
            employee = ed.SelectEmployeeByEN(E_num);

        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectEmployeeByENServlet");
            //e.printStackTrace();
        }
        if(employee == null) {
            out.print("Error"); // 查询数据库出错
        } else {
            out.print(gson.toJson(employee).toString()); // 返回查询到的json数组
        }
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
