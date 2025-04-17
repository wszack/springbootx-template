package com.it.springbootx.service.impl;

import com.it.springbootx.entity.Dish;
import com.it.springbootx.mapper.DishMapper;
import com.it.springbootx.service.IDishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
