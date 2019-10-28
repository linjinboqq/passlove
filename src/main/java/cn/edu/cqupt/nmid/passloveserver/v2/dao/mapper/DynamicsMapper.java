package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.Dynamics;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.DynamicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicsMapper {
    long countByExample(DynamicsExample example);

    int deleteByExample(DynamicsExample example);

    int insert(Dynamics record);

    int insertSelective(Dynamics record);

    List<Dynamics> selectByExample(DynamicsExample example);

    int updateByExampleSelective(@Param("record") Dynamics record, @Param("example") DynamicsExample example);

    int updateByExample(@Param("record") Dynamics record, @Param("example") DynamicsExample example);
}