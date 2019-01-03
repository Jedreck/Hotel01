package servlet;

import Bean.Roominfo;
import Dao.RoomInfoDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddRoomServlet", urlPatterns = {"/AddRoomServlet"})
public class AddRoomServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String json = request.getParameter("roomInfo");
        System.out.println(json);
        int result = 0;// 插入结果
        try {
            Gson gson = new GsonBuilder().create();
            Roominfo roominfo = gson.fromJson(json, Roominfo.class);
            result = new RoomInfoDao().InsertRoom(roominfo,1);
        }catch (Exception e) {
            System.out.println("插入房间出现异常--AddRoomServlet");
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
