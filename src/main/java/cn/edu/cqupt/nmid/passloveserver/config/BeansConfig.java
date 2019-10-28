package cn.edu.cqupt.nmid.passloveserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/****
 * @author:MrWangx
 * @description
 * @Date 2019/3/12 13:40
 *****/
@Configuration
public class BeansConfig {

    @Value("${sdf.format}")
    String sdfFormat;

    @Bean("sdf")
    public SimpleDateFormat format() {
        return new SimpleDateFormat(sdfFormat);
    }

    @Bean
    public SimpleDateFormat simpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

}
