package com.example.RedisDemo.service;

import com.example.RedisDemo.model.UserEntity;
import com.example.RedisDemo.repository.UserRepo;
import com.example.RedisDemo.vo.UserResp;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
@EnableCaching
public class UserServiceImpl implements UserService {
  private final UserRepo userRepo;
  private final StringRedisTemplate stringRedisTemplate;

  @Override
  @Cacheable(value = "userInfo", key = "'user'")
  public UserResp getUser() {

    List<UserEntity> userEntity = userRepo.findAll();
    UserResp resp = new UserResp();
    resp.setId(userEntity.get(0).getId());
    resp.setName(userEntity.get(0).getName());
    resp.setAge(userEntity.get(0).getAge());

    return resp;
  }

  @Override
  @CachePut(value = "userInfo", key = "'user'")
  public UserResp editUser() {
    List<UserEntity> userEntity = userRepo.findAll();
    userEntity.get(0).setAge(userEntity.get(0).getAge() + 1);
    userRepo.save(userEntity.get(0));

    UserResp resp = new UserResp();
    resp.setId(userEntity.get(0).getId());
    resp.setName(userEntity.get(0).getName());
    resp.setAge(userEntity.get(0).getAge());

    return resp;
  }
}
