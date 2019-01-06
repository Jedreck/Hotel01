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

@WebServlet(name = "SelectCIDForCustomerServlet",urlPatterns = "/SelectCIDForCustomerServlet")
public class SelectCIDForCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String C_phone = request.getParameter("C_phone");
        String C_ID = "";
        PrintWriter out = response.getWriter();
        OrderFormDao ofd = new OrderFormDao();
        try{
            C_ID = ofd.SelectCIDForCustomer(C_phone);
        }catch(IOException e){
            System.out.println("查询取消订单出错 - SelectOrderCanCancelServlet");
        }
        if(C_ID == ""){
            System.out.println("查询客户的ID出错- SelectCIDForCustomerServlet");
        }else{
            out.print(C_ID);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
