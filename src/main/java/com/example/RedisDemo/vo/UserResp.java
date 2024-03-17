package com.example.RedisDemo.vo;

import com.example.RedisDemo.model.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResp extends UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;
}
