package servlet;

import Bean.RoomType;
import Dao.RoomTypeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="SelectAllRoomTypeServlet",urlPatterns={"/SelectAllRoomTypeServlet"})
public class SelectAllRoomTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int page = Integer.valueOf(request.getParameter("page"));// 获取要查找的页号
        PrintWriter out = response.getWriter();
        List<RoomType> roomTypeList = null;
        Gson gson = new GsonBuilder().create();
        try {
            RoomTypeDao rtd = new RoomTypeDao();
            roomTypeList = rtd.selectAllRoomType(page * 10);
        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectAllRoomTypeServlet");
            //e.printStackTrace();
        }
        if(roomTypeList == null) {
            out.print("Error"); // 查询数据库出错
        } else {
            out.print(gson.toJson(roomTypeList).toString()); // 返回查询到的json数组
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
