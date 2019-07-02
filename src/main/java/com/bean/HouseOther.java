package com.bean;

public class HouseOther {

    private String id;//出租房ID
    private String title;//出租房标题
    private Long price;//价格
    private Integer floorage;//面积
    private String contact;//联系方式
    private String path;//图片名称
    private String sName;//区
    private String dName;//街道
    private String tName;//房子类型

    @Override
    public String toString() {
        return "HouseOther{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", floorage=" + floorage +
                ", contact='" + contact + '\'' +
                ", path='" + path + '\'' +
                ", sName='" + sName + '\'' +
                ", dName='" + dName + '\'' +
                ", tName='" + tName + '\'' +
                '}';
    }

    //-------------------------------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(Integer floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
