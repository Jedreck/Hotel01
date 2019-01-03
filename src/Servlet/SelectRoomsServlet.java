package servlet;

import Bean.RoomType;
import Bean.Roominfo;
import Dao.RoomInfoDao;
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
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectRoomsServlet", urlPatterns = {"/SelectRoomsServlet"})
public class SelectRoomsServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int page = Integer.valueOf(request.getParameter("page"));// 获取要查找的页号
        String typename = request.getParameter("typename");
        PrintWriter out = response.getWriter();
        List<Map<String,Object>> roomList = null;
        Gson gson = new GsonBuilder().create();
        int total = 0;
        try {
            RoomInfoDao rtd = new RoomInfoDao();
            System.out.println("typename" + typename);
            roomList = rtd.SelectAllRooms(page * 10, typename);
            total = rtd.GetTotalDatas(typename);
        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectRoomsServlet");
            //e.printStackTrace();
        }
        if(roomList == null) {
            out.print("Error" + "!" + total); // 查询数据库出错
        } else {
            out.print(gson.toJson(roomList).toString() + "!" + total); // 返回查询到的json数组
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
