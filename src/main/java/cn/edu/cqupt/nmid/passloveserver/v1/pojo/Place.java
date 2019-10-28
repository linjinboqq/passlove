package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Place {

    @JSONField(ordinal = 0)
    private Integer id;
    @JSONField(ordinal = 1)
    private String name;

    public Place(cn.edu.cqupt.nmid.passloveserver.v2.pojo.Place placeV2) {
        this(placeV2.getId().intValue(), placeV2.getName());
    }

    public Place(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Place() {}

    @Override
    public String toString() {
        return String.format("Place[id=%s,name=%s]",id, name);
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
        this.name = name;
    }
}
