package cn.edu.cqupt.nmid.passloveserver.v2.pojo;

public class Dynamics {
    private String username;

    private String nickname;

    private String userphoto;

    private Integer id;

    private Short typeid;

    private Integer losttype;

    private String title;

    private String description;

    private Short placeid;

    private String publishtime;

    private String losttime;

    private String photo;

    private Integer ishandled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getTypeid() {
        return typeid;
    }

    public void setTypeid(Short typeid) {
        this.typeid = typeid;
    }

    public Integer getLosttype() {
        return losttype;
    }

    public void setLosttype(Integer losttype) {
        this.losttype = losttype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Short getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Short placeid) {
        this.placeid = placeid;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime == null ? null : publishtime.trim();
    }

    public String getLosttime() {
        return losttime;
    }

    public void setLosttime(String losttime) {
        this.losttime = losttime == null ? null : losttime.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getIshandled() {
        return ishandled;
    }

    public void setIshandled(Integer ishandled) {
        this.ishandled = ishandled;
    }
}