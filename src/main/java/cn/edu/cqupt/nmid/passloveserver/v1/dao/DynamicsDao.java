package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import cn.edu.cqupt.nmid.passloveserver.v1.dao.sqlprovider.DynamicsSQLProvider;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Dynamics;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DynamicsDao {

    /**
     * <p>根据losttype获取动态</p>
     * @param losttype 招领或者失物类型 0 失物  1 招领
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
    @Select("select * from dynamics where losttype=#{losttype} limit #{start},#{end}")
    @Options(useCache = false)
    List<Dynamics> getDynamics(@Param("losttype") int losttype, @Param("start") int start, @Param("end") int end) throws Exception;

    /**
     * <p>根据启事的lostid获取启事的详细信息</p>
     * @param lostid 启事的id
     * @return
     * */
    @Select("select * from dynamics where id=#{lostid}")
    @Options(useCache = false)
    Dynamics getDynamicsByID(@Param("lostid") int lostid) throws Exception;

    /**
     * <p>根据属性搜索动态</p>
     * @param losttype 招领或者失物类型 0 失物  1 招领
     * @param typeid 丢失物品类型id
     * @param placeid 地点id
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
    @SelectProvider(type = DynamicsSQLProvider.class, method = "searchByPropertiesSql")
    @Options(useCache = false)
    List<Dynamics> getDynamicsByProperties(@Param("keyword") String keyword, @Param("losttype") Integer losttype, @Param("typeid") Integer typeid, @Param("placeid") Integer placeid, @Param("start") Integer start, @Param("end") Integer end) throws Exception;

    /**
     * <p>根据描述中的关键词查找动态</p>
     * @param keyword 关键词
     * @param start 开始数据位置
     * @param end 结束数据位置
     * @return
     * */
    @Select("select * from dynamics where description like #{keyword} limit #{start},#{end}")
    @Options(useCache = false)
    List<Dynamics> getDynamicsByKeyword(@Param("keyword") String keyword, @Param("start") int start, @Param("end") int end);

    /**
     * <p>获取我评论的动态</p>
     * @param user
     * @return
     * */
    @Select("select * from dynamics where id in (select lostid from user_lost_comment where username=#{user.username})")
    @Options(useCache = false)
    List<Dynamics> getDynamicsCommented(@Param("user") User user);

}
