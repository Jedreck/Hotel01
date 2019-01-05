package Bean;


public class Pictures {

  private String P_path;// 图片路径
  private long R_roomtype;


  public String getP_path() {
    return P_path;
  }

  public void setP_path(String p_path) {
    P_path = p_path;
  }

  public long getR_roomtype() {
    return R_roomtype;
  }

  public void setR_roomtype(long r_roomtype) {
    R_roomtype = r_roomtype;
  }

  @Override
  public String toString() {
    return "Pictures{" +
            "P_path='" + P_path + '\'' +
            ", R_roomtype=" + R_roomtype +
            '}';
  }
}
