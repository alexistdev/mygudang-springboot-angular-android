package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.User;

public interface UserService {
    User save(User user) throws Exception;

    User findByEmail(String email) throws Exception;
}
