package com.liaocc.demo.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface VideoService {
    boolean saveVideo(MultipartFile file);
    InputStream getVideobyId(int id);
}
