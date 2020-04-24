package com.example.message.dao;

import com.example.message.entity.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDaoImplement implements UserDao{
    private JdbcTemplate jdbcTemplate;

    //为什么要写这个构造函数呢？是为了Bean的注入吗？
    public UserDaoImplement(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String uid, String username, String password, String phoneNum) {
        return jdbcTemplate.update("INSERT INTO user(uid, username, password, phone_num) values (?,?,?,?)",
                                                                            uid, username, password, phoneNum);
    }

    @Override
    public String logInByUid(String uid, String givenPWD){
        List<UserEntity> userInfo = jdbcTemplate.query("SELECT password FROM user WHERE uid = ?",
                (resultSet, i) -> {
            UserEntity user = new UserEntity();
            user.setPassword(resultSet.getString("password"));
            return user;
        }, uid);//query方法的参数为sql语句，接收返回值的对象，查询用的变量，此处的lambda函数和uid对应后两个

        //以下代码可能有BUG！！未排查！！！具体就是如果userInfo是否不会为空，query会返回一个NULL之类的？
        if(userInfo.isEmpty()){
            return "null";//查无此人 query无返回，userInfo为空
        }
        UserEntity user = userInfo.get(0);//这里不check非空的话会报错，需要先check是否为空！！！
        String password = user.getPassword();
        if(givenPWD.equals(password)){
            return "success";//密码正确
        }
        else{
            return "wrong";//密码错误
        }
    }

    @Override
    public String logInByUsername(String Uuername, String givenPWD) {
        return null;
    }

    @Override
    public String logInByPhoneNum(String phoneNum, String givenPWD) {
        return null;
    }
}
