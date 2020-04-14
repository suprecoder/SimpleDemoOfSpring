package com.liaocc.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.InputStream;

public interface ImgDao {
    @Insert("insert into img(img) values(#{img})")
    void upload(@Param("img")byte[] is);
    @Select("select *from img")
    InputStream getimg();
}
