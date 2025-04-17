package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.Dish;
import com.it.mapper.DishMapper;
import com.it.service.IDishService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品 服务实现类
 * </p>
 *
 * @author zhangzhicai
 * @since 2025-04-17
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements IDishService {

}
