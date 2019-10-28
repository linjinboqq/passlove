package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Replyp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * \* Author: MrWangx
 * \* Date: 2019/4/21
 * \* Time: 23:49
 * \* Description:
 **/
@Mapper
public interface ReplypDao {

    /**
     * 根据ucid获取评论
     * @param ucid
     * @return
     */
    @Select("select * from replyp where ucid=#{ucid}")
    @Options(useCache = false)
    List<Replyp> getReplypsByUCID(@Param("ucid") int ucid);

    /**
     * 根据ucid获取评论
     * @param replyId
     * @return
     */
    @Select("select * from replyp where reply_id=#{reply_id}")
    @Options(useCache = false)
    List<Replyp> getReplypsByReplyID(@Param("reply_id") int replyId);

}
