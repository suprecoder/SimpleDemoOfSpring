package com.liaocc.demo.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Map;

public interface VideoService {
    boolean saveVideo(MultipartFile file);
    Map<String,Object> getVideobyId(int id);
}
