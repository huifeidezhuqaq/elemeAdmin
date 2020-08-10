package com.neusoft.view.impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.AdminDaoImpl;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() {
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" +
                    b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    @Override
    public void listBusinessBySearch() {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";
        System.out.println("是否需要输入商家名称y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家名称关键字");
            businessName = input.next();
        }
        System.out.println("是否需要输入地址y/n");
        inputStr = input.next();
        if (inputStr.equals("y")) {
            System.out.println("请输入商家地址关键字");
            businessAddress = input.next();
        }

        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() + "\t" + b.getBusinessAddress() + "\t" +
                    b.getBusinessExplain() + "\t" + b.getStarPrice() + "\t" + b.getDeliveryPrice());
        }
    }

    @Override
    public void saveBusiness() {
        System.out.println("输入商家名称");
        String businessName = input.next();
        BusinessDao dao = new BusinessDaoImpl();
        int businessId = dao.saveBusiness(businessName);
        if (businessId > 0) {
            System.out.println("新建成功！编号为：" + businessId);
        } else {
            System.out.println("新建失败！");
        }
    }

    @Override
    public void deleteBusiness() {
        boolean a = false;
        System.out.println("请输入商家编号");
        int businessId = input.nextInt();
        System.out.println("确认要删除吗？y/n");
        String inputDD = input.next();
        if (inputDD.equals("y")) {
            BusinessDao dao = new BusinessDaoImpl();
            a = dao.deleteBusiness(businessId);
        }
        if (a) {
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    @Override
    public Business login() {
        System.out.println("请输入商家ID：");
        int businessId = input.nextInt();
        System.out.println("请输入密码：");
        String password = input.next();
        BusinessDao dao = new BusinessDaoImpl();

        return dao.getBusinessByNameByPass(businessId, password);
    }

    @Override
    public void showBusinessInfo(int businessId) {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        Business business = dao.getBusinessByBusinessId(businessId);
        System.out.println(business);
    }

    @Override
    public void updateBusinessInfo(int businessId) {
        BusinessDao dao = new BusinessDaoImpl();
        Business business = dao.getBusinessByBusinessId(businessId);
        System.out.println(business);
        String str = null;
        System.out.println("是否修改商家名称y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新名字");
            business.setBusinessName(input.next());
            str = null;
        }
        System.out.println("是否修改商家地址y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新地址");
            business.setBusinessAddress(input.next());
            str = null;
        }
        System.out.println("是否修改商家介绍y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新介绍");
            business.setBusinessExplain(input.next());
            str = null;
        }
        System.out.println("是否修改商家起送费y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新起送费");
            business.setStarPrice(input.nextDouble());
            str = null;
        }
        System.out.println("是否修改商家配送费y/n");
        str = input.next();
        if (str.equalsIgnoreCase("y")) {
            System.out.println("请输入新配送费");
            business.setDeliveryPrice(input.nextDouble());
            str = null;
        }
        System.out.println(business);
        int res = dao.updateBusiness(business);
        if (res > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    @Override
    public void updateBusinessPassword(int businessId) {
        int res = 0;
        Business business = new Business();
        BusinessDao dao = new BusinessDaoImpl();
        business = dao.getBusinessByBusinessId(businessId);
        System.out.println("请输入旧密码");
        String oldPassword = input.next();
        if(oldPassword.equals(business.getPassword())){
            System.out.println("请输入新密码");
            String a=input.next();
            System.out.println("请再次输入新密码");
            String b=input.next();
            if(a.equals(b)){
                business.setPassword(a);
                res = dao.updateBusinessPassword(business);
            }else {
                System.out.println("两次输入密码不一致");
            }
        }else {
            System.out.println("密码错误！");
        }
        if (res > 0) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }
}