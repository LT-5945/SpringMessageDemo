package com.example.message.dao;


public interface UserDao {
    /**
     *
     * @param uid
     * @param username
     * @param password
     * @param phoneNum
     * @return
     */
    int create(String uid, String username, String password, String phoneNum);

    /**
     *
     * @param uid
     * @param givenPWD
     * @return
     */
    String logInByUid(String uid, String givenPWD);

    /**
     *
     * @param username
     * @param givenPWD
     * @return
     */
    String logInByUsername(String username, String givenPWD);

    /**
     *
     * @param phoneNum
     * @param givenPWD
     * @return
     */
    String logInByPhoneNum(String phoneNum, String givenPWD);
}
