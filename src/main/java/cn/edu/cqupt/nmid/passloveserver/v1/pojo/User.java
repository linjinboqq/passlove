package cn.edu.cqupt.nmid.passloveserver.v1.pojo;


import com.alibaba.fastjson.annotation.JSONField;

public class User {

    @JSONField(ordinal = 0)
    private String username; /*用户名*/
    @JSONField(ordinal = 1)
    private String password; /*密码*/
    @JSONField(ordinal = 2)
    private String nickname; /*名称*/
    @JSONField(ordinal = 3)
    private String photo;    /*头像url相对位置*/
    @JSONField(ordinal = 4)
    private String phonenumber; /*电话号码*/

    public User(cn.edu.cqupt.nmid.passloveserver.v2.pojo.User userV2) {
        this(userV2.getUsername(), userV2.getPassword(), userV2.getNickname(), userV2.getPhoto(), userV2.getPhonenumber());
    }

    /**
     * 构造方法
     * @param username 用户名
     * @param password 密码
     * @param nickname 名称
     * @param photo    头像url相对地址
     * @param phonenumber 电话号码
     * */
    public User(String username, String password, String nickname, String photo, String phonenumber) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.photo = photo;
        this.phonenumber = phonenumber;
    }

    public User() {}

    @Override
    public String toString() {
        return String.format("User[username=%s,password=%s,nickname=%s,photo=%s,phonenumber=%s",
                username, password, nickname, photo, phonenumber);
    }

    //                  get和set方法
    //************************************************************
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    //*************************************************************
}
