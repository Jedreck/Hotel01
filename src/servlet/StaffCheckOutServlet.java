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

@WebServlet(name = "StaffCheckOutServlet",urlPatterns = "/StaffCheckOutServlet")
public class StaffCheckOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //获取手机号
        String C_phone = request.getParameter("C_phone");
        PrintWriter out = response.getWriter();
        Map<String,Object> orderform = null;
        Gson gson = new GsonBuilder().create();
        OrderFormDao ofd = new OrderFormDao();
        try{
            orderform = ofd.StaffselectOrderformByCphone(C_phone);
            out.print(gson.toJson(orderform));
        }catch(IOException e){
            System.out.println("查询出错 - GetOrderInfoServlet");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
