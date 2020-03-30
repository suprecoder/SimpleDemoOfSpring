package com.liaocc.demo.dao;

import com.liaocc.demo.po.Blog;
import com.liaocc.demo.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserDao{
    @Select(value = "select * from user")
    @Results(
            id = "user",
            value = {@Result(column = "username",property = "username"),
                    @Result(column = "id",property = "id")
            }
    )
    List<User> getAllUser();
    @Select(value = "select * from user")
    @ResultMap("user")  //对应上面的results---id='user'
    List<User> getAllUser2();

    @Select("select * from user") //数据库字段名和user的属性名称一致，可以省略映射方式
    List<User> getAllUser3();

    @Select("select * from user where id=#{userid}")
    User getAllUserbyId(@Param("userid") int id);  //@Param("userid")对应上一行的#{userid}

    @Insert("insert into user(psw,username) values(#{psw},#{name})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id") //告诉mybatis哪个是自增长的主键
    void insert(@Param("name") String username,@Param("psw") String psw);

    @Select("select * from user,blog where blog.user_id=user.id and user.id=#{userid}")
    List<Blog> getblogs(@Param("userid") Long userid);
}
