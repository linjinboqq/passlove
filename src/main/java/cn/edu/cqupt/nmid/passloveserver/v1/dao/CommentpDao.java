package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Commentp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentpDao {

    /**
     * <p>根据失物id获取它的所有评论</p>
     * @param lostid 失物id
     * */
    @Select("select * from commentp where lostid=#{lostid}")
    @Options(useCache = false)
    public List<Commentp> getCommentpByLostid(@Param("lostid") int lostid) throws Exception;

}
