package com.maplus.maplus.service;

import com.maplus.maplus.model.User;

public interface UserService {
    public Integer checkUser(String user);
    public Integer saveUser(User user);
}
