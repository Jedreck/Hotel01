package servlet;

import Dao.OrderFormDao;
import Dao.Tools.LogOut;
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

@WebServlet(name = "ChangeRoomstateForCheckInServlet",urlPatterns = "/ChangeRoomstateForCheckInServlet")
public class ChangeRoomstateForCheckInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        String O_num = request.getParameter("O_num");
        String R_num = request.getParameter("R_num");

        LogOut.Info("O_num" + O_num);
        LogOut.Info("R_num" + R_num);

        int total = 0;//用来获取客户个人订单的总数

        PrintWriter out = response.getWriter();
        OrderFormDao ofd = new OrderFormDao();
        try{
            total = ofd.ChangeRoomstateForCheckIn(O_num,R_num);
        }catch(IOException e){
            System.out.println("查询出错 - GetOrderInfoServlet");
        }
        if(total == 2){
           out.print("入住成功");
        }else{
            out.print("入住出错--ChangeRoomstateForCheckInServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
