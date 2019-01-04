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

@WebServlet(name = "SelectOrderCanChekInServlet",urlPatterns = "/SelectOrderCanChekInServlet")
public class SelectOrderCanChekInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String C_phone = request.getParameter("C_phone");


        PrintWriter out = response.getWriter();
        List<Map<String,Object>> orderformList = null;
        Gson gson = new GsonBuilder().create();
        OrderFormDao ofd = new OrderFormDao();
        try{
            orderformList = ofd.SelectOrderCanCheckIn(C_phone);
        }catch(IOException e){
            System.out.println("查询出错 - SelectOrderCanChekInServlet");
        }
        if(orderformList == null){
            System.out.println("查询orderform出错- SelectOrderCanChekInServlet");
        }else{
            //System.out.println(gson.toJson(orderformList)+"23413241324");
            out.print(gson.toJson(orderformList));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
