package servlet;

import Dao.OrderFormDao;
import Dao.RoomTypeDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectMainRtypeBtypeServlet",urlPatterns = "/SelectMainRtypeBtypeServlet")
public class SelectMainRtypeBtypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        Gson gson = new GsonBuilder().create();

        int total = 0;
        try {
            OrderFormDao rtd = new OrderFormDao();
            List<String> rtype = rtd.SelectMainRtype();
            List<String> btype = rtd.SelectMainBtype();
            JsonObject json = new JsonObject();
            out.println(gson.toJson(rtype) + "!" + gson.toJson(btype));
        }catch (Exception e) {
            //out.print("Error");
            System.out.println("查询数据出现异常--SelectMainRtypeBtypeServlet");
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
