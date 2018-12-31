package servlet;

import Dao.RoomTypeDao;
import Dao.Tools.getSqlSession;
import Mapper.RoomTypeIFS;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Bean.RoomType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="AddRoomTypeServlet", urlPatterns={"/AddRoomTypeServlet"})
public class AddRoomTypeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String json = request.getParameter("roomType");
        System.out.println("获得的json字符串：" + json);
        int result = 0;
        try {
            Gson gson = new GsonBuilder().create();
            RoomType roomType = gson.fromJson(json, RoomType.class);
            new RoomTypeDao().insertRoomType(roomType);
        }catch (Exception e) {
            System.out.println("出生动风景奥尔夫阿萨德金佛山df");
            e.printStackTrace();
        }
        System.out.print("插入的结果：" + result);
        PrintWriter out = response.getWriter();
        out.print("插入的结果：" + result);
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

}
