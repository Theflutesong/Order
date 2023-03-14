package com.balala.Order.dto;


import com.balala.Order.entity.Setmeal;
import com.balala.Order.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
