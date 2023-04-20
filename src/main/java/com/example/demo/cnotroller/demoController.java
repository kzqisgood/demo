package com.example.demo.cnotroller;

import com.example.demo.Usernoo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class demoController {
    @ResponseBody
    @GetMapping("/geturl")
    public String geturl(User user){
        System.out.println(user.getName()+user.getId()+user.getClassno());
        return "姓名："+user.getName()+"学号"+user.getId()+"班级"+ user.getClassno();
    }

    @ResponseBody
    @GetMapping("/geturl1/{name}/{id}/{classno}")
    public String geturl1(@PathVariable("name") String name,@PathVariable("id") Integer id,@PathVariable("classno") String classno){
        return "姓名："+name+"学号:"+id+"班级:"+classno;
    }

    @GetMapping("/addview")
    public String addView(){
        return "demo/add";
    }
    @ResponseBody
    @PostMapping("/add")
    public User add(User user){
        user.setId(user.getId()+1);
        return user;
    }
}
