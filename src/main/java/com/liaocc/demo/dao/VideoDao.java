package com.liaocc.demo.dao;

import org.apache.ibatis.annotations.*;

import java.io.InputStream;
import java.sql.Blob;

@Mapper
public interface VideoDao {
    @Insert("insert into t_video(video) values (#{bytes})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    void insert(@Param("bytes") byte[] bytes);

    @Select("select video from t_video where id=#{id}")
    InputStream getvideobyid(@Param("id") int id);
}
