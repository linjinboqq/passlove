package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.DynamicsHistory;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.DynamicsHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicsHistoryMapper {
    long countByExample(DynamicsHistoryExample example);

    int deleteByExample(DynamicsHistoryExample example);

    int insert(DynamicsHistory record);

    int insertSelective(DynamicsHistory record);

    List<DynamicsHistory> selectByExample(DynamicsHistoryExample example);

    int updateByExampleSelective(@Param("record") DynamicsHistory record, @Param("example") DynamicsHistoryExample example);

    int updateByExample(@Param("record") DynamicsHistory record, @Param("example") DynamicsHistoryExample example);
}