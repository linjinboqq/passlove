package cn.edu.cqupt.nmid.passloveserver;

import cn.edu.cqupt.nmid.passloveserver.util.JSONUtil;
import cn.edu.cqupt.nmid.passloveserver.util.PojoUtil;
import cn.edu.cqupt.nmid.passloveserver.v1.dao.DynamicsDao;
import cn.edu.cqupt.nmid.passloveserver.v1.dao.ReplypDao;
import cn.edu.cqupt.nmid.passloveserver.v1.dao.UserDao;
import cn.edu.cqupt.nmid.passloveserver.v1.pojo.Comment;
import cn.edu.cqupt.nmid.passloveserver.v1.service.CommentService;
import cn.edu.cqupt.nmid.passloveserver.v1.service.UserService;
import cn.edu.cqupt.nmid.passloveserver.v1.service.impl.UserServiceImpl;
import cn.edu.cqupt.nmid.passloveserver.v1.service.mail.MailService;
import cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper.DynamicsMapper;
import cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper.UserMapper;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.Dynamics;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.DynamicsExample;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.User;
import cn.edu.cqupt.nmid.passloveserver.v2.pojo.UserExample;
import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = PassloveServerApplication.class)
public class PassloveServerApplicationTests {

    @Resource
    DynamicsDao dynamicsDao;
    @Resource
    UserServiceImpl UserServiceImpl;
    @Resource
    UserDao userDao;
    @Resource
    MailService qqMail;

    @Resource
    UserMapper userMapper;

    @Resource
    DynamicsMapper dynamicsMapper;

    @Resource(name = "userServiceImplV2")
    UserService userService;

    @Resource
    CommentService commentService;

    @Resource
    ReplypDao replypDao;

    @Test
    @Ignore
    public void daoTest() throws Exception {
        System.out.println(JSON.toJSONString(userDao.getUserByUP("706519033@qq.com", "123456")));
    }

    @Test
    @Ignore
    public void qqmailTest() throws MessagingException {
        qqMail.sendMail(new String[]{"wang.haoxin@nexuslink.cn"}, "邮件测试", "hello this is a test");
    }

    @Test
    @Ignore
    public void mapperTest() throws Exception {
        User user = userMapper.selectByPrimaryKey("706519033@qq.com");
        System.out.println(JSONUtil.toJSONString(user));
    }

    @Test
    @Ignore
    public void classTest() throws Exception {
        User userV2 = userMapper.selectByPrimaryKey("706519033@qq.com");
        System.out.println(JSONUtil.toJSONString(userV2));
        cn.edu.cqupt.nmid.passloveserver.v1.pojo.User user = (cn.edu.cqupt.nmid.passloveserver.v1.pojo.User) PojoUtil.convert(userV2, userV2.getClass(), cn.edu.cqupt.nmid.passloveserver.v1.pojo.User.class);
        System.out.println(user);
    }

    @Test
    @Ignore
    public void userServiceImplV2Test() throws Exception {
        cn.edu.cqupt.nmid.passloveserver.v1.pojo.User user = new cn.edu.cqupt.nmid.passloveserver.v1.pojo.User();
        user.setUsername("706519033@qq.com");
        userService.updateUserNickname(user, "王昊鑫");
        userService.updateUserPhonenumber(user, "18996956211");

    }

    @Test
    @Ignore
    public void insertReplyTest() throws Exception {
        for (int i = 1; i < 20; i++) {
            Comment comment = new Comment("评论ucid[" + i + "]");
            commentService.replyComment("706519033@qq.com", 12, null, comment);
        }
    }

    @Test
    @Ignore
    public void getReplyTest() throws Exception {
        replypDao.getReplypsByUCID(12).forEach(e -> System.out.println(JSONUtil.toJSONString(e)));
    }

    @Test
    @Ignore
    public void getpublishtimedy() throws Exception {
        replypDao.getReplypsByUCID(12).forEach(e -> System.out.println(JSONUtil.toJSONString(e)));

    }

    @Test
    public void testexample() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo("243536237@qq.com").andPasswordEqualTo("Aa123123");
        List<User> users = userMapper.selectByExample(userExample);
//        users.isEmpty() ? null : new cn.edu.cqupt.nmid.passloveserver.v1.pojo.User(users.get(0));

        System.out.println(users.get(0));


        DynamicsExample dynamicsExample = new DynamicsExample();
        dynamicsExample.createCriteria().andPublishtimeEqualTo("20190516162547");
        List<Dynamics> dynamics = dynamicsMapper.selectByExample(dynamicsExample);
        System.out.println(dynamics.get(0).getPublishtime() + " " + dynamics.get(0).getDescription() + dynamics.get(0));

    }

    @Test
    public void testdate() {
//        DateFormat dateFormat = new DateFormat();
        long l = System.currentTimeMillis();
        Date date = new Date(); //取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1); //把日期往后增加一天,整数  往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        System.out.println(l);

    }

    @Test
    public void tedata() throws Exception {

        List<cn.edu.cqupt.nmid.passloveserver.v1.pojo.Dynamics> dynamicsByYesterday = dynamicsDao.getDynamicsByYesterday(0, 0, 10, "20181124%");
        System.out.println(dynamicsByYesterday.get(0) + " " + dynamicsByYesterday.get(1) + dynamicsByYesterday.get(2));

    }

    @Test
    public void uuid() {
        UUID uuid = new UUID(3, 5);
        System.out.println(uuid);


    }

    @Test
    public void uppassword() throws Exception {
        cn.edu.cqupt.nmid.passloveserver.v1.pojo.User user = new cn.edu.cqupt.nmid.passloveserver.v1.pojo.User();
        user.setUsername("243536237@qq.com");
        userService.updateUserNickname(user, "林进波");
        userService.updateUserPhonenumber(user, "18996956211");
        UserServiceImpl.updateUserPassword(user, "123123");

    }

    @Test
   public void sendSms() {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FeKTXuVcsmA77uScp95", "xvVZUn3UPYwuoomoKH4fJVz9vNLdQx");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", "17347898193");
        request.putQueryParameter("TemplateCode", "SMS_177549030");
        request.putQueryParameter("SignName", "会务管理系统");
        request.putQueryParameter("TemplateParam", "{\"code\":\"23212\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    @Test
    public  void  date(){

        Date date =new Date(); //取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,-1); //把日期往后增加一天,整数  往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        System.out.println(format);



    }

    @Test
    public  void  userphoto(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo("243536237@qq.com");
        List<cn.edu.cqupt.nmid.passloveserver.v2.pojo.User> users = userMapper.selectByExample(userExample);
        System.out.println( users.get(0).getPhoto()+"------");
    }
}
