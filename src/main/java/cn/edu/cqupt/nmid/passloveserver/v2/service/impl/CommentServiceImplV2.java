package cn.edu.cqupt.nmid.passloveserver.v2.service.impl;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Comment;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Commentp;
import cn.edu.cqupt.nmid.passloveserver.v1.service.CommentService;

import java.util.List;

/**
 * \* Author: MrWangx
 * \* Date: 2019/4/19
 * \* Time: 21:15
 * \* Description:
 **/
public class CommentServiceImplV2 implements CommentService {

    @Override
    public List<Commentp> getCommentsByID(int lostid) throws Exception {

        return null;
    }

    @Override
    public void publishComment(String username, Integer lostid, Comment comment) throws Exception {

    }

    /**
     * 回复评论
     *
     * @param username
     * @param ucId
     * @param replyId
     * @param comment
     * @return
     * @throws Exception
     */
    @Override
    public void replyComment(String username, Integer ucId, Integer replyId, Comment comment) throws Exception {

    }

}
