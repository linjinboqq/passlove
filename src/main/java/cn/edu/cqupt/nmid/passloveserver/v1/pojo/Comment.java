package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Comment {

    @JSONField(ordinal = 0)
    private Integer id;
    @JSONField(ordinal = 1)
    private String time;
    @JSONField(ordinal = 2)
    private String content;

    public Comment(Integer id, String time, String content) {
        this.id = id;
        this.time = time;
        this.content = content;
    }


    public Comment(cn.edu.cqupt.nmid.passloveserver.v2.pojo.Comment commentV2) {
        this(commentV2.getId(), commentV2.getTime(), commentV2.getContent());
    }

    public Comment(String content) {
        this.content = content;
    }

    public Comment() {}

    @Override
    public String toString() {
        return String.format("Comment[id=%S,time=%s,content=%s]",id, time, content);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
