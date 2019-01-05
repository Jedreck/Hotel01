package servlet;

import Dao.PicturesDao;
import Dao.Tools.MyUtil;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletePicServlet", urlPatterns = {"/DeletePicServlet"})
public class DeletePicServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String R_roomtype = request.getParameter("R_roomtype");
        int result = 0;
        try{
            System.out.println("执行删除");
            String opath[] = request.getServletContext().getRealPath("index.jsp").split("\\\\");
            String path = opath[0] + "\\" + opath[1] + "\\" + opath[2] + "\\" + "web\\img\\myImage\\";
            System.out.println(path);
            result = new PicturesDao().DeleteAllByRT(R_roomtype);
            // 删除文件夹下的所有内容
            System.out.println("删除文件夹下所有内容...");
            MyUtil.DeleteAllFiles(path + R_roomtype + "\\");

        }catch (Exception e){
            System.out.println("异常：DeletePicServlet");
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
