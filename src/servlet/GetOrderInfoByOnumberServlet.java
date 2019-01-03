package servlet;

import Bean.Orderform;
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
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetOrderInfoByOnumberServlet",urlPatterns = "/GetOrderInfoByOnumberServlet")
public class GetOrderInfoByOnumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String O_num = request.getParameter("order_number");
        PrintWriter out = response.getWriter();
        Map<String,Object> orderform = null;
        Gson gson = new GsonBuilder().create();
        OrderFormDao ofd = new OrderFormDao();
        try{
            orderform = ofd.selectOrderformByOnumber(O_num);
        }catch(IOException e){
            System.out.println("查询出错 - GetOrderInfoServlet");
        }
        if(O_num == null){
            System.out.println("查询orderform出错 - GetOrderInfoServlet");
        }else{
            //System.out.println(gson.toJson(orderform)+"23413241324");
            out.print(gson.toJson(orderform));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
