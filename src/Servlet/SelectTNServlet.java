package servlet;

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

@WebServlet(name = "SelectTNServlet", urlPatterns = {"/SelectTNServlet"})
public class SelectTNServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().create();
        List<Map<String,Object>> list = null;
        int total = 0;
        try {
            RoomTypeDao rtd = new RoomTypeDao();
            list = rtd.SelectTN();
            out.println(gson.toJson(list));
        }catch (Exception e) {
            out.print("Error");
            //System.out.println("查询数据出现异常--SelectAllRoomTypeServlet");
            //e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
