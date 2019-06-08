package com.springboot.bikini;

import com.springboot.bikini.dao.EmployerDao;
import com.springboot.bikini.model.EmployerDomain;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@MapperScan("com.springboot.bikini.dao") //dao包扫描
public class BikiniApplication {
    public static void main(String[] args) {
        SpringApplication.run(BikiniApplication.class, args);
    }

    @RequestMapping
    public String hello(){
        return "hello springboot";
    }
}
