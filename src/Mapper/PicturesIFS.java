package Mapper;

import org.apache.ibatis.annotations.Param;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

public interface PicturesIFS {
    public int GetTotalPicByRT(String R_roomtype) throws IOException;

    public void InsertPicPathByRT(@Param(value="R_roomtype")String R_roomtype, @Param(value="P_path")String P_path) throws IOException;

    public int DeleteAllByRT(String R_roomtype) throws IOException;

    public List<String> SelectPicByRT(String R_roomtype)throws IOException;
}
