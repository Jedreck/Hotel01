package servlet;

import Dao.RoomTypeDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteRoomTypeServlet", urlPatterns = {"/DeleteRoomTypeServlet"})
public class DeleteRoomTypeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int R_roomtype = Integer.valueOf(request.getParameter("R_roomtype"));
        int result = 0;
        try {
            result = new RoomTypeDao().DeleteRoomType(R_roomtype);
        }catch (Exception e) {
            System.out.println("删除数据出现异常--DeleteRoomTypeServlet");
            //e.printStackTrace();
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
