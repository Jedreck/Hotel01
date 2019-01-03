package Bean;


public class Orderform {

  private String O_num;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp receivetime;
  private java.sql.Timestamp finishtime;
  private java.sql.Timestamp checkintime;
  private java.sql.Timestamp checkouttime;
  private int R_type;
  private String R_num;
  private String C_ID;
  private String E_num;
  private double O_price;
  private long O_status;

  public String getO_num() {
    return O_num;
  }

  public void setO_num(String o_num) {
    O_num = o_num;
  }

  public int getR_type() {
    return R_type;
  }

  public void setR_type(int r_type) {
    R_type = r_type;
  }

  public String getR_num() {
    return R_num;
  }

  public void setR_num(String r_num) {
    R_num = r_num;
  }

  public String getC_ID() {
    return C_ID;
  }

  public void setC_ID(String c_ID) {
    C_ID = c_ID;
  }

  public String getE_num() {
    return E_num;
  }

  public void setE_num(String e_num) {
    E_num = e_num;
  }

  public double getO_price() {
    return O_price;
  }

  public void setO_price(double o_price) {
    O_price = o_price;
  }

  public long getO_status() {
    return O_status;
  }

  public void setO_status(long o_status) {
    O_status = o_status;
  }

  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public java.sql.Timestamp getReceivetime() {
    return receivetime;
  }

  public void setReceivetime(java.sql.Timestamp receivetime) {
    this.receivetime = receivetime;
  }


  public java.sql.Timestamp getFinishtime() {
    return finishtime;
  }

  public void setFinishtime(java.sql.Timestamp finishtime) {
    this.finishtime = finishtime;
  }


  public java.sql.Timestamp getCheckintime() {
    return checkintime;
  }

  public void setCheckintime(java.sql.Timestamp checkintime) {
    this.checkintime = checkintime;
  }


  public java.sql.Timestamp getCheckouttime() {
    return checkouttime;
  }

  public void setCheckouttime(java.sql.Timestamp checkouttime) {
    this.checkouttime = checkouttime;
  }

  @Override
  public String toString() {

    return "Orderform{" +
            "O_num='" + O_num + '\'' +
            ", createtime=" + createtime +
            ", receivetime='" + receivetime + '\'' +
            ", finishtime='" + finishtime + '\'' +
            ", checkintime='" + checkintime + '\'' +
            ", checkouttime='" + checkouttime + '\'' +
            ", R_type='" + R_type + '\'' +
            ", R_num=" + R_num +
            ", C_ID=" + C_ID +
            ", E_num=" + E_num +
            ", O_price=" + O_price +
            ", O_status=" + O_status +
            '}';
  }
}
