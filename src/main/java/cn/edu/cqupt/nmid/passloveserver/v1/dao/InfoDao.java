package cn.edu.cqupt.nmid.passloveserver.v1.dao;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Place;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InfoDao {


    /**
     * 获取所有的丢失类型信息
     * @return
     * */
    @Select("select id,name,photo from type")
    @Options(useCache = false)
    public List<Type> getTypes() throws Exception;

    /**
     * 获取所有的地点信息
     * @return
     * */
    @Select("select id,name from place")
    @Options(useCache = false)
    public List<Place> getPlaces() throws Exception;

}
