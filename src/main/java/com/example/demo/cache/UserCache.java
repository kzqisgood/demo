package com.example.demo.cache;

import com.example.demo.Usernoo.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserCache {
    public static List<User> users=new ArrayList<>();

    @PostConstruct
    public void init(){
        //从数据库中加载数据
        System.out.println("缓存初始化");
    }
    @PreDestroy
    public void destory(){
        // 销毁释放资源
    }
}
