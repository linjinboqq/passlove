package cn.edu.cqupt.nmid.passloveserver.v1.service.impl;

import cn.edu.cqupt.nmid.passloveserver.v1.dao.CommentDao;
import cn.edu.cqupt.nmid.passloveserver.v1.dao.CommentpDao;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Comment;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Commentp;
import cn.edu.cqupt.nmid.passloveserver.v1.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 13:29
 *****/
@Service
public class CommentServiceImpl implements CommentService {

    @Resource(name = "sdf")
    private SimpleDateFormat sdf;

    @Resource
    private CommentpDao commentpDao;

    @Resource
    private CommentDao commentDao;

    /**
     * <p>根据失物id获取它的所有评论</p>
     *
     * @param lostid 失物id
     * @return
     */
    @Override
    public List<Commentp> getCommentsByID(int lostid) throws Exception {
        return commentpDao.getCommentpByLostid(lostid);
    }

    /**
     * @param username 用户名
     * @param lostid   失物id
     * @param comment  评论
     * @description 发表评论
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void publishComment(String username, Integer lostid, Comment comment) throws Exception {
        comment.setTime(sdf.format(System.currentTimeMillis()));
        commentDao.insertComment(comment);
        commentDao.insertUserLostComent(username, lostid, comment.getId());
        commentDao.insertisread(comment.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void replyComment(String username, Integer ucId, Integer replyId, Comment comment) throws Exception {
        comment.setTime(sdf.format(System.currentTimeMillis()));
        commentDao.insertComment(comment);
        if (ucId != null && replyId == null) {
            commentDao.replyComment(username, comment.getId(), ucId, replyId);
        } else if (ucId == null && replyId != null) {

            commentDao.replyComment(username, comment.getId(), ucId, replyId);
        } else {
            throw new Exception();
        }
    }


    //bylinjinbo
    public int getisread(int commentid) {
        return commentDao.selectisread(commentid);
    }

    public int updateisread(int isread,int commentid) {
        return commentDao.updateisread(isread,commentid);
    }
}
