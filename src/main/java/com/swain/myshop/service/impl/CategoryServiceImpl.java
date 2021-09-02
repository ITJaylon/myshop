package com.swain.myshop.service.impl;

import com.swain.myshop.entity.Category;
import com.swain.myshop.mapper.CategoryMapper;
import com.swain.myshop.service.CategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
