package com.example.RedisDemo.controller;

import com.example.RedisDemo.service.UserServiceImpl;
import com.example.RedisDemo.vo.UserResp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserCtrl {

  private final UserServiceImpl userService;

  @GetMapping("getUser")
  public UserResp getUser() {
    return userService.getUser();
  }

  @GetMapping("editUser")
  public String editUser() {
    userService.editUser();
    return "success";
  }
}
