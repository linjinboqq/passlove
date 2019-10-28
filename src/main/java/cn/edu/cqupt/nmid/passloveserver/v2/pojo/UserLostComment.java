package cn.edu.cqupt.nmid.passloveserver.v2.pojo;

public class UserLostComment {
    private Integer id;

    private String username;

    private Integer lostid;

    private Integer commentid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getLostid() {
        return lostid;
    }

    public void setLostid(Integer lostid) {
        this.lostid = lostid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }
}