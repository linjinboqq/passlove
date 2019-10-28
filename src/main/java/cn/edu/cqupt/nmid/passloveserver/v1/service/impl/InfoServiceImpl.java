package cn.edu.cqupt.nmid.passloveserver.v1.service.impl;

import cn.edu.cqupt.nmid.passloveserver.v1.dao.InfoDao;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Place;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Type;
import cn.edu.cqupt.nmid.passloveserver.v1.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 13:28
 *****/
@Service
public class InfoServiceImpl implements InfoService {

    @Resource
    private InfoDao infoDao;

    /**
     * @return
     * @description 获取所有的丢失类型
     */
    @Override
    public List<Type> getTypes() throws Exception {
        return infoDao.getTypes();
    }

    /**
     * 获取所有的地点信息
     *
     * @return
     */
    @Override
    public List<Place> getPlaces() throws Exception {
        return infoDao.getPlaces();
    }
}
