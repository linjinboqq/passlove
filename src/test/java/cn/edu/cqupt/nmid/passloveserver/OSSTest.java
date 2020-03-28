package cn.edu.cqupt.nmid.passloveserver;


import com.aliyun.oss.OSSClient;
import org.junit.Test;

public class OSSTest {

    @Test
    public void oss(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-chengdu.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI4Fo345dmoPsjQYjNkqaj";
        String accessKeySecret = "dXwwcOWo4aSyYMavJ0dM8RGnmCPsws";

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 创建存储空间。
        String bucketName = "passlovetest";
        // 新建存储空间默认为标准存储类型，私有权限。
        ossClient.createBucket(bucketName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
