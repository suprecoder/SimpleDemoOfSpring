package com.liaocc.demo.Service;

import com.liaocc.demo.dao.VideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoDao;
    @Override
    public boolean saveVideo(MultipartFile file) {
        try{
            byte[] bytes=file.getBytes();
            videoDao.insert(bytes);
        }catch (Exception e){e.printStackTrace();}
        return true;
    }

    @Override
    public Map<String,Object> getVideobyId(int id) {
        try{
            InputStream is=videoDao.getvideobyid(id);
            MultipartFile file = new MockMultipartFile("avatar","avatar","video/mp4",is);
            System.out.println(file.getSize());
            Map<String,Object> ans=new HashMap<>();
            ans.put("VideoStream",file.getInputStream());
            ans.put("size",file.getSize());
            return ans;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
