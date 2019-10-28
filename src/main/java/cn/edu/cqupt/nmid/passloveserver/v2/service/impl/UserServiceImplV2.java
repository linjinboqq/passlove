package cn.edu.cqupt.nmid.passloveserver.v2.service.impl;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import cn.edu.cqupt.nmid.passloveserver.v1.service.UserService;
import cn.edu.cqupt.nmid.passloveserver.util.PojoUtil;
import cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper.UserMapper;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserExample;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * \* Author: MrWangx
 * \* Date: 2019/4/19
 * \* Time: 21:16
 * \* Description:
 **/
@Service
public class UserServiceImplV2 implements UserService {

    @Resource
    private UserMapper userMapper;


    /**
     * @param username 用户名
     * @param password 密码
     * @return 返回登录的用户, 如果用户名和密码不对, 返回User=null
     * @description 用户登录
     */
    @Override
    public User login(String username, String password) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<cn.edu.cqupt.nmid.passloveserver.v2.pojo.User> users = userMapper.selectByExample(userExample);
        return users.isEmpty() ? null : new User(users.get(0));

    }

    /**
     * @param user 注册用户的实体
     * @description 用户注册
     */
    @Override
    public void register(User user) throws Exception {
        cn.edu.cqupt.nmid.passloveserver.v2.pojo.User userV2 = (cn.edu.cqupt.nmid.passloveserver.v2.pojo.User) PojoUtil.convert(user, user.getClass(), cn.edu.cqupt.nmid.passloveserver.v2.pojo.User.class);
        userMapper.insert(userV2);
    }

    /**
     * @param mail 邮箱是否被注册
     * @description 检查邮箱是否被注册
     */
    @Override
    public boolean isRegistered(String mail) throws Exception {
        return userMapper.selectByPrimaryKey(mail) == null;
    }

    /**
     * @param user     用户
     * @param nickname 修改的名称
     * @description 修改用户名称
     */
    @Override
    public void updateUserNickname(User user, String nickname) throws Exception {
        cn.edu.cqupt.nmid.passloveserver.v2.pojo.User userV2 = new cn.edu.cqupt.nmid.passloveserver.v2.pojo.User();
        userV2.setUsername(user.getUsername());
        userV2.setNickname(nickname);
        userMapper.updateByPrimaryKeySelective(userV2);
    }


    /**
     * 修改用户头像
     *
     * @param user     用户
     * @param photo    上传的photo
     * @param savepath 存储位置
     */
    @Override
    public void updateUserPhoto(User user, MultipartFile photo, String savepath) throws Exception {
        String name = photo.getOriginalFilename();
        String phototype = name.substring(name.lastIndexOf("."), name.length()); //图片后缀
        String filename = user.getUsername() + phototype; //图片名
        File file = new File(savepath, filename);
        if(file.exists()) {
            file.deleteOnExit();
        }
        photo.transferTo(file);
        cn.edu.cqupt.nmid.passloveserver.v2.pojo.User userV2 = new cn.edu.cqupt.nmid.passloveserver.v2.pojo.User();
        userV2.setUsername(user.getUsername());
        userV2.setPhoto(filename);
        userMapper.updateByPrimaryKeySelective(userV2);
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
        cn.edu.cqupt.nmid.passloveserver.v2.pojo.User userV2 = new cn.edu.cqupt.nmid.passloveserver.v2.pojo.User();
        userV2.setUsername(user.getUsername());
        userV2.setPhonenumber(phonenumber);
        userMapper.updateByPrimaryKeySelective(userV2);
    }
}
