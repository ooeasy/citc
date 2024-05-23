package com.citc.config;

import com.citc.Entity.Student;
import com.citc.mapper.SyncDatabase;
import com.citc.mapper.SyncFile;
import com.citc.service.MybatisService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({Student.class})
@Configuration
public class AppConfig {

    @Bean
    public MybatisService my1(){
        return new MybatisService();
    }
    @Bean
    public MybatisService my2(){
        return new MybatisService();
    }

//    @Bean
//    public SyncFile syncFile(){
//        return new SyncFile();
//    }
//    @Bean
//    SyncDatabase syncDatabase(){
//        return  new SyncDatabase();
//    }
}