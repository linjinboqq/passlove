package cn.edu.cqupt.nmid.passloveserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"cn.edu.cqupt.nmid.passloveserver.v2.dao.mapper", "cn.edu.cqupt.nmid.passloveserver.v1.dao"})
public class PassloveServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassloveServerApplication.class, args);
    }
}
