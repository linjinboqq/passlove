package cn.edu.cqupt.nmid.passloveserver.v1.service;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Place;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Type;

import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 12:21
 *****/
public interface InfoService {
    /**
     * @description 获取所有的丢失类型
     * @return
     * */
    public List<Type> getTypes() throws Exception;

    /**
     * 获取所有的地点信息
     * @return
     * */
    public List<Place> getPlaces() throws Exception;
}
