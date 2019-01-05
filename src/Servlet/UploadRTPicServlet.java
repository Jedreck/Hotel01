package servlet;

import Dao.Tools.MyUtil;
import com.google.gson.JsonObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UploadRTPicServlet", urlPatterns = {"/UploadRTPicServlet"})
public class UploadRTPicServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        // 设置request的编码方式为utf-8,解决上传文件时中文文件名称乱码的问题
        request.setCharacterEncoding("UTF-8");
        String R_roomtype = request.getParameter("R_roomtype");
        System.out.println(R_roomtype + "999999999999999");
        // 生成路径 未部署的时候使用
        String opath[] = request.getServletContext().getRealPath("index.jsp").split("\\\\");
        String path = opath[0] + "\\" + opath[1] + "\\" + opath[2] + "\\" + "web\\img\\myImage\\";

        System.out.println("servlet：" + path);

        MyUtil.SaveFiles(request, path,R_roomtype);
        // layui的上传模块必须需要返回一个json格式的数据
        PrintWriter out = response.getWriter();
        JsonObject json = new JsonObject();
        JsonObject data = new JsonObject();
        data.addProperty("src","http://baidu.com");
        json.addProperty("code",0);
        json.addProperty("msg","上");
        json.addProperty("count",1);
        json.add("data",data);
        out.print(json.toString());
        System.out.println(json.toString());
        out.flush();
        out.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

}
