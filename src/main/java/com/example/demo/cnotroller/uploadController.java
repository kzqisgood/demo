package com.example.demo.cnotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/file")
public class uploadController {

    @GetMapping("/index")
    public  String index(){
        return "file/index";
    }
    @ResponseBody
    @PostMapping("/UpLoading")
    public String UpLoading(MultipartFile file){
        System.out.println("上传");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmmss");
        String dataStr = sdf.format(new Date());
        String filePath = "";
        String oldName = file.getOriginalFilename();
        String newName = dataStr + oldName;
        System.out.println(oldName);
        try{
            file.transferTo(new File("C:/Users/18454/Desktop/UpLoading",newName));
        }catch (IOException e) {
            e.printStackTrace();
            return "上传失败";
        }
        return newName;
    }
    @GetMapping("/layuiupload")
    public  String layuiupload(){
        return "file/layuiupload";
    }
}

