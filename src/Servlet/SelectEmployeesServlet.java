package servlet;

import Bean.Employee;
import Dao.EmployeeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 获取符合条件的员工
 */
@WebServlet(name = "SelectEmployeesServlet", urlPatterns = {"/SelectEmployeesServlet"})
public class SelectEmployeesServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int page = Integer.valueOf(request.getParameter("page"));// 获取要查找的页号
        String E_name = request.getParameter("E_name");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().create();
        List<Employee> list = null;
        int total = 0;
        try {
            EmployeeDao ed = new EmployeeDao();
            //System.out.println("E_name" + E_name);
            list = ed.SelectEmployeesByName(page * 10, E_name);
            total = ed.GetTotalDatas(E_name);
        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectEmployeesServlet");
            //e.printStackTrace();
        }
        if(list == null) {
            out.print("Error" + "!" + total); // 查询数据库出错
        } else {
            out.print(gson.toJson(list).toString() + "!" + total); // 返回查询到的json数组
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
