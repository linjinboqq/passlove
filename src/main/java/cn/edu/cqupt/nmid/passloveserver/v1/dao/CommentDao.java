package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Comment;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDao {

    /**
     * <p>添加评论</p>
     * @param comment 评论
     * */
    @Insert("insert into comment(id,time,content) values(#{comment.id},#{comment.time},#{comment.content})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "comment.id", before = false, resultType = Integer.class)
    void insertComment(@Param("comment") Comment comment);

    /**
     * <p>添加关联到user_lost_comment</p>
     * @param username 用户名
     * @param lostid 失物的id
     * @param commentid 评论的id
     * */
    @Insert("insert into user_lost_comment(username, lostid, commentid) values(#{username},#{lostid},#{commentid})")
    void insertUserLostComent(@Param("username") String username, @Param("lostid") int lostid, @Param("commentid") Integer commentid);

    /**
     * <p>获取我评论过的启事的所有id</p>
     * @param user 用户
     * */
    @Select("select lostid from user_lost_comment where username=#{user.username}")
    @Options(useCache = false)
    List<Integer> getLostIDs(@Param("user") User user);

    @Insert("insert into comment_reply(username, commentid, ucid, reply_id) values(#{username},#{commentid},#{ucid},#{reply_id})")
    void replyComment(@Param("username") String username, @Param("commentid") int commentId, @Param("ucid") Integer ucId, @Param("reply_id") Integer replyId);

}
