package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

public class Replyp {
    private Integer rid;

    private String username;

    private String nickname;

    private String photo;

    private Integer ucid;

    private Integer replyId;

    private Integer commentid;

    private String time;

    private String content;

    public Replyp(Integer rid, String username, String nickname, String photo, Integer ucid, Integer replyId, Integer commentid, String time, String content) {
        this.rid = rid;
        this.username = username;
        this.nickname = nickname;
        this.photo = photo;
        this.ucid = ucid;
        this.replyId = replyId;
        this.commentid = commentid;
        this.time = time;
        this.content = content;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

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
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getUcid() {
        return ucid;
    }

    public void setUcid(Integer ucid) {
        this.ucid = ucid;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}