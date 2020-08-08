package com.neusoft;

import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;
import com.neusoft.view.BusinessView;
import com.neusoft.view.impl.AdminViewImpl;
import com.neusoft.view.impl.BusinessViewImpl;

import java.util.Scanner;

public class ElmAdmin {
    public static void main(String[] args) {
        work();
    }
    public static void work(){
        Scanner input = new Scanner(System.in);
        System.out.println("****************************************************************");
        System.out.println("**               饿了么商家后台管理系统控制台版                  **");
        System.out.println("****************************************************************");
        AdminView adminView = new AdminViewImpl();
        BusinessView businessView = new BusinessViewImpl();
        Admin admin=adminView.login();
        if(admin != null){
            int menu=0;
            System.out.println("****************************************************************");
            System.out.println("**           欢迎来到饿了么商家管理系统！请选择服务编号           **");
            System.out.println("****************************************************************");
            while (menu != 5){
                System.out.println("****************************************************************");
                System.out.println("**===1.所有商家  2.搜索商家  3.新建商家  4.删除商家  5.退出系统===**");
                System.out.println("****************************************************************");
                menu = input.nextInt();
                switch (menu){
                    case 1://打印所有商家
                        businessView.listBusinessAll();
                        break;
                    case 2:
                        businessView.listBusinessBySearch();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.deleteBusiness();
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
}
