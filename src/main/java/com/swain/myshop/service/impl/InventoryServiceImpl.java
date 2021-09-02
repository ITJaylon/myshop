package com.swain.myshop.service.impl;

import com.swain.myshop.entity.Inventory;
import com.swain.myshop.mapper.InventoryMapper;
import com.swain.myshop.service.InventoryService;
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
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements InventoryService {

}
