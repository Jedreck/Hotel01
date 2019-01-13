package servlet;

import Bean.RoomType;
import Dao.RoomInfoDao;
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
import java.util.Map;

@WebServlet(name="SelectAllRoomTypeServlet",urlPatterns={"/SelectAllRoomTypeServlet"})
public class SelectAllRoomTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int page = Integer.valueOf(request.getParameter("page"));// 获取要查找的页号
        String typename = request.getParameter("typename");
        PrintWriter out = response.getWriter();
        List<RoomType> roomTypes = null;
        Gson gson = new GsonBuilder().create();
        int total = 0;
        try {
            RoomTypeDao rtd = new RoomTypeDao();
            System.out.println("typename" + typename);
            roomTypes = rtd.selectAllRoomType(page * 10, typename);
            total = rtd.GetTotalDatas(typename);
        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectAllRoomTypeServlet");
            //e.printStackTrace();
        }
        if(roomTypes == null) {
            out.print("Error" + "!" + total); // 查询数据库出错
        } else {
            out.print(gson.toJson(roomTypes).toString() + "!" + total); // 返回查询到的json数组
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
