package servlet;

import Bean.RoomType;
import Dao.RoomTypeDao;
import Dao.Tools.getSqlSession;
import Mapper.RoomTypeIFS;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateRoomTypeServlet", urlPatterns = {"/UpdateRoomTypeServlet"})
public class UpdateRoomTypeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String json = request.getParameter("roomType");
        int result = 0;
        try {
            Gson gson = new GsonBuilder().create();
            RoomType roomType = gson.fromJson(json, RoomType.class);
            System.out.println(roomType.toString());
            result = new RoomTypeDao().UpdateRoomType(roomType);
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
