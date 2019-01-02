package servlet;

import Bean.Orderform;
import Dao.OrderFormDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


// 插入一个房间类型的Servlet
@WebServlet(name="GetOrderInfoServlet",urlPatterns={"/GetOrderInfoServlet"})
public class GetOrderInfoServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String C_ID = request.getParameter("CustomerID");

        int page = Integer.valueOf(request.getParameter("page"));
        int total = 0;//用来获取客户个人订单的总数

        PrintWriter out = response.getWriter();
        List<Map<String,Object>> orderformList = null;
        Gson gson = new GsonBuilder().create();
        OrderFormDao ofd = new OrderFormDao();
        try{
            orderformList = ofd.selectOrderformByCID(page * 10,C_ID);
            total = ofd.GetTotalDatas(C_ID);
            System.out.println("page:"+page+"total"+total);
        }catch(IOException e){
            System.out.println("查询出错 - GetOrderInfoServlet");
        }
        if(orderformList == null){
            System.out.println("查询orderform出错");
        }else{
            //System.out.println(gson.toJson(orderformList)+"23413241324");
            out.print(gson.toJson(orderformList)+"!"+total);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
