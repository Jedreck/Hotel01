package servlet;

import Bean.RoomType;
import Dao.RoomTypeDao;
import Dao.RoomtypeordercheckDao;
import Dao.Tools.LogOut;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
        String inDate = jsonObject.get("inDate").getAsString();
        String strStartDate = inDate.substring(0, 10);
        String strEndDate = inDate.substring(inDate.length() - 10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        java.util.Date startDateU = null;
        java.util.Date endDateU = null;
        int inLenth = 0;
        try {
            startDateU = simpleDateFormat.parse(strStartDate);
            endDateU = simpleDateFormat.parse(strEndDate);
            inLenth = (int) ((endDateU.getTime() - startDateU.getTime()) / 1000 / 60 / 60 / 24);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        endDateU.setTime(endDateU.getTime() - (1000 * 60 * 60 * 24));
        Date startDate = new Date(startDateU.getTime());
        Date endDate = new Date(endDateU.getTime());
        LogOut.Info("startDate", startDate);
        LogOut.Info("endDate", endDate);
        LogOut.Info("inLenth", inLenth);


        //房间类型处理
        RoomType roomType = new RoomType();

        roomType.setPeople(jsonObject.get("people").getAsInt());
        LogOut.Info("people", roomType.getPeople());

        String wifi = jsonObject.get("wifi").getAsString();
        LogOut.Info("wifi", wifi);
        if (!wifi.equals("")) {
            roomType.setWifi(Integer.valueOf(wifi));
            LogOut.Info("wifi", roomType.getWifi());
        }
        String wirednet = jsonObject.get("wirednet").getAsString();
        if (!wirednet.equals("")) {
            roomType.setWirednet(Integer.valueOf(wirednet));
            LogOut.Info("wirednet", roomType.getWirednet());
        }
        String bedtype = jsonObject.get("bedtype").getAsString();
        if (!bedtype.equals("")) {
            roomType.setBedtype(bedtype);
            LogOut.Info("bedtype", roomType.getBedtype());
        }
        String window = jsonObject.get("window").getAsString();
        if (!window.equals("")) {
            roomType.setWindows(Integer.valueOf(window));
            LogOut.Info("window", roomType.getWindows());
        }
        LogOut.Info("roomtype info", roomType);
        int serLenth;
        String resultJson;

        //查找房间类型
        List<RoomType> list = RoomTypeDao.bookInfoSearch(roomType);
        List<RoomType> resultlist = new ArrayList<RoomType>();
        LogOut.Info("RoomType result", list);

        //检查房间类型
        for (RoomType rt : list) {
            LogOut.Info("roomType now", rt.getR_roomtype());
            RoomtypeordercheckDao.checkMaxDate(rt.getR_roomtype(), endDateU);
            serLenth = RoomtypeordercheckDao.CheckRoomtypeAndDate(rt.getR_roomtype(), startDate, endDate);
            LogOut.Info("inLenth", inLenth);
            LogOut.Info("serlenth", serLenth);
            if (serLenth == inLenth) {
                LogOut.Info("添加", rt.getR_roomtype());
                resultlist.add(rt);
            }
        }

        LogOut.Info("RoomType sub result", resultlist);

        Gson gson = new Gson();
        resultJson = gson.toJson(resultlist);

        LogOut.Info("gsonAnrry", resultJson);
//        LogOut.Info(gson.toJson(list));

        out.print(resultJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
