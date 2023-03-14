package com.balala.Order.service.impl;

import com.balala.Order.common.CustomException;
import com.balala.Order.entity.Category;
import com.balala.Order.entity.Dish;
import com.balala.Order.entity.Setmeal;
import com.balala.Order.mapper.CategoryMapper;
import com.balala.Order.service.CategoryService;
import com.balala.Order.service.DishService;
import com.balala.Order.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;



    @Override
    public void remove(Long id) {
        //查询当前分类是否关联菜品，关联抛出异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<Dish>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count = dishService.count(dishLambdaQueryWrapper);

        if(count > 0){
            throw new CustomException("当前分类项关联了菜品，不能删除");
        }
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count1 = setmealService.count(setmealLambdaQueryWrapper);

        if(count1 > 0){
            throw new CustomException("当前分类项关联了套餐，不能删除");
        }


        super.removeById(id);
    }
}
