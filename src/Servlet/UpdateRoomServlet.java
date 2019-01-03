package servlet;


import Bean.RoomType;
import Bean.Roominfo;
import Dao.RoomInfoDao;
import Dao.RoomTypeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateRoomServlet", urlPatterns = {"/UpdateRoomServlet"})
public class UpdateRoomServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String json = request.getParameter("roomInfo");
        int result = 0;
        try {
            Gson gson = new GsonBuilder().create();
            Roominfo roominfo = gson.fromJson(json, Roominfo.class);
            System.out.println(roominfo.toString());
            result = new RoomInfoDao().UpdateRoom(roominfo);
        }catch (Exception e) {
            System.out.println("更新数据出现异常--UpdateRoomTypeServlet");
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
