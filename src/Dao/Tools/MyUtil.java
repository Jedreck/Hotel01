package Dao.Tools;

import Dao.EmployeeDao;
import Dao.PicturesDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
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
    public static void SaveFiles(javax.servlet.http.HttpServletRequest request,String path, String R_roomtype) throws IOException {

        PicturesDao pd = new PicturesDao();
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
            System.out.println("MyUtil"+request.getParameter("R_roomtype"));
        }
        catch (FileUploadException e) {
            e.printStackTrace();
        }

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
                String fileName = item.getName();  //文件名
                //int count = pd.GetTotalPicByRT(R_roomtype);
                //int count = MyUtil.GetTotal(R_roomtype);
                //System.out.println("图片总数" + count);
                //count++;
                //count = count % 5 == 0 ? 1 : count % 5;// 只存5张图片
               // String fileName = R_roomtype + "-" + count + "." + item.getName().split("\\.")[1];
                System.out.println("文件名" + fileName);

                // 获取文件存储的位置
                //String basePath = request.getSession().getServletContext().getRealPath("/img/myImage/");
                File file = new File(path, fileName);
                // 插入图片 相对路径供html文件访问
                pd.InsertPicPathByRT(R_roomtype,"../../img/myImage/" + R_roomtype + "/" + fileName);
                System.out.println("完整路径：" + "../../img/myImage/" + R_roomtype + "/" + fileName);
                try {
                    item.write(file);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除目录下的所有文件
     * @param dpath 目录的的路径
     */
    public static void DeleteAllFiles(String dpath){
        System.out.println("开始删除...|" + dpath);
        try {
            //File file1 = new File("./web/img/myImage/25/");
            File file1 = new File(dpath);
            String path = file1.getAbsolutePath();
            File kid;
            String[] kids = file1.list();
            if (file1.exists()) {
                System.out.println("11111");
                for (int i = 0; i < kids.length; i++) {
                    kid = new File(path + "/" +kids[i]);
                    if(kid.exists()) {
                        System.out.println(kids[i]);
                        kid.delete();
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("删除完成！");
    }

    public static int GetTotal(String R_roomtype){
        File file = new File("./web/img/myImage/" + R_roomtype + "/");
        return file.list().length;
    }

    public static void main(String[] args) {
        System.out.println(GetTotal("25")+ "sdfsdfsdf");
    }
}
