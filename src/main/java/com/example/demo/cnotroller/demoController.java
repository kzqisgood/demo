package com.example.demo.cnotroller;

import com.example.demo.Usernoo.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class demoController {
    @ResponseBody
    @GetMapping("/geturl")
    public String geturl(User user){
        System.out.println(user.getName()+user.getId()+user.getClassNo());
        return "姓名："+user.getName()+"学号"+user.getId()+"班级"+ user.getClassNo();
    }

    @ResponseBody
    @GetMapping("/geturl1/{name}/{id}/{ClassNo}")
    public String geturl1(@PathVariable("name") String name,@PathVariable("id") Integer id,@PathVariable("ClassNo") String ClassNo){
        return "姓名："+name+"学号:"+id+"班级:"+ClassNo;
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

    @ResponseBody
    @RequestMapping(value = "/setCookies",method = RequestMethod.GET)
    public  String setCookies(HttpServletResponse response){
        Cookie cookie=new Cookie("cookie","微信公众号：骄傲的程序员");
        cookie.setMaxAge(60);             //存活一分钟
//        cookie.setMaxAge(60*60);          //存活一小时
//        cookie.setMaxAge(24*60*60);       //存活一天
        cookie.setMaxAge(365*24*60*60);     //存活一年
        response.addCookie(cookie);
        return "添加成功";
    }

    @ResponseBody
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletRequest request){
        Cookie[] cookies =  request.getCookies();//获取保存在request的所有cookie
        if(cookies != null){//判断cookies数组是否为空
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("cookie")){//通过for循环找到想要获取的值
                    System.out.println(cookie.getValue());//控制台输出
                    return cookie.getValue();//返回cookie
                }
            }
        }
        return  null;
    }

    @ResponseBody
    @RequestMapping(value = "/setSession",method = { RequestMethod.POST, RequestMethod.GET })
    public  String setCookies(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("data", "微信公众号：骄傲的程序员");
        return "添加成功";
    }

    @ResponseBody
    @RequestMapping(value = "/getSession",method = { RequestMethod.POST, RequestMethod.GET })
    public String getCookiess(HttpServletRequest request){
        HttpSession session = request.getSession();
        String data = (String) session.getAttribute("data");
        return data;
    }

}
