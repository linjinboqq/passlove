package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.Thelost;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.ThelostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThelostMapper {
    long countByExample(ThelostExample example);

    int deleteByExample(ThelostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Thelost record);

    int insertSelective(Thelost record);

    List<Thelost> selectByExample(ThelostExample example);

    Thelost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Thelost record, @Param("example") ThelostExample example);

    int updateByExample(@Param("record") Thelost record, @Param("example") ThelostExample example);

    int updateByPrimaryKeySelective(Thelost record);

    int updateByPrimaryKey(Thelost record);
}