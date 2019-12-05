package cn.edu.cqupt.nmid.passloveserver.v1.service.impl;

import cn.edu.cqupt.nmid.passloveserver.v1.dao.DynamicsDao;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Dynamics;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import cn.edu.cqupt.nmid.passloveserver.v1.service.DynamicsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 12:30
 *****/
@Service
public class DynamicsServiceImpl implements DynamicsService {

    @Resource
    private DynamicsDao dynamicsDao;

    /**
     * @param start
     * @param end
     * @param losttype 丢失或者招领 0 丢失 | 1 招领
     * @return 返回动态
     * @description 获取指定数量的动态
     */
    @Override
    public List<Dynamics> getDynamicsByLosttype(int start, int end, int losttype) throws Exception {
        return dynamicsDao.getDynamics(losttype, start, end);
    }



//bylinjinbo
    public List<Dynamics> getDynamicsByLosttypeAndYesterday(int start, int end, int losttype,int yesterday) throws Exception {
      String yesterday2=new String();
       if(yesterday==0){
           Date date =new Date(); //取时间
           Calendar calendar = new GregorianCalendar();
           calendar.setTime(date);
           calendar.add(calendar.DATE,-1); //把日期往后增加一天,整数  往后推,负数往前移动
           date=calendar.getTime(); //这个时间就是日期往后推一天的结果
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
           String format = simpleDateFormat.format(date);
           System.out.println(format);
           yesterday2=format;
           yesterday2=yesterday2+"%";
           return dynamicsDao.getDynamicsByYesterday(losttype, start, end,yesterday2);
//转换日期

       }else if(yesterday==1){
           Date date =new Date(); //取时间
           Calendar calendar = new GregorianCalendar();
           calendar.setTime(date);
//           calendar.add(calendar.DATE,-1); //把日期往后增加一天,整数  往后推,负数往前移动
           date=calendar.getTime(); //这个时间就是日期往后推一天的结果
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
           String format = simpleDateFormat.format(date);
           System.out.println(format);
           yesterday2=format;
           yesterday2=yesterday2+"%";

           return dynamicsDao.getDynamicsByYesterday(losttype, start, end,yesterday2);

       }else if (yesterday==2){
           Date date =new Date(); //取时间
           Calendar calendar = new GregorianCalendar();
           calendar.setTime(date);
//           calendar.add(calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动
           calendar.add(calendar.DATE,-1); //把日期往后增加一天,整数  往后推,负数往前移动
           date=calendar.getTime(); //这个时间就是日期往后推一天的结果
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
           String format = simpleDateFormat.format(date);
           System.out.println(format);
           yesterday2=format;
           return dynamicsDao.getDynamicsByYesterday2(losttype, start, end,yesterday2);
       }
//
        return null;
    }




//    bylinjinbo


    /**
     * @param lostid 失物的id
     * @return
     * @description 根据id获得动态
     */
    @Override
    public Dynamics getDynamicsByLostID(int lostid) throws Exception {
        return dynamicsDao.getDynamicsByID(lostid);
    }

    /**
     * @param user 用户
     * @return
     * @description 获取我评论过的动态
     */
    @Override
    public List<Dynamics> getDynamicsUserCommented(User user) throws Exception {
        return dynamicsDao.getDynamicsCommented(user);
    }

    /**
     * <p>根据属性搜索动态</p>
     *
     * @param keyword
     * @param losttype 招领或者失物类型 0 失物  1 招领
     * @param typeid   丢失物品类型id
     * @param placeid  地点id
     * @param start    开始数据位置
     * @param end      结束记录位置
     * @return
     */
    @Override
    public List<Dynamics> searchDynamics(String keyword, Integer losttype, Integer typeid, Integer placeid, Integer start, Integer end) throws Exception {
        if (!keyword.matches("^ \\S+ $")) {
            keyword = "%" + keyword + "%";
        }
        return dynamicsDao.getDynamicsByProperties(keyword, losttype, typeid, placeid, start, end);
    }
}
