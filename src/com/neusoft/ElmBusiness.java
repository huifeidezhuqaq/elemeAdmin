package com.neusoft;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.FoodView;
import com.neusoft.view.impl.AdminViewImpl;
import com.neusoft.view.impl.BusinessViewImpl;
import com.neusoft.view.impl.FoodViewImpl;

import java.util.Scanner;

public class ElmBusiness {
    public static void main(String[] args) {
        work();
    }

    public static void work(){
        Scanner input = new Scanner(System.in);
        System.out.println("****************************************************************");
        System.out.println("**               饿了么商家后台管理系统控制台版                  **");
        System.out.println("****************************************************************");
        BusinessView businessView = new BusinessViewImpl();
        Business business=businessView.login();
        if(business != null){
            int menu=0;
            System.out.println("****************************************************************");
            System.out.println("**           欢迎来到饿了么商家管理系统！请选择服务编号           **");
            System.out.println("****************************************************************");
            while (menu != 5){
                System.out.println("****************************************************************");
                System.out.println("**===一级菜单1.商家信息 2.修改商家信息  3.更改密码  4.商品管理  5.退出系统===**");
                System.out.println("****************************************************************");
                menu = input.nextInt();
                switch (menu){
                    case 1://打印所有商家
                        businessView.showBusinessInfo(business.getBusinessId());
                        break;
                    case 2:
                        businessView.updateBusinessInfo(business.getBusinessId());
                        break;
                    case 3:
                        businessView.updateBusinessPassword(business.getBusinessId());
                        break;
                    case 4:
                        foodManage(business.getBusinessId());
                        break;
                    case 5:break;
                    default:
                        System.out.println("编号输入错误！");
                        break;
                }
            }

        }
        System.out.println("****************************************************************");
        System.out.println("**                       欢迎下次再来！                          **");
        System.out.println("****************************************************************");

    }

    private  static  void foodManage(int businessId){
        FoodView foodView = new FoodViewImpl();
        Scanner input = new Scanner(System.in);


        int menu = 0;
        while (menu!= 5){

            // 创建一个菜单
            System.out.println("========= 二级菜单（美食管理）1.查看食品列表2.新增食品 3.修改食品=4.删除食品=5.返回一级菜单 =========");
            System.out.println("请选择相应的菜单编号");
            menu = input.nextInt();

            switch (menu){
                case 1:
                    foodView.showFoodList(businessId);
                    break;
                case 2:
                    foodView.saveFood(businessId);
                    break;
                case 3:
                    foodView.updateFood(businessId);
                    break;
                case 4:
                    foodView.removeFood(businessId);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("没有这个菜单项");
                    break;
            }

        }

    }
}
