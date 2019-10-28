package cn.edu.cqupt.nmid.passloveserver.v1.web.controller;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.*;
import cn.edu.cqupt.nmid.passloveserver.v1.service.*;
import cn.edu.cqupt.nmid.passloveserver.v1.service.mail.MailService;
import cn.edu.cqupt.nmid.passloveserver.util.CodeCheck;
import cn.edu.cqupt.nmid.passloveserver.v1.web.listener.LoginSessionContext;
import cn.edu.cqupt.nmid.passloveserver.v1.web.listener.RegisterSessionContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.util.List;

@Controller
public class PassLove {

    private Logger logger = LoggerFactory.getLogger(PassLove.class);

    @Resource
    private LoginSessionContext loginSessionContext;

    @Resource
    private RegisterSessionContext registerSessionContext;

    @Resource
    private MailService mailService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Resource
    private LostService lostService;

    @Resource
    private InfoService infoService;

    @Resource
    private DynamicsService dynamicsService;

    @Resource
    private CommentService commentService;




    /**                         用户相关*                         /
     /**--------------------------------------------------------------------------*/

    /**
     * @param requestData 请求json
     *                    username
     *                    password
     * @return 返回json数据
     * status: 200 登录成功 | 400 用户名或者密码不正确
     * message: 返回的提示信息
     * user: 用户的信息
     * @description 用户登录接口
     */
    @RequestMapping(path = "/passlove/loginIn", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String userLoginIn(@RequestParam String requestData, HttpSession session) throws Exception {
        JSONObject returnData = new JSONObject(true); //返回信息
        int status = 200;
        User user = null;
        try {
            logger.info(requestData);
            JSONObject json = JSON.parseObject(requestData);
            user = userService.login(json.getString("username"), json.getString("password")); //获取用户实体
            if (user != null) { //如果实体不为null
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(0); //设置session一直有效
                loginSessionContext.addSession(session);
            } else { //如果实体为null
                status = 400;
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("user", user);
        returnData.put("JSESSIONID", session.getId());
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }


    /**
     * @param JSESSIONID
     * @return 返回json数据
     * status: 200 退出登录成功 | 400 用户未登录
     * @description 用户退出登录接口
     */
    @RequestMapping(path = "/passlove/user/loginOut", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String userLoginOut(@RequestParam String JSESSIONID) throws Exception {

        JSONObject returnData = null; //返回信息
        int status = 200;
        try {
            returnData = new JSONObject(true);
            HttpSession session = loginSessionContext.getSession(JSESSIONID);
            if (session != null) {
                loginSessionContext.delSession(session);
                session.setMaxInactiveInterval(1);
            } else {
                status = 400;
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        return returnData.toJSONString();
    }

    /**
     * @param name 图片名
     * @description 获取用户头像
     */
    @RequestMapping(path = {"/passlove/img/user"})
    public void getUserPhoto(@RequestParam String name, HttpServletResponse response, HttpSession session) {
        try {
            ImageIO.write(ImageIO.read(new FileInputStream(session.getServletContext().getRealPath("/WEB-INF/img/user/" + name))),
                    name.substring(name.lastIndexOf(".") + 1, name.length()), response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name 图片名
     * @description 获取失物照片
     */
    @RequestMapping(path = {"/passlove/img/thelost"})
    public void getThelostPhoto(@RequestParam String name, HttpServletResponse response, HttpSession session) {
        try {
            ImageIO.write(ImageIO.read(new FileInputStream(session.getServletContext().getRealPath("/WEB-INF/img/thelost/" + name))),
                    name.substring(name.lastIndexOf(".") + 1, name.length()), response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name 图片名
     * @description 获取失物照片
     */
    @RequestMapping(path = {"/passlove/img/losttype"})
    public void getLosttypePhoto(@RequestParam String name, HttpServletResponse response, HttpSession session) {
        try {
            ImageIO.write(ImageIO.read(new FileInputStream(session.getServletContext().getRealPath("/WEB-INF/img/losttype/" + name))),
                    name.substring(name.lastIndexOf(".") + 1, name.length()), response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name 图片名
     * @description 获取失物照片
     */
    @RequestMapping(path = {"/passlove/img/losttype_char"})
    public void getLosttypeCharPhoto(@RequestParam String name, HttpServletResponse response, HttpSession session) {
        try {
            ImageIO.write(ImageIO.read(new FileInputStream(session.getServletContext().getRealPath("/WEB-INF/img/losttype_char/" + name))),
                    name.substring(name.lastIndexOf(".") + 1, name.length()), response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**                         用户注册*                         /
     /**--------------------------------------------------------------------------*/


    /**
     * @param mail 用户邮箱
     * @return 返回json数据
     * status: 200 验证码发送成功| 201 邮箱已经被注册 | 400 验证码发送失败
     * JSESSIONID
     * @description 发送邮箱验证码
     */
    @RequestMapping(path = "/passlove/register/sendCheckCode", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String sendCheckCode(HttpSession session, @RequestParam String mail) throws Exception {
        JSONObject returnData = new JSONObject(true); //返回信息
        String JSESSIONID = null;
        int status = 200;
        try {
            if (userService.isRegistered(mail)) { //如果用户已经注册
                return "{\"status\":201}";
            }
            String checkcode = CodeCheck.getCheckCode(5); //获取验证码
            //发送验证码
            mailService.sendMail(new String[]{mail}, "递爱验证码", "<h2>您好,您的注册验证码是" + checkcode + "</h2>");
            session.setMaxInactiveInterval(120);
            session.setAttribute("checkcode", checkcode);
            session.setAttribute("username", mail);
            //将该session存入
            registerSessionContext.addSession(session);
            JSESSIONID = session.getId();
        } catch (Exception e) {
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("JSESSIONID", session.getId());
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }

    /**
     * @param checkcode  验证码
     * @param JSESSIONID
     * @return 返回json数据
     * status: 200 验证码验证成功 | 400 验证码验证失败
     * @description 验证验证码
     */
    @RequestMapping(path = "/passlove/register/checkCode", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String checkCode(@RequestParam String checkcode, @RequestParam String JSESSIONID) {
        JSONObject returnData = null; //返回信息
        int status = 400;
        try {
            returnData = new JSONObject(true);
            HttpSession session = registerSessionContext.getSession(JSESSIONID);
            String value = ((String) session.getAttribute("checkcode")).toLowerCase();
            if (value.equals(checkcode.toLowerCase())) {
                status = 200;
                session.setAttribute("ischecked", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        return returnData.toJSONString();
    }

    /**
     * @return 返回json数据
     * status: 200 验证码验证成功 | 400 验证码验证失败
     * @description 注册用户
     */
    @RequestMapping(path = "/passlove/register", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String register(@RequestParam String password, @RequestParam String nickname,
                           @RequestParam String phonenumber, @RequestParam String JSESSIONID) throws Exception {
        JSONObject returnData = null; //返回信息
        int status = 400;
        try {
            returnData = new JSONObject(true);
            HttpSession session = registerSessionContext.getSession(JSESSIONID);
            if ((boolean) session.getAttribute("ischecked")) { //验证是否已经验证
                status = 200;
                User user = new User((String) session.getAttribute("username"), password, nickname, "default.jpg", phonenumber);

                userService.register(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        return returnData.toJSONString();
    }

    /**             信息          */
    /*********************************************************************/

    /**
     * @return
     * @description 获取所有的丢失类型信息
     */
    @RequestMapping(path = "/passlove/info/types", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getTypes() {
        int status = 200;
        JSONObject returnData = new JSONObject(true);
        List<Type> types = null;
        try {
            types = infoService.getTypes();
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("types", types);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }

    /**
     * @return
     * @description 获取所有的地点信息
     */
    @RequestMapping(path = "/passlove/info/places", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getPlaces() {
        int status = 200;
        JSONObject returnData = new JSONObject(true);
        List<Place> places = null;
        try {
            places = infoService.getPlaces();
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("types", places);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }


    /**                     动态                */
    /*********************************************************************/

    /**
     * @param requestData 请求数据json
     *                    start
     *                    end
     * @param losttype    发布的类型  0 寻物 | 1 招领
     * @return 返回json数据
     * status: 200 获取动态成功 400 获取动态失败
     * dynamics: 动态的数据
     * username: 发布动态的人的账号
     * nickname：名称
     * photo：头像
     * thelost: 失物信息
     * @description 获取失物的动态
     */
    @RequestMapping(path = "/passlove/dynamics/{losttype}", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getDynamics(@RequestParam String requestData, @PathVariable int losttype) {
        int status = 200;
        JSONObject returnData = new JSONObject(true);
        List<Dynamics> dynamics = null;
        try {
            JSONObject json = JSON.parseObject(requestData);
            dynamics = dynamicsService.getDynamicsByLosttype(json.getInteger("start"), json.getInteger("end"), losttype);
        } catch (Exception e) {
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("dynamics", dynamics);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 根据id获取动态的信息
     * @param
     * */
    @RequestMapping(path = "/passlove/dynamics/get", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getDynamics(@RequestParam Integer lostid) {
        int status = 200;
        JSONObject returnData = new JSONObject(true);
        Dynamics dynamics = null;
        try{
            dynamics = dynamicsService.getDynamicsByLostID(lostid);
        } catch (Exception e) {
            status = 400;
            e.printStackTrace();
        }
        returnData.put("status", status);
        returnData.put("dynamics", dynamics);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 获取我评论过的动态
     * @param JSESSIONID
     * */
    @RequestMapping(path = {"/passlove/dynamics/commented"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getDynamicsCommented(@RequestParam String JSESSIONID) {
        JSONObject returnData = new JSONObject(true);
        List<Dynamics> dynamics = null;
        int status = 200;
        try {
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user");
            dynamics = dynamicsService.getDynamicsUserCommented(user);
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("dynamics", dynamics);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }



    /**                     搜索                      */
    /*********************************************************************/

    /**
     * @param requestData 请求的json数据
     *                    losttype 丢失或者寻找
     *                    typeid 失物类型
     *                    placeid 地点
     *                    start
     *                    end
     * @return 返回json数据
     * status: 200 获取动态成功 400 获取动态失败
     * dynamics: 动态的数据
     * username: 发布动态的人的账号
     * nickname：名称
     * photo：头像
     * thelost: 失物信息
     */
    @RequestMapping(path = {"/passlove/dynamics/search"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String searchByProperties(@RequestParam String requestData) {
        JSONObject returnData = new JSONObject(true);
        List<Dynamics> dynamics = null;
        int status = 200;
        try {
            JSONObject json = JSON.parseObject(requestData);
            dynamics = dynamicsService.searchDynamics(json.getString("keyword"), json.getInteger("losttype"), json.getInteger("typeid"),
                    json.getInteger("placeid"), json.getInteger("start"), json.getInteger("end"));
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("dynamics", dynamics);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }


    /**                     发布失物                      */
    /*********************************************************************/

    /**
     * @param JSESSIONID
     * @param thelost    失物信息
     * @return 返回json数据
     * status: 200 修改成功 |400 修改失败
     * @description 发布招领或者寻物的接口
     */
    @RequestMapping(path = {"/passlove/user/publishlost"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String publishLost(@RequestParam String JSESSIONID, @RequestParam String thelost, @RequestParam(name = "photos", required = false) MultipartFile[] photos, HttpSession session) {
        int status = 200;
        JSONObject returnData = new JSONObject(true);
        try {
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user");
            Lost lost = JSON.toJavaObject(JSON.parseObject(thelost), Lost.class);
            lostService.publishLost(user, lost, photos, session.getServletContext().getRealPath("/WEB-INF/img/thelost"));
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        return returnData.toJSONString();
    }


    /**                     消息                      */
    /*********************************************************************/


    /**
     * 获取评论消息
     * @param lostid 失物的id
     * */
    @RequestMapping(path = {"/passlove/comment/get"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getComments(@RequestParam Integer lostid) {
        JSONObject returnData = new JSONObject(true);
        List<Commentp> comments = null;
        int status = 200;
        try {
            comments = commentService.getCommentsByID(lostid);
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("comments", comments);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 获取我评论过的失物的所有id
     * @param JSESSIONID
     * */
    @RequestMapping(path = {"/passlove/comment/lostids"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String getLostIDs(@RequestParam String JSESSIONID) {
        JSONObject returnData = new JSONObject(true);
        List<Integer> IDs = null;
        int status = 200;
        try {
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user");
            IDs = lostService.getLostIDsUserComented(user);
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("IDs", IDs);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 发布评论
     * */
    @RequestMapping(path = {"/passlove/comment/publish"}, method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String publishComments(@RequestParam String JSESSIONID, @RequestParam String requestData) {
        JSONObject json = JSON.parseObject(requestData);
        JSONObject returnData = new JSONObject(true);
        int status = 200;
        try {
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user");
            Comment comment = JSON.toJavaObject(json.getJSONObject("comment"), Comment.class);
            commentService.publishComment(user.getUsername(), json.getInteger("lostid"), comment);
        } catch (Exception e) {
            e.printStackTrace();;
            status = 400;
        }
        returnData.put("status", status);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }


    /**                     ‘我的’                        */
    /*********************************************************************/


    /**
     * @param requestData 请求的json数据
     *                    JSESSIONID
     *                    nickname
     * @return 返回json数据
     * status: 200 修改成功 |400 修改失败
     * @description 修改用户的名称
     */
    @RequestMapping(path = "/passlove/user/update/nickname", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updateNickname(@RequestParam String JSESSIONID, @RequestParam String requestData) {
        int status = 200;
        JSONObject returnData = new JSONObject(true);
        try {
            JSONObject json = JSON.parseObject(requestData);
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user");
            userService.updateUserNickname(user, json.getString("nickname"));
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        return returnData.toJSONString();

    }

    /**
     * @param photo      修改的头像图片
     * @param JSESSIONID
     * @description 修改用户头像
     */
    @RequestMapping(path = "/passlove/user/update/photo", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updateUserPhoto(@RequestParam(name = "photo") MultipartFile photo, @RequestParam String JSESSIONID, HttpSession session) {
        JSONObject returnData = new JSONObject(true);
        int status = 200;
        User user = null;
        try {
            user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user"); //获取用户
            userService.updateUserPhoto(user, photo, session.getServletContext().getRealPath("/WEB-INF/img/user"));
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("photo", user.getPhoto());
        return returnData.toJSONString();
    }

    /**
     * @param requestData 请求的json数据
     *                    JSESSIONID
     *                    phonenumber 需要修改的电话号码
     * @description 修改用户电话号码
     */
    @RequestMapping(path = "/passlove/user/update/phonenumber", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String updatePhonenumber(@RequestParam String JSESSIONID, @RequestParam String requestData) {
        JSONObject returnData = new JSONObject(true);
        int status = 200;
        try {
            JSONObject json = JSON.parseObject(requestData);
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user"); //获取用户
            userService.updateUserPhonenumber(user, json.getString("phonenumber"));
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        return returnData.toJSONString();
    }

    /**
     * @param requestData 请求的json数据
     *                    JSESSIONID
     *                    start
     *                    end
     * @return 返回json数据
     * status: 200 获取成功 | 400 获取失败
     * data：数据信息
     * @description 我的发布
     */
    @RequestMapping(path = "/passlove/user/mypublish", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String myPublish(@RequestParam String JSESSIONID, @RequestParam String requestData) {
        JSONObject returnData = new JSONObject(true);
        int status = 200;
        List<Lost> data = null;
        try {
            JSONObject json = JSON.parseObject(requestData);
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user");
            data = lostService.getLostsUserPublished(user, json.getInteger("start"), json.getInteger("end"));
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("data", data);
        return JSON.toJSONString(returnData, SerializerFeature.WriteNullBooleanAsFalse);
    }

    /**
     * @param requestData 请求的json数据
     *                    JSESSIONID
     *                    start
     *                    end
     * @return 返回json数据
     * status: 200 获取成功 | 400 获取失败
     * data：数据信息
     * @description 我的历史
     */
    @RequestMapping(path = "/passlove/user/myhistory", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String myHistory(@RequestParam String JSESSIONID, @RequestParam String requestData) {
        JSONObject returnData = new JSONObject(true);
        int status = 200;
        List<Lost> data = null;
        try {
            JSONObject json = JSON.parseObject(requestData);
            User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user");
            data = lostService.getLostsUserHistory(user, json.getInteger("start"), json.getInteger("end"));
        } catch (Exception e) {
            e.printStackTrace();
            status = 400;
        }
        returnData.put("status", status);
        returnData.put("data", data);
        return JSON.toJSONString(returnData, SerializerFeature.WriteNullBooleanAsFalse);
    }

}
