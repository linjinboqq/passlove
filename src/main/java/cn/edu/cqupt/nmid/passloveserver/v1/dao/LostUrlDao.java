package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LostUrlDao {
    @Insert("INSERT into lost_url (lostid,url)VALUES(#{lostid},#{url})")
    int insertlosturl(@Param("lostid") int lostid, @Param("url")String url);

}
