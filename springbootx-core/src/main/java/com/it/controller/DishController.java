package com.it.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.common.PageResult;
import com.it.common.Result;
import com.it.entity.Dish;
import com.it.service.IDishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 菜品 前端控制器
 * </p>
 *
 * @author zhangzhicai
 * @since 2025-04-17
 */
@RestController
@RequestMapping("/springbootx/dish")
@Slf4j
@Api(tags = "菜品管理接口")
public class DishController {

    @Autowired
    private IDishService dishService;

    /**
     * 查询用户列表
     *
     * @return
     */
    @GetMapping
    @ApiOperation("查询菜品列表")
    public Result<List<Dish>> selectAll() {
        List<Dish> userList = dishService.list();
        log.info("查询菜品列表...");
        return Result.success(userList);
    }

    /**
     * 分页查询
     *
     * @return
     */
    @GetMapping("page")
    @ApiOperation("分页查询")
    public Result<PageResult<Dish>> page(Long currentPage, Long pageSize) {
        log.info("菜品分页查询");
        //LambdaQueryWrapper<Object> wrapper = new LambdaQueryWrapper<>();
        Page<Dish> page = dishService.page(new Page<>(currentPage, pageSize));
        PageResult<Dish> pageResult = new PageResult<>(page.getTotal(), page.getRecords());
        return Result.success(pageResult);
    }
}
