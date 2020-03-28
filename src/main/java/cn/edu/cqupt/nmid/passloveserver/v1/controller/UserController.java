package cn.edu.cqupt.nmid.passloveserver.v1.controller;

import cn.edu.cqupt.nmid.passloveserver.v1.pojo.User;
import cn.edu.cqupt.nmid.passloveserver.v1.service.FileService;
import cn.edu.cqupt.nmid.passloveserver.v1.web.listener.LoginSessionContext;
import cn.edu.cqupt.nmid.passloveserver.v2.service.impl.UserServiceImplV2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    @Autowired
    FileService fileService;
    @Autowired
    UserServiceImplV2 userService;
    @Resource
    private LoginSessionContext loginSessionContext;

    //修改用户头像
    @ApiOperation(value = "修改用户头像")
    @PostMapping("passlove/user/updateavatar")
    public String updateavatar(
            @ApiParam(name = "file", value = "用户头像", required = true)
            @RequestParam("file") MultipartFile file, HttpSession session,
            @RequestParam String JSESSIONID) throws Exception {
        JSONObject returnData = new JSONObject(true); //返回信息
        int status = 200;
        String url = fileService.upload(file);
        //返回r对象
        User user = (User) loginSessionContext.getSession(JSESSIONID).getAttribute("user"); //获取用户

        userService.updateUserPhoto(user, url);

        returnData.put("status", status);
        returnData.put("user", user);
        return JSON.toJSONString(returnData, SerializerFeature.WriteMapNullValue);
    }
}
