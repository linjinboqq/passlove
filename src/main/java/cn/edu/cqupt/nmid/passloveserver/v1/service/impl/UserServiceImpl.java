package cn.edu.cqupt.nmid.passloveserver.v1.service.impl;

import cn.edu.cqupt.nmid.passloveserver.v1.dao.UserDao;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import cn.edu.cqupt.nmid.passloveserver.v1.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.UUID;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 12:23
 *****/
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;

    /**
     * @param username 用户名
     * @param password 密码
     * @return 返回登录的用户, 如果用户名和密码不对, 返回User=null
     * @description 用户登录
     */
    @Override
    public User login(String username, String password) throws Exception {
        return userDao.getUserByUP(username, password);
    }


    @Override
    public User login2(int snumber, String password) throws Exception {
       String  username=  userDao.selectUserNameBysNumber(snumber);
        return userDao.getUserByUP(username, password);
    }

    /**
     * @param user 注册用户的实体
     * @description 用户注册
     */
    @Override
    public void register(User user) throws Exception {
        userDao.insertUser(user);
    }


    public void register2(User user ,int snumber) throws Exception {
        userDao.insertUser(user);
        userDao.insertsnumber(user.getUsername(),snumber);
    }


    /**
     * @param mail 邮箱是否被注册
     * @description 检查邮箱是否被注册
     */
    @Override
    public boolean isRegistered(String mail) throws Exception {
        return userDao.getUserCount(mail) > 0;
    }

    /**
     * @param user     用户
     * @param nickname 修改的名称
     * @description 修改用户名称
     */
    @Override
    public void updateUserNickname(User user, String nickname) throws Exception {
        userDao.updateNickname(user, nickname);
    }

    @Override
    public void updateUserPhoto(User user, String url) throws Exception {
        int i = userDao.updatePhoto(user.getUsername(), url);
        System.out.println(i);
    }

    /**
     * 修改用户头像
     *
     * @param user     用户
     * @param photo    上传的photo
     * @param savepath 存储位置
     */
//    @Override
    public void updateUserPhoto(User user, MultipartFile photo, String savepath) throws Exception {
        String name = photo.getOriginalFilename(); //获取原文件名
        String phototype = name.substring(name.lastIndexOf("."), name.length()); //图片后缀
        String filename = user.getUsername() + phototype; //图片名
        File file = new File(savepath, filename);
        if(file.exists()) {
            file.deleteOnExit();
        }
        photo.transferTo(file);
//        ossClient.putObject("passlove", "user/" + filename, photo.getInputStream()); //oss上传图片
        userDao.updatePhoto(user.getUsername(), filename);
        user.setPhoto(filename);
    }

    /**
     * 修改用户电话号码
     *
     * @param user        用户
     * @param phonenumber 电话号码
     */
    @Override
    public void updateUserPhonenumber(User user, String phonenumber) throws Exception {
        userDao.updatePhoneNumber(user, phonenumber);
    }

//by linjinbo

    public int updateUserPassword(User user, String password) throws Exception {
        int i = userDao.updatePassword(user, password);
        return i;

    }

}
