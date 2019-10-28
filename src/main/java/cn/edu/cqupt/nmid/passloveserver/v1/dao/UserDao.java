package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    /**
     * <p>根据用户名密码获取用户实体信息</p>
     * @param username 用户名
     * @param password 密码
     * @return 返回用户实体
     * */
    @Select("select username,password,nickname,photo,phonenumber from user where username=#{username} and password=#{password}")
    @Options(useCache = false)
    public User getUserByUP(@Param("username") String username, @Param("password") String password) throws Exception;

    /**
     * <p>检查用户名是否存在</p>
     * @param username 用户名
     * @return 返回用户实体
     * */
    @Select("select count(*) from user where username=#{username}")
    @Options(useCache = false)
    public int getUserCount(@Param("username") String username) throws Exception;

    /**
     * <p>添加用户</p>
     * @param user 添加的用户实体
     * */
    @Insert("insert into user(username,password,nickname,photo,phonenumber) values(#{username},#{password},#{nickname},#{photo},#{phonenumber})")
    public void insertUser(User user) throws Exception;

    /**
     * <p>修改用户名称</p>
     * @param user 用户
     * */
    @Update("update user set nickname=#{nickname} where username=#{user.username} and password=#{user.password}")
    @SelectKey(statement = "select nickname from user where username=#{user.username}", keyProperty = "user.nickname", before = false, resultType = String.class)
    public void updateNickname(@Param("user") User user, @Param("nickname") String nickname) throws Exception;

    /**
     * <p>修改用户头像图片名称</p>
     * @param username 用户名
     * @param photo 照片名
     * */
    @Update("update user set photo=#{photo} where username=#{username}")
    public void updatePhoto(@Param("username") String username, @Param("photo") String photo);

    @Update("update user set phonenumber=#{phonenumber} where username=#{user.username}")
    @SelectKey(statement = "select phonenumber from user where username=#{user.username}", keyProperty = "user.phonenumber", before = false, resultType = String.class)
    public void updatePhoneNumber(@Param("user") User user, @Param("phonenumber") String phonenumber);


}
