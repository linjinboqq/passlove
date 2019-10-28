package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Lost;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface LostDao {

    /**
     * <p>获取指定数量的lost</p>
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
    @Select("select id,typeid,losttype,title,description,placeid,publishtime,losttime,photo,ishandled" +
            " from thelost_unhandled order by publishtime desc limit #{start},#{end}")
    @Options(useCache = false)
    public ArrayList<Lost> getLost(@Param("start") int start, @Param("end") int end) throws Exception;


    /**
     * <p>根据losttype获取lost的列表</p>
     * @param losttype 招领或者失物类型 0 失物  1 招领
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
    @Select("select id,typeid,losttype,title,description,placeid,publishtime,losttime,photo,ishandled" +
            " from thelost_unhandled where losttype=#{losttype} order by publishtime desc limit #{start},#{end}")
    @Options(useCache = false)
    public ArrayList<Lost> getLostByLostType(@Param("losttype") int losttype, @Param("start") int start, @Param("end") int end) throws Exception;

    /**
     * <p>根据用户获取lost的列表</p>
     * @param user 用户
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
     @Select("select id,typeid,losttype,title,description,placeid,publishtime,losttime,photo,ishandled" +
            " from thelost_unhandled where id in (select lostid from user_lost where username=#{user.username}) " +
            "order by publishtime desc limit #{start},#{end}")
     @Options(useCache = false)
    public ArrayList<Lost> getLostByUser(@Param("user") User user, @Param("start") int start, @Param("end") int end) throws Exception;

     /**
     * <p>根据用户获取lost的列表</p>
     * @param user 用户
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
     @Select("select id,typeid,losttype,title,description,placeid,publishtime,losttime,photo,ishandled" +
            " from thelost_handled where id in (select lostid from user_lost where username=#{user.username}) " +
            "order by publishtime desc limit #{start},#{end}")
     @Options(useCache = false)
     public ArrayList<Lost> getLostByUserAndHandled(@Param("user") User user, @Param("start") int start, @Param("end") int end) throws Exception;

    /**
     * <p>根据用户和losttype获取lost的列表</p>
     * @param user 用户
     * @param losttype 招领或者失物类型 0 失物  1 招领
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
     @Select("select id,typeid,losttype,title,description,placeid,publishtime,losttime,photo,ishandled" +
            " from thelost where losttype=#{losttype} and id in (select lostid from user_lost where username=#{user.username}) " +
            "order by publishtime desc limit #{start},#{end}")
     @Options(useCache = false)
    public ArrayList<Lost> getLostByUserAndLostType(@Param("user") User user, @Param("losttype") int losttype, @Param("start") int start, @Param("end") int end) throws Exception;


    /**
     * <p>添加失物</p>
     * @param lost 失物
     * */
    @Insert("insert into thelost(typeid,losttype,title,description,placeid,publishtime,losttime,photo,ishandled) values" +
            "(#{lost.typeid},#{lost.losttype},#{lost.title},#{lost.description},#{lost.placeid},#{lost.publishtime},#{lost.losttime},#{lost.photo},#{lost.ishandled})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "lost.id", before = false, resultType = Integer.class)
    public void insertLost(@Param("lost") Lost lost) throws Exception;

    /**
     * <p>添加用户——失物</p>
     * @param user 用户
     * @param lostid 失物id
     * */
    @Insert("insert into user_lost(username,lostid) values(#{user.username},#{lostid})")
    public void insertUserLost(@Param("user") User user, @Param("lostid") int lostid) throws Exception;

    /**
     * 更新用户照片名
     * @param thelost
     * */
    @Update("update thelost set photo=#{thelost.photo} where id=#{thelost.id}")
    public void updatePhoto(@Param("thelost") Lost thelost);




}
