package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.ThelostHandled;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.ThelostHandledExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThelostHandledMapper {
    long countByExample(ThelostHandledExample example);

    int deleteByExample(ThelostHandledExample example);

    int insert(ThelostHandled record);

    int insertSelective(ThelostHandled record);

    List<ThelostHandled> selectByExample(ThelostHandledExample example);

    int updateByExampleSelective(@Param("record") ThelostHandled record, @Param("example") ThelostHandledExample example);

    int updateByExample(@Param("record") ThelostHandled record, @Param("example") ThelostHandledExample example);
}