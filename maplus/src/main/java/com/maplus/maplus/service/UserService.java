package com.maplus.maplus.service;

import com.maplus.maplus.model.User;

public interface UserService {
    public boolean userRegister(User user);
    public boolean userChangeNickname(String username, String usernickname);
}
