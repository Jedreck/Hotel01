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
import java.util.List;
import java.util.Map;

@WebServlet(name = "SelectOrderCanCancelServlet",urlPatterns = "/SelectOrderCanCancelServlet")
public class SelectOrderCanCancelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String C_ID = request.getParameter("CustomerID");

        int page = Integer.valueOf(request.getParameter("page"));
        int total = 0;//用来获取客户个人订单的总数
        System.out.println("page:"+page+"CustomerID"+C_ID );
        PrintWriter out = response.getWriter();
        List<Map<String,Object>> orderformList = null;
        Gson gson = new GsonBuilder().create();
        OrderFormDao ofd = new OrderFormDao();
        try{
            orderformList = ofd.selectOrderCanCancelByCID(page * 10,C_ID);
            total = ofd.GetTotalCancelDatas(C_ID);
            System.out.println("page:"+page+"total"+total);
        }catch(IOException e){
            System.out.println("查询取消订单出错 - SelectOrderCanCancelServlet");
        }
        if(orderformList == null){
            System.out.println("查询orderform出错- SelectOrderCanCancelServlet");
        }else{
            //System.out.println(gson.toJson(orderformList)+"23413241324");
            out.print(gson.toJson(orderformList)+"!"+total);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
