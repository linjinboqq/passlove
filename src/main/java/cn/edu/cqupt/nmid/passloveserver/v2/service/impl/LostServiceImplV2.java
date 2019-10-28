package cn.edu.cqupt.nmid.passloveserver.v2.service.impl;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Lost;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import cn.edu.cqupt.nmid.passloveserver.v1.service.LostService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * \* Author: MrWangx
 * \* Date: 2019/4/19
 * \* Time: 21:16
 * \* Description:
 **/
public class LostServiceImplV2 implements LostService {

    /**
     * <p>根据‘我’评论过的启事的所有id</p>
     *
     * @param user 用户
     * @return
     */
    @Override
    public List<Integer> getLostIDsUserComented(User user) throws Exception {
        return null;
    }

    /**
     * @param user  用户
     * @param start
     * @param end
     * @return
     * @description 获取‘我’的发布
     */
    @Override
    public List<Lost> getLostsUserPublished(User user, int start, int end) throws Exception {
        return null;
    }

    /**
     * @param user  用户
     * @param start
     * @param end
     * @return
     * @description 获取‘我’的历史
     */
    @Override
    public List<Lost> getLostsUserHistory(User user, int start, int end) throws Exception {
        return null;
    }

    /**
     * @param user   用户
     * @param lost   失物
     * @param photos
     * @param path
     * @description 发布失物
     */
    @Override
    public void publishLost(User user, Lost lost, MultipartFile[] photos, String path) throws Exception {

    }
}
