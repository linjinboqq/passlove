package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Commentp {

    @JSONField(serialize = true)
    private int ucid;
    @JSONField(ordinal = 0)
    private String username;
    @JSONField(ordinal = 1)
    private String nickname;
    @JSONField(ordinal = 2)
    private String photo;
    @JSONField(ordinal = 3)
    private Integer lostid;
    @JSONField(ordinal = 4)
    private Comment comment;

    @Override
    public String toString() {
        return String.format("Commentp[username=%s,nickname=%s,photo=%s,lostid=%s,comment=%s]",
                username, nickname, photo, lostid, comment);
    }

    public Commentp(cn.edu.cqupt.nmid.passloveserver.v2.pojo.Commentp commentpV2) {
        this(commentpV2.getId(), commentpV2.getUsername(), commentpV2.getNickname(), commentpV2.getPhoto(), commentpV2.getLostid(), commentpV2.getId(), commentpV2.getTime(), commentpV2.getContent());
    }

    public Commentp(int ucid, String username, String nickname, String photo, Integer lostid, Integer id, String time, String content) {
        this.ucid = ucid;
        this.username = username;
        this.nickname = nickname;
        this.photo = photo;
        this.lostid = lostid;
        this.comment = new Comment(id, time, content);
    }

    public Commentp(String username, String nickname, String photo, Integer lostid, Integer id, String time, String content) {
        this.username = username;
        this.nickname = nickname;
        this.photo = photo;
        this.lostid = lostid;
        this.comment = new Comment(id, time, content);
    }

    public int getUcid() {
        return ucid;
    }

    public void setUcid(int ucid) {
        this.ucid = ucid;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getLostid() {
        return lostid;
    }

    public void setLostid(Integer lostid) {
        this.lostid = lostid;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
