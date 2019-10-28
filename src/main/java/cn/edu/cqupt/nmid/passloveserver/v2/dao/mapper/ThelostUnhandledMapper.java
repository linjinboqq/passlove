package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.ThelostUnhandled;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.ThelostUnhandledExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThelostUnhandledMapper {
    long countByExample(ThelostUnhandledExample example);

    int deleteByExample(ThelostUnhandledExample example);

    int insert(ThelostUnhandled record);

    int insertSelective(ThelostUnhandled record);

    List<ThelostUnhandled> selectByExample(ThelostUnhandledExample example);

    int updateByExampleSelective(@Param("record") ThelostUnhandled record, @Param("example") ThelostUnhandledExample example);

    int updateByExample(@Param("record") ThelostUnhandled record, @Param("example") ThelostUnhandledExample example);
}