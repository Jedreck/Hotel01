package servlet;

import Bean.RoomType;
import Bean.Roomtypeordercheck;
import Dao.RoomTypeDao;
import Dao.RoomtypeordercheckDao;
import Dao.Tools.LogOut;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "bookSearchServlet", urlPatterns = "/bookSearchServlet")
public class bookSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LogOut.Info("in bookSearchServlet!!!");
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        //处理数据
        String jsonStr = request.getParameter("jsondata");
        LogOut.Info("JsonStr", jsonStr);
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonStr).getAsJsonObject();
        //日期处理
        String strStartDate = jsonObject.get("inDate").getAsString().substring(0, 10);
        String strEndDate = jsonObject.get("inDate").getAsString().substring(11);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        java.util.Date startDateU = null;
        java.util.Date endDateU = null;
        try {
            startDateU = simpleDateFormat.parse(strStartDate);
            endDateU = simpleDateFormat.parse(strEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int inLenth = (int) ((endDateU.getTime() - startDateU.getTime()) / 1000 / 60 / 60 / 24);
        endDateU.setTime(endDateU.getTime() - (1000 * 60 * 60 * 24));
        Date startDate = new Date(startDateU.getTime());
        Date endDate = new Date(endDateU.getTime());
        LogOut.Info("startDate", startDate);
        LogOut.Info("endDate", endDate);
        LogOut.Info("inLenth", inLenth);


        //房间类型处理
        RoomType roomType = new RoomType();
        roomType.setPeople(jsonObject.get("people").getAsInt());
        int serLenth;
        String resultJson = "";

        //查找房间类型（数据库层面本可以两个同时查，但是没时间改接口，先这样
        List<RoomType> list = RoomTypeDao.bookInfoSearch(roomType);
        List<RoomType> resultlist = new ArrayList<RoomType>();
        LogOut.Info("RoomType result",list);
        //检查房间类型
        for(RoomType rt : list){
            serLenth = RoomtypeordercheckDao.CheckRoomtypeAndDate(rt.getR_roomtype(),startDate,endDate);
            LogOut.Info("inLenth",inLenth);
            LogOut.Info("serlenth",serLenth);
            LogOut.Info("roomType now",rt.getR_roomtype());
            if(serLenth==inLenth){
                LogOut.Info("添加",rt.getR_roomtype());
                resultlist.add(rt);
            }
        }

        LogOut.Info("RoomType sub result",resultlist);

        Gson gson = new Gson();
        resultJson = gson.toJson(resultlist);

        LogOut.Info("gsonAnrry",resultJson);
//        LogOut.Info(gson.toJson(list));

        out.print(resultJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
