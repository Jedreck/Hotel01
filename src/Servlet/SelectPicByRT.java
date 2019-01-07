package servlet;

import Dao.PicturesDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SelectPicByRT", urlPatterns = {"/SelectPicByRT"})
public class SelectPicByRT extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String R_roomtype = request.getParameter("R_roomtype");
        List<String> picUrl = null;
        Gson gson = new GsonBuilder().create();
        try{
            picUrl = new PicturesDao().SelectPicByRT(R_roomtype);
        }catch (Exception e){
            System.out.println("异常：SelectPicByRT");
        }
        PrintWriter out = response.getWriter();
        System.out.println(gson.toJson(picUrl).toString());
        out.print(gson.toJson(picUrl).toString());
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
