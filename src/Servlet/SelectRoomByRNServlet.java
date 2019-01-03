package servlet;

import Bean.Roominfo;
import Dao.RoomInfoDao;
import Dao.RoomTypeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * 根据房间号获取房间的信息
 */
@WebServlet(name = "SelectRoomByRNServlet", urlPatterns = {"/SelectRoomByRNServlet"})
public class SelectRoomByRNServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String R_num = request.getParameter("R_num");
        PrintWriter out = response.getWriter();
        List<Map<String,Object>> list = null;
        Gson gson = new GsonBuilder().create();
        Roominfo roominfo = null;
        int total = 0;
        try {
            RoomInfoDao rid = new RoomInfoDao();
            RoomTypeDao rtd = new RoomTypeDao();
            list = rtd.SelectTN();
            roominfo = rid.SelectRoomByNum(R_num);

        }catch (Exception e) {
            System.out.println("查询数据出现异常--SelectRoomsServlet");
            //e.printStackTrace();
        }
        if(list == null || roominfo == null) {
            out.print("Error" + "!" + total); // 查询数据库出错
        } else {
            out.print(gson.toJson(list).toString() + "!" + gson.toJson(roominfo).toString()); // 返回查询到的json数组
        }
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
