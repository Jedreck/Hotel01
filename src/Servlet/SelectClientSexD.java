package servlet;

import Dao.CustomerDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectClientSexD", urlPatterns = {"/SelectClientSexD"})
public class SelectClientSexD extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        List<Map<String,Object>> sexD = null;
        Gson gson;
        gson = new GsonBuilder().create();
        try {
            CustomerDao cd = new CustomerDao();
            sexD = cd.SelectClientSexD();

        }catch (Exception e) {
            System.out.println("查询员工男女数据出现异常--SelectEmployeeSexD");
            //e.printStackTrace();
        }
        if(sexD == null) {
            out.print("Error"); // 查询数据库出错
        } else {
            System.out.println(gson.toJson(sexD).toString());
            out.print(gson.toJson(sexD).toString()); // 返回查询到的json数组
        }
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
