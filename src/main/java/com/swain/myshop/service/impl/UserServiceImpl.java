package com.swain.myshop.service.impl;

import com.swain.myshop.entity.User;
import com.swain.myshop.mapper.UserMapper;
import com.swain.myshop.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swain
 * @since 2021-09-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
