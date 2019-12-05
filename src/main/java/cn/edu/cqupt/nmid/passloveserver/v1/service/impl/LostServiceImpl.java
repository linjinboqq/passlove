package cn.edu.cqupt.nmid.passloveserver.v1.service.impl;

import cn.edu.cqupt.nmid.passloveserver.util.SendSmsUtil;
import cn.edu.cqupt.nmid.passloveserver.v1.dao.CommentDao;
import cn.edu.cqupt.nmid.passloveserver.v1.dao.LostDao;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Lost;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import cn.edu.cqupt.nmid.passloveserver.v1.service.LostService;
import cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper.ThelostMapper;
import cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper.UserLostMapper;
import cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper.UserMapper;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.Thelost;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserExample;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserLost;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserLostExample;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 12:27
 *****/
@Service
public class LostServiceImpl implements LostService {

    @Resource(name = "sdf")
    private SimpleDateFormat sdf;

    @Resource
    private CommentDao commentDao;

    @Resource
    private LostDao lostDao;
    @Autowired
    ThelostMapper thelostMapper;
    @Autowired
    UserLostMapper UserLostMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    SendSmsUtil smsUtil;

    /**
     * <p>根据‘我’评论过的启事的所有id</p>
     *
     * @param user 用户
     * @return
     */
    @Override
    public List<Integer> getLostIDsUserComented(User user) throws Exception {
        return commentDao.getLostIDs(user);
    }

    /**
     * @param user  用户
     * @param start
     * @param end
     * @return
     * @description 获取‘我’的发布
     */
    @Override
    public List<Lost> getLostsUserPublished(User user, int start, int end) throws Exception {
        return lostDao.getLostByUser(user, start, end);
    }

    /**
     * @param user  用户
     * @param start
     * @param end
     * @return
     * @description 获取‘我’的历史
     */
    @Override
    public List<Lost> getLostsUserHistory(User user, int start, int end) throws Exception {
        return lostDao.getLostByUserAndHandled(user, start, end);
    }


    //    bylinjinbo
    public boolean Updateishandle(int lostid) {
        return lostDao.updateHandle(lostid);
    }

    /**
     * @param user   用户
     * @param lost   失物
     * @param photos
     * @param path
     * @description 发布失物
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void publishLost(User user, Lost lost, MultipartFile[] photos, String path) throws Exception {
        String fnames = "";
        File[] files = null;
        int length = 0;
        if (photos != null) {
            length = photos.length;
            files = new File[length];
            lost.setPublishtime(sdf.format(System.currentTimeMillis()));
            lostDao.insertLost(lost);
            for (int i = 0; i < length; i++) {
                if (!photos[i].isEmpty()) {
                    String name = photos[i].getOriginalFilename(); //获取原文件名
                    String phototype = name.substring(name.lastIndexOf("."), name.length()); //图片后缀
                    String filename = lost.getId() + "_" + i + phototype;
                    if (i == length - 1) {
                        fnames += filename;
                    } else {
                        fnames += filename + ",";
                    }
                    File file = new File(path, filename); //新文件
                    files[i] = file;
                }
            }
        } else {
            lost.setPublishtime(sdf.format(System.currentTimeMillis()));
            lostDao.insertLost(lost);
        }

        lost.setPhoto(fnames);
        lostDao.updatePhoto(lost);
        lostDao.insertUserLost(user, lost.getId());
        for (int i = 0; i < length; i++) {
//            ossClient.putObject("passlove", "thelost/" + files[i].getName(), photos[i].getInputStream()); //oss上传
            photos[i].transferTo(files[i]);
        }
    }


//  bylinjinbo  删除失物  //图片还没有删除呢

    @Transactional(rollbackFor = {Exception.class})
    public void deleteLostById(int lostid) throws Exception {
        thelostMapper.deleteByPrimaryKey(lostid);
        UserLostExample userLostExample = new UserLostExample();
        userLostExample.createCriteria().andLostidEqualTo(lostid);
        UserLostMapper.deleteByExample(userLostExample);
    }


    //    bylinjinbo
    @Transactional(rollbackFor = {Exception.class})
    public void publishLostUpdate(User user, Lost lost, MultipartFile[] photos, String path, int lostid) throws Exception {
        lost.setId(lostid);
        String fnames = "";
        File[] files = null;
        int length = 0;
        Thelost thelost = new Thelost();
        thelost.setId(lostid);
        Integer losttype = lost.getLosttype();
        thelost.setLosttype(losttype);
        int i1 = lost.getTypeid().intValue();
        thelost.setTypeid((short) i1);
        String title = lost.getTitle();
        thelost.setTitle(title);
        int i2 = lost.getPlaceid().intValue();
        thelost.setTypeid((short) i2);
        String description = lost.getDescription();
        thelost.setDescription(description);
        String publishtime = lost.getPublishtime();
        thelost.setPublishtime(publishtime);
        String losttime = lost.getLosttime();
        String photo = lost.getPhoto();
        Integer ishandled = lost.getIshandled();
        thelost.setLosttime(losttime);
        thelost.setPhoto(photo);
        thelost.setIshandled(ishandled);
        thelost.setId(lostid);
        thelostMapper.updateByPrimaryKeySelective(thelost);
        if (photos != null) {
            length = photos.length;
            files = new File[length];
            lost.setPublishtime(sdf.format(System.currentTimeMillis()));
//        lostDao.insertLost(lost);
            thelostMapper.updateByPrimaryKeySelective(thelost);
            for (int i = 0; i < length; i++) {
                if (!photos[i].isEmpty()) {
                    String name = photos[i].getOriginalFilename(); //获取原文件名
                    String phototype = name.substring(name.lastIndexOf("."), name.length()); //图片后缀
                    String filename = lost.getId() + "_" + i + phototype;
                    if (i == length - 1) {
                        fnames += filename;
                    } else {
                        fnames += filename + ",";
                    }
                    File file = new File(path, filename); //新文件
                    files[i] = file;
                }
            }
        } else {
            lost.setPublishtime(sdf.format(System.currentTimeMillis()));
//        lostDao.insertLost(lost);
            thelostMapper.updateByPrimaryKeySelective(thelost);
        }
        lost.setPhoto(fnames);
        lostDao.updatePhoto(lost);
//        lostDao.insertUserLost(user, lost.getId());

        for (int i = 0; i < length; i++) {
//            ossClient.putObject("passlove", "thelost/" + files[i].getName(), photos[i].getInputStream()); //oss上传
            photos[i].transferTo(files[i]);
        }
    }

    //    bylinjinbo  发短信 还没搞模板
    public void sendmessage(User user, int lostid) throws Exception {
        UserLostExample userLostExample = new UserLostExample();
        userLostExample.createCriteria().andLostidEqualTo(lostid);
        List<UserLost> userLosts = UserLostMapper.selectByExample(userLostExample);
        UserLost userLost = userLosts.get(0);
        String username = userLost.getUsername();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<cn.edu.cqupt.nmid.passloveserver.v2.pojo.User> users = userMapper.selectByExample(userExample);
        String phonenumber = users.get(0).getPhonenumber();
        String username1 = user.getUsername();
        smsUtil.sendSms("23212", phonenumber);
    }
}
