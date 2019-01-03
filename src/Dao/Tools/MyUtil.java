package Dao.Tools;

import Dao.EmployeeDao;

/**
 * 工具类
 */
public class MyUtil {
    /**
     * 根据职位自动生成员工的工号，用于添加员工时使用
     * @param E_position 职位
     * @return 生成的员工号
     */
    public static String GenerateE_num(String E_position){
        String E_num = "";
        int total = 0;
        switch (E_position) {
            case "酒店前台":
                E_num += "101";
                break;
            case "经理":
                E_num += "102";
                break;
            case "管理员":
                E_num += "103";
                break;
            case "超级管理员": default:
                E_num += "104";
                break;
        }
        try {
            total = new EmployeeDao().GetTotalByPosition(E_position);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(total < 10) return E_num + "00" +  (total + 1);
        else if(total < 100) return E_num + "0" +  (total + 1);
        else return E_num + (total + 1);
    }

    public static void main(String[] args) {
        System.out.println(GenerateE_num("经理")+ "sdfsdfsdf");
    }
}
