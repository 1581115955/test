package com.bean;

public class Street {
    private Integer id;

    private String name;

    private Integer distrlctId;

    public Street(Integer id, String name, Integer distrlctId) {
        this.id = id;
        this.name = name;
        this.distrlctId = distrlctId;
    }

    public Street() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getDistrlctId() {
        return distrlctId;
    }

    public void setDistrlctId(Integer distrlctId) {
        this.distrlctId = distrlctId;
    }
}