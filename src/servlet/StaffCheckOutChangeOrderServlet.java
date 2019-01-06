package servlet;

import Dao.OrderFormDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "StaffCheckOutChangeOrderServlet",urlPatterns = "/StaffCheckOutChangeOrderServlet")
public class StaffCheckOutChangeOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //获取手机号
        String O_num = request.getParameter("O_num");
        PrintWriter out = response.getWriter();
        OrderFormDao ofd = new OrderFormDao();
        System.out.println("O_num11111111111111111" + O_num);
        try{
            ofd.StaffCheckOut(O_num);
            out.print("结算成功");
        }catch(IOException e){
            System.out.println("结算出错 - StaffCheckOutChangeOrderServlet");
            e.printStackTrace();
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
