package Dao.Tools;

import Dao.EmployeeDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.util.Iterator;
import java.util.List;

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


    /**
     * 将前端上传的文件保存到img/myImage目录下
     * @param request
     * @param path 文件存储的路径
     */
    public static void SaveFiles(javax.servlet.http.HttpServletRequest request,String path, String R_roomtype){

        path += R_roomtype + "\\";

        // 文件夹不存在时，创建文件夹
        File directory=new File(path);
        if(!directory.exists()){//如果文件夹不存在
            directory.mkdir();
        }

        // 上传文件处理
        FileItemFactory factory = new DiskFileItemFactory();
        // 创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);


        // 开始解析请求信息
        List items = null;
        try {
            items = upload.parseRequest(request);
        }
        catch (FileUploadException e) {
            e.printStackTrace();
        }

        int count = 0;
        // 对所有请求信息进行判断
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 信息为普通的格式
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String value = item.getString();
                request.setAttribute(fieldName, value);
            }
            // 信息为文件格式
            else {
               // String originalFilename = null;  //文件名
                String fileName = R_roomtype + "-" + count + "." + item.getName().split("\\.")[1];
                System.out.println("文件名" + fileName + "sdfsdf:" + item.getName().split("\\.")[1]);

                // 获取文件存储的位置
                //String basePath = request.getSession().getServletContext().getRealPath("/img/myImage/");
                System.out.println(count + "路径：" + path);
                File file = new File(path, fileName);
                try {
                    item.write(file);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(GenerateE_num("经理")+ "sdfsdfsdf");
    }
}
