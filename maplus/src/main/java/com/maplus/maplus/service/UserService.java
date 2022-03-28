package com.maplus.maplus.service;

import com.maplus.maplus.model.User;

public interface UserService {
    public Integer checkUser(String user);
    public Integer saveUser(User user);
    public boolean login(User user);
    public boolean changePsw(String userName, String userPassword,String newPassword);


    public boolean userChangeNickname(String username, String usernickname);

}
