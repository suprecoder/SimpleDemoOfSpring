package com.liaocc.demo.Controller;

import com.liaocc.demo.Service.UserService;
import com.liaocc.demo.Service.VideoService;
import com.liaocc.demo.dao.UserDao;
import com.liaocc.demo.dao.VideoDao;
import com.liaocc.demo.po.User;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("/api")
public class IndexController {
    @Autowired
    UserService userService;
    @Autowired
    VideoService videoService;
    @GetMapping("getusers")
    List<User> login(){
        List<User> users=userService.getAllUser();
        return users;
    }

    @PostMapping("testpost")
    void testpost(@RequestBody String username, HttpServletRequest request){
        //request.getParameter("username");
        System.out.println(username);
    }

    //上传视频
    @RequestMapping("upload")
    void uploadvideo(@RequestParam(value = "file") MultipartFile file){
        videoService.saveVideo(file);
    }

    //根据视频id获取视频
    @RequestMapping("getvideo/{id}")
    void getvideobyid(@PathVariable(value = "id") int id, HttpServletResponse response){
        try {
            Map<String,Object> mp=videoService.getVideobyId(id);
            response.setHeader("Content-Type","video/mp4");
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Connection","keep-alive");
            FileCopyUtils.copy((InputStream) mp.get("VideoStream"), response.getOutputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
