package Dao;

import Dao.Tools.MyUtil;
import Dao.Tools.getSqlSession;
import Mapper.PicturesIFS;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PicturesDao {
    private SqlSession session;
    private PicturesIFS picturesIFS;

    /**
     * 获取图片的总数量
     * @param R_roomtype 房间类型编号
     * @return 房间类型的图片总数量
     * @throws IOException
     */
    public int GetTotalPicByRT(String R_roomtype) throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        picturesIFS = session.getMapper(PicturesIFS.class);
        int total = 0;
        try {
            total =  picturesIFS.GetTotalPicByRT(R_roomtype);
        } catch (Exception e){
            System.out.println("异常：选择图片总数-->GetTotalPicByRT-->PicturesDao");
            // e.printStackTrace();
        }
        session.close();
        return total;
    }

    /**
     * 插入一个图片
     * @param R_roomtype 房间类型编号
     * @param P_path 图片路径
     * @throws IOException
     */
    public void InsertPicPathByRT(String R_roomtype,String P_path)throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        picturesIFS = session.getMapper(PicturesIFS.class);
        try {
            picturesIFS.InsertPicPathByRT(R_roomtype,P_path);
        } catch (Exception e){
            System.out.println("异常：插入图片-->InsertPicPathByRT-->PicturesDao");
            e.printStackTrace();
        }
        session.commit();
        session.close();
    }

    /**
     * 删除相应图片
     * @param R_roomtype 房间类型的编号
     * @throws IOException
     */
    public int DeleteAllByRT(String R_roomtype) throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        picturesIFS = session.getMapper(PicturesIFS.class);
        int result = 0;
        try {
            result = picturesIFS.DeleteAllByRT(R_roomtype);
        } catch (Exception e) {
            System.out.println("异常：删除图片-->DeleteAllByRT-->PicturesDao");
            e.printStackTrace();
        }

        session.commit();
        session.close();
        return result;
    }

    /**
     * 根据房间类型编号选择相应的图片
     * @param R_roomtype
     * @return
     */
    public List<String> SelectPicByRT(String R_roomtype)throws IOException{
        //获取sqlSession对象
        session = getSqlSession.getSession().openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
        picturesIFS = session.getMapper(PicturesIFS.class);
        List<String> list = null;
        try {
            list =  picturesIFS.SelectPicByRT(R_roomtype);
        } catch (Exception e){
            System.out.println("异常：选择图片-->SelectPicByRT-->PicturesDao");
            // e.printStackTrace();
        }
        session.close();
        return list;
    }

    public static void main(String[] args) {
//        try {
//            File file1 = new File("./web/img/myImage/25/");
//            String path = file1.getAbsolutePath();
//            File kid;
//            String[] kids = file1.list();
//            if (file1.exists()) {
//                System.out.println(path + "sdfsdf " + kids.length);
//                for (int i = 0; i < kids.length; i++) {
//                    kid = new File(path + "/" +kids[i]);
//                    if(kid.exists()) {
//                        System.out.println(kids[i]);
//                        kid.delete();
//                    }
//
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        try {
            PicturesDao pd = new PicturesDao();
            System.out.println(new PicturesDao().SelectPicByRT("25"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
