package com.example.demo.cnotroller;

import com.example.demo.Usernoo.User;
import com.example.demo.cache.UserCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@Controller
public class usercontroller {
    @GetMapping("/index")
    public  String index(Model model){

        User user = new User();
        user.setId(1);
        user.setName("李四");
        user.setClassno("B2001");
        model.addAttribute("user",user);
        List<User> list=new ArrayList<>();
        list.add(user);
        User user1 =new User();
        user1.setId(100);
        user1.setName("王五");
        user1.setClassno("B1000");
        list.add(user1);
        model.addAttribute("users",list);
        model.addAttribute("users", UserCache.users);
        return "user/index";
    }

    @GetMapping("/add")
    public String add(){
        return "user/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public String add(User user){
        UserCache.users.add(user);
        return "ok";
    }

    @GetMapping("/edit")
    public String edit(Integer id,Model model){
        for(User user:UserCache.users){
            if(user.getId()==id){
                model.addAttribute("user",user);
            }
        }
        return "user/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public String edit(User us){
        for(User user:UserCache.users){
            if(user.getId()==us.getId()){
                UserCache.users.remove(user);
                UserCache.users.add(us);
            }
        }
        return "ok";
    }
}
