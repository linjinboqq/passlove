package cn.edu.cqupt.nmid.passloveserver.util;

import cn.edu.cqupt.nmid.passloveserver.v1.web.info.Return;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SendSmsUtil {
    @Value("${sms.accessKeyId}")
    private String accessKeyId;
    @Value("${sms.secret}")
    private String secret;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 发送验证码
     *
     * @return
     */
    public boolean sendSms(String verificationCode, String phoneNumber) throws ServerException, ClientException {
//        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, secret);
//        IAcsClient client = new DefaultAcsClient(profile);
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("RegionId", "cn-hangzhou");
//        request.putQueryParameter("PhoneNumbers", phoneNumber);
//        request.putQueryParameter("TemplateCode", "SMS_177549030");
//        request.putQueryParameter("SignName", "递爱失物系统");
//        request.putQueryParameter("TemplateParam", "{\"code\":\""+verificationCode+"\"}");
//        log.info("向 " + phoneNumber + " 发送验证码短信：" + verificationCode);
//        CommonResponse response = client.getCommonResponse(request);
//        log.info("短信返回值：\n\r"+response.getData());
//        return true;

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4FeKTXuVcsmA77uScp95", "xvVZUn3UPYwuoomoKH4fJVz9vNLdQx");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
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
        return true;
    }


    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
