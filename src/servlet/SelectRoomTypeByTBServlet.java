package servlet;

import Bean.RoomType;
import Dao.RoomTypeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectRoomTypeByTBServlet", urlPatterns = {"/SelectRoomTypeByTBServlet"})
public class SelectRoomTypeByTBServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int R_roomtype;
        Gson gson = new GsonBuilder().create();
        RoomType roomType = null;
        PrintWriter out = response.getWriter();
        try {
            R_roomtype = Integer.valueOf(request.getParameter("R_roomtype"));
            RoomTypeDao rtd = new RoomTypeDao();
            System.out.println("房间类型号：" + R_roomtype);
            roomType = rtd.SelectRoomTypeByTB(R_roomtype);
        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectRoomTypeByTBServlet");
            //e.printStackTrace();
        }
        if(roomType == null) {
            out.print("Error"); // 查询数据库出错
        } else {
            out.print(gson.toJson(roomType).toString()); // 返回查询到的json数组
        }
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
