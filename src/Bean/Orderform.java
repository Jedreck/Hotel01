package Bean;


public class Orderform {

  private String oNum;
  private java.sql.Timestamp createtime;
  private java.sql.Timestamp receivetime;
  private java.sql.Timestamp finishtime;
  private java.sql.Timestamp checkintime;
  private java.sql.Timestamp checkouttime;
  private long rType;
  private String rNum;
  private String cId;
  private String eNum;
  private long oStarus;


  public String getONum() {
    return oNum;
  }

  public void setONum(String oNum) {
    this.oNum = oNum;
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


  public long getRType() {
    return rType;
  }

  public void setRType(long rType) {
    this.rType = rType;
  }


  public String getRNum() {
    return rNum;
  }

  public void setRNum(String rNum) {
    this.rNum = rNum;
  }


  public String getCId() {
    return cId;
  }

  public void setCId(String cId) {
    this.cId = cId;
  }


  public String getENum() {
    return eNum;
  }

  public void setENum(String eNum) {
    this.eNum = eNum;
  }


  public long getOStarus() {
    return oStarus;
  }

  public void setOStarus(long oStarus) {
    this.oStarus = oStarus;
  }

}
