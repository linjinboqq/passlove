package cn.edu.cqupt.nmid.passloveserver.v1.service;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Dynamics;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;

import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 12:05
 *****/
public interface DynamicsService {

    /**
     * @description 获取指定数量的动态
     * @param start
     * @param end
     * @param losttype 丢失或者招领 0 丢失 | 1 招领
     * @return 返回动态
     * */
    public List<Dynamics> getDynamicsByLosttype(int start, int end, int losttype) throws Exception;


    /**
     * @description 根据id获得动态
     * @param lostid 失物的id
     * @return
     */
    public Dynamics getDynamicsByLostID(int lostid) throws Exception;



    /**
     * @description 获取我评论过的动态
     * @param user 用户
     * @return
     */
    public List<Dynamics> getDynamicsUserCommented(User user) throws Exception;


    /**
     * <p>根据属性搜索动态</p>
     * @param losttype 招领或者失物类型 0 失物  1 招领
     * @param typeid 丢失物品类型id
     * @param placeid 地点id
     * @param start 开始数据位置
     * @param end 结束记录位置
     * @return
     * */
    public List<Dynamics> searchDynamics(String keyword, Integer losttype, Integer typeid, Integer placeid, Integer start, Integer end) throws Exception;


}
