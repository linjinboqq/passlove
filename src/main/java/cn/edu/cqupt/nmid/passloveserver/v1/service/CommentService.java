package cn.edu.cqupt.nmid.passloveserver.v1.service;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Comment;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Commentp;

import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 11:58
 *****/
public interface CommentService {


    /**
     * <p>根据失物id获取它的所有评论</p>
     * @param lostid 失物id
     * @return
     * */
    public List<Commentp> getCommentsByID(int lostid) throws Exception;


    /**
     * @description 发表评论
     * @param username 用户名
     * @param lostid 失物id
     * @param comment 评论
     * */
    public void publishComment(String username, Integer lostid, Comment comment) throws Exception;


    /**
     * 回复评论
     * @return
     * @throws Exception
     */
    void replyComment(String username, Integer ucId, Integer replyId, Comment comment) throws Exception;

}
