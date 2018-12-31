package Bean;

public class RoomType {
    private int R_roomtype;
    private int people;
    private int wifi;
    private int wirednet;
    private int area;
    private int windows;
    private int smoke;
    private int bathroom;
    private int roomnum;
    private double price;
    private String facility;
    private String other;
    private String typename;
    private String bedtype;

    public int getR_roomtype() {
        return R_roomtype;
    }

    public void setR_roomtype(int r_roomtype) {
        R_roomtype = r_roomtype;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getWirednet() {
        return wirednet;
    }

    public void setWirednet(int wirednet) {
        this.wirednet = wirednet;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getSmoke() {
        return smoke;
    }

    public void setSmoke(int smoke) {
        this.smoke = smoke;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getBedtype() {
        return bedtype;
    }

    public void setBedtype(String bedtype) {
        this.bedtype = bedtype;
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "R_roomtype=" + R_roomtype +
                ", people=" + people +
                ", wifi=" + wifi +
                ", wirednet=" + wirednet +
                ", area=" + area +
                ", windows=" + windows +
                ", smoke=" + smoke +
                ", bathroom=" + bathroom +
                ", roomnum=" + roomnum +
                ", price=" + price +
                ", facility='" + facility + '\'' +
                ", other='" + other + '\'' +
                ", typename='" + typename + '\'' +
                ", bedtype='" + bedtype + '\'' +
                '}';
    }
}
