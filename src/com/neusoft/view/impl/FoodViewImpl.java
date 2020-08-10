package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.dao.Impl.FoodDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

/**
 * @author Eric Lee
 * @date 2020/8/10 14:30
 */
public class FoodViewImpl implements FoodView {
    Scanner input=new Scanner(System.in);


    @Override
    public void showFoodList(Integer businessId) {

        FoodDaoImpl dao = new FoodDaoImpl();
        List<Food> foodList = dao.findAll(businessId);
        System.out.println("食品编号" + "\t" +"食品名称");
        for (Food food :foodList){
            System.out.println(food.getFoodId() + "\t" + food.getFoodName());
        }
    }

    @Override
    public void saveFood(Integer businessId) {
        Food food = new Food();
        System.out.println("请输入商品名称");
        String foodName=input.next();
        System.out.println("请输入商品介绍");
        String foodExplain=input.next();
        System.out.println("请输入商品价格");
        double foodPrice=input.nextDouble();
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(foodPrice);
        food.setBusinessId(businessId);
        FoodDaoImpl dao = new FoodDaoImpl();
        int res=dao.saveFood(food);

        if (res > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDaoImpl dao = new FoodDaoImpl();
        showFoodList(businessId);
        System.out.println("请输入商品编号");
        Integer a=input.nextInt();
        Food food= dao.getFoodById(a);
        String str = null;
        System.out.println("是否修改商品名称y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新名字");
            food.setFoodName(input.next());
            str = null;
        }
        System.out.println("是否修改商品介绍y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新介绍");
            food.setFoodExplain(input.next());
            str = null;
        }
        System.out.println("是否修改商品价格y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新价格");
            food.setFoodPrice(input.nextInt());
            str = null;
        }
        int res = dao.updateFood(food);
        if (res > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        FoodDaoImpl dao = new FoodDaoImpl();
        showFoodList(businessId);
        System.out.println("请输入要删除商品编号");
        Integer a=input.nextInt();
        int res = dao.removeFood(a);
        if (res > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
}