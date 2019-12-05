package cn.edu.cqupt.nmid.passloveserver.v1.pojo;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.Thelost;
import com.alibaba.fastjson.annotation.JSONField;

public class Lost {


    @JSONField(ordinal = 0)
    private Integer id;
    @JSONField(ordinal = 1)
    private Integer typeid;
    @JSONField(ordinal = 2)
    private Integer losttype;
    @JSONField(ordinal = 3)
    private String title;
    @JSONField(ordinal = 4)
    private String description;
    @JSONField(ordinal = 5)
    private Integer placeid;
    @JSONField(ordinal = 6)
    private String publishtime;
    @JSONField(ordinal = 7)
    private String losttime;
    @JSONField(ordinal = 8)
    private String photo;
    @JSONField(ordinal = 9)
    private Integer ishandled;


    public Lost(Thelost thelost) {
        this(thelost.getId(), thelost.getTypeid().intValue(), thelost.getLosttype(), thelost.getTitle(), thelost.getDescription(), thelost.getPlaceid().intValue(), thelost.getPublishtime(), thelost.getLosttime(), thelost.getPhoto(), thelost.getIshandled());
    }

    /**
     * <p>构造方法</p>
     * @param id 失物id
     * @param typeid 失物类型id
     * @param losttype 招领或者失物  0 失物 | 1 招领
     * @param description 描述
     * @param placeid 地点id
     * @param publishtime 14位 发布时间
     * @param losttime 10位 丢失时间
     * @param photo 照片的相对url地址
     * @param ishandled 是否已经解决  1 是 | 0 否
     *
     * */
    public Lost(Integer id, Integer typeid, Integer losttype, String title, String description, Integer placeid, String publishtime, String losttime, String photo, Integer ishandled) {
        this.id = id;
        this.typeid = typeid;
        this.losttype = losttype;
        this.title = title;
        this.description = description;
        this.placeid = placeid;
        this.publishtime = publishtime;
        this.losttime = losttime;
        this.photo = photo;
        this.ishandled = ishandled;
    }

    public Lost(Integer typeid, Integer losttype, String title, String description, Integer placeid, String publishtime, String losttime, String photo, Integer ishandled) {
        this.typeid = typeid;
        this.losttype = losttype;
        this.title = title;
        this.description = description;
        this.placeid = placeid;
        this.publishtime = publishtime;
        this.losttime = losttime;
        this.photo = photo;
        this.ishandled = ishandled;
    }

    public Lost() {}

    @Override
    public String toString() {
        return String.format("Lost[id=%s,typeid=%s,losttype=%s,title=%s,description=%s,placeid=%s,publishtime=%s,losttime=%s,photo=%s,ishandled=%s]",
                id,typeid,losttype,title,description,placeid,publishtime,losttime,photo,ishandled);
    }

    public Integer getLosttype() {
        return losttype;
    }

    public void setLosttype(Integer losttype) {
        this.losttype = losttype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getLosttime() {
        return losttime;
    }

    public void setLosttime(String losttime) {
        this.losttime = losttime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getIshandled() {
        return ishandled;
    }

    public void setIshandled(Integer ishandled) {
        this.ishandled = ishandled;
    }
}
