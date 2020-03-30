package com.liaocc.demo.po;

import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class Blog {
    private Long id;
    private String title;
    private String summary;
    private String content_md;
    private String content_html;
    private Long readnum;
    private Long prefer;
    private Boolean isdraft;
    private Integer publictype;
    private Boolean islike;
    private List<String> tags;
    private String username;
    @Override
    public boolean equals(Object obj) {
        return ((Blog)obj).getId().equals(this.id);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent_md() {
        return content_md;
    }

    public void setContent_md(String content_md) {
        this.content_md = content_md;
    }

    public String getContent_html() {
        return content_html;
    }

    public void setContent_html(String content_html) {
        this.content_html = content_html;
    }

    public Long getReadnum() {
        return readnum;
    }

    public void setReadnum(Long readnum) {
        this.readnum = readnum;
    }

    public Long getPrefer() {
        return prefer;
    }

    public void setPrefer(Long prefer) {
        this.prefer = prefer;
    }

    public Boolean getIsdraft() {
        return isdraft;
    }

    public void setIsdraft(Boolean isdraft) {
        this.isdraft = isdraft;
    }

    public Integer getPublictype() {
        return publictype;
    }

    public void setPublictype(Integer publictype) {
        this.publictype = publictype;
    }

    public Boolean getIslike() {
        return islike;
    }

    public void setIslike(Boolean islike) {
        this.islike = islike;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
