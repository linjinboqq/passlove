package cn.edu.cqupt.nmid.passloveserver.v1.service;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Lost;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 12:16
 *****/
public interface LostService {

    /**
     * <p>根据‘我’评论过的启事的所有id</p>
     * @param user 用户
     * @return
     * */
    public List<Integer> getLostIDsUserComented(User user) throws Exception;

    /**
     * @description 获取‘我’的发布
     * @param user 用户
     * @param start
     * @param end
     * @return
     * */
    public List<Lost> getLostsUserPublished(User user, int start, int end) throws Exception;

    /**
     * @description 获取‘我’的历史
     * @param user 用户
     * @param start
     * @param end
     * @return
     * */
    public List<Lost> getLostsUserHistory(User user, int start, int end) throws Exception;


    /**
     * @description 发布失物
     * @param user 用户
     * @param lost 失物
     * */
    public void publishLost(User user, Lost lost, MultipartFile[] photos, String path) throws Exception;

}
