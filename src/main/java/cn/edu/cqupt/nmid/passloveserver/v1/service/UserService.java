package cn.edu.cqupt.nmid.passloveserver.v1.service;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import org.springframework.web.multipart.MultipartFile;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 12:10
 *****/
public interface UserService {

    /**
     * @description 用户登录
     * @return 返回登录的用户,如果用户名和密码不对,返回User=null
     * @param username 用户名
     * @param password 密码
     * */
    public User login(String username, String password) throws Exception;

    public User login2(int snumber, String password) throws Exception;
    /**
     * @description 用户注册
     * @param user 注册用户的实体
     * */
    public void register(User user) throws Exception;


    /**
     * @description 检查邮箱是否被注册
     * @param mail 邮箱是否被注册
     * */
    public boolean isRegistered(String mail) throws Exception;


    /**
     * @description 修改用户名称
     * @param user 用户
     * @param nickname 修改的名称
     * */
    public void updateUserNickname(User user, String nickname) throws Exception;


    /**
     *  修改用户头像
     * @param user 用户
     * @param photo 上传的photo
     * @param savepath 存储位置
     * */
    public void updateUserPhoto(User user, MultipartFile photo, String savepath) throws Exception;


    /**
     *  修改用户头像
     * @param user 用户
     * @param phonenumber 电话号码
     * */
    public void updateUserPhonenumber(User user, String phonenumber) throws Exception;


}
