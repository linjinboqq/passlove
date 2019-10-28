package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Dynamics {

    @JSONField(ordinal = 1)
    private String username;
    @JSONField(ordinal = 2)
    private String nickname;
    @JSONField(ordinal = 3)
    private String userphoto;
    @JSONField(ordinal = 4)
    private Lost thelost;

    public Dynamics(cn.edu.cqupt.nmid.passloveserver.v2.pojo.Dynamics dynamicsV2) {
        this(dynamicsV2.getUsername(), dynamicsV2.getNickname(), dynamicsV2.getUserphoto(), dynamicsV2.getId(), dynamicsV2.getTypeid().intValue(), dynamicsV2.getLosttype(), dynamicsV2.getTitle(), dynamicsV2.getDescription(), dynamicsV2.getPlaceid().intValue(), dynamicsV2.getPublishtime(), dynamicsV2.getLosttime(), dynamicsV2.getPhoto(), dynamicsV2.getIshandled());
    }

    public Dynamics(String username, String nickname, String userphoto, Integer id, Integer typeid, Integer losttype, String title, String description, Integer placeid, String publishtime, String losttime, String photo, Integer ishandled) {
        this.username = username;
        this.nickname = nickname;
        this.userphoto = photo;
        this.thelost = new Lost(id, typeid, losttype, title, description, placeid, publishtime, losttime, photo, ishandled);
    }
    
    @Override
    public String toString() {
        return String.format("Dynamics[username=%s,nickname=%s,userphoto=%s,thelost=%s]",username,
                nickname, userphoto, thelost);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public Lost getThelost() {
        return thelost;
    }

    public void setThelost(Lost thelost) {
        this.thelost = thelost;
    }
}
