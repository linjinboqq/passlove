package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserLostComment;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserLostCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLostCommentMapper {
    long countByExample(UserLostCommentExample example);

    int deleteByExample(UserLostCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLostComment record);

    int insertSelective(UserLostComment record);

    List<UserLostComment> selectByExample(UserLostCommentExample example);

    UserLostComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLostComment record, @Param("example") UserLostCommentExample example);

    int updateByExample(@Param("record") UserLostComment record, @Param("example") UserLostCommentExample example);

    int updateByPrimaryKeySelective(UserLostComment record);

    int updateByPrimaryKey(UserLostComment record);
}