package com.liaocc.demo.Controller;

import com.liaocc.demo.dao.ImgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class ImageController {
    @Autowired
    ImgDao imgDao;
    @RequestMapping("uploadimg")
    void getimg(MultipartFile file) throws IOException {
        byte[] bytes=file.getBytes();
        imgDao.upload(bytes);
    }
    @RequestMapping("getimg")
    void getimg(HttpServletResponse response) throws IOException {
        FileCopyUtils.copy(imgDao.getimg(),response.getOutputStream());
    }
}
