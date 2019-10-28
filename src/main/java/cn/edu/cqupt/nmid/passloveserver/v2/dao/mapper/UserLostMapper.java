package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserLost;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserLostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLostMapper {
    long countByExample(UserLostExample example);

    int deleteByExample(UserLostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserLost record);

    int insertSelective(UserLost record);

    List<UserLost> selectByExample(UserLostExample example);

    UserLost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserLost record, @Param("example") UserLostExample example);

    int updateByExample(@Param("record") UserLost record, @Param("example") UserLostExample example);

    int updateByPrimaryKeySelective(UserLost record);

    int updateByPrimaryKey(UserLost record);
}