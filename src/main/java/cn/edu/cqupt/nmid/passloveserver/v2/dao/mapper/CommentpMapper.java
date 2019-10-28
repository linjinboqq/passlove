package cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper;

import cn.edu.cqupt.nmid.passloveserver.v2.pojo.Commentp;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.CommentpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentpMapper {
    long countByExample(CommentpExample example);

    int deleteByExample(CommentpExample example);

    int insert(Commentp record);

    int insertSelective(Commentp record);

    List<Commentp> selectByExample(CommentpExample example);

    int updateByExampleSelective(@Param("record") Commentp record, @Param("example") CommentpExample example);

    int updateByExample(@Param("record") Commentp record, @Param("example") CommentpExample example);
}