package com.example.RedisDemo.service;

import com.example.RedisDemo.vo.UserResp;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

  UserResp getUser();

  UserResp editUser();
}
