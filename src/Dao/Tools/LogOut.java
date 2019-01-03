package Dao.Tools;


import org.apache.log4j.Logger;

public class LogOut {
    public static void Info(String title,String message){
        Logger.getRootLogger().info("-<"+title+">--<"+message+">-");
    }
    public static void Info(Object title,Object message){
        Logger.getRootLogger().info("-<"+title+">--<"+message+">-");
    }
    public static void Info(String message){
        Logger.getRootLogger().info("-<"+message+">-");
    }
}
