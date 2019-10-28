package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.Replyp;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.ReplypExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplypMapper {
    long countByExample(ReplypExample example);

    int deleteByExample(ReplypExample example);

    int insert(Replyp record);

    int insertSelective(Replyp record);

    List<Replyp> selectByExample(ReplypExample example);

    int updateByExampleSelective(@Param("record") Replyp record, @Param("example") ReplypExample example);

    int updateByExample(@Param("record") Replyp record, @Param("example") ReplypExample example);
}