package servlet;

import Dao.RoomInfoDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "SelectRoomOpRatio", urlPatterns = {"/SelectRoomOpRatio"})
public class SelectRoomOpRatio extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int total = 0;
        int op = 0;
        Gson gson;
        JsonObject json = new JsonObject();
        gson = new GsonBuilder().create();
        try {
            RoomInfoDao rid = new RoomInfoDao();
            Date time = new Date(System.currentTimeMillis());
            op = rid.SelectRoomOp(time.toString());
            total = rid.GetTotalDatas("");
            json.addProperty("op", op);
            json.addProperty("total", total);

        }catch (Exception e) {
            System.out.println("查询房间占用率出现异常--SelectRoomOpRatio");
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        System.out.println(json.toString());
        out.print(gson.toJson(json).toString()); // 返回查询到的json数组
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
