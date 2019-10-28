package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Type {

    @JSONField(ordinal = 0)
    private Integer id;
    @JSONField(ordinal = 1)
    private String name;
    @JSONField(ordinal = 2)
    private String photo;

    public Type(cn.edu.cqupt.nmid.passloveserver.v2.pojo.Type typeV2) {
        this(typeV2.getId().intValue(), typeV2.getName(), typeV2.getPhoto());
    }

    public Type(Integer id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public Type() {}

    @Override
    public String toString() {
        return String.format("Type[id=%s,name=%s,photo=%s]",id, name, photo);
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
