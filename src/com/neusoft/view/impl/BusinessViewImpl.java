package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    Scanner input = new Scanner(System.in);

    @Override
    public void listBusinessAll() {
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list=dao.listBusiness(null,null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b:list){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+
                    b.getBusinessExplain()+"\t"+b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }

    @Override
    public void listBusinessBySearch() {
        String businessName = "";
        String businessAddress = "";
        String inputStr = "";
        System.out.println("是否需要输入商家名称y/n");
        inputStr = input.next();
        if(inputStr.equals("y")){
            System.out.println("请输入商家名称关键字");
            businessName=input.next();
        }
        System.out.println("是否需要输入地址y/n");
        inputStr = input.next();
        if(inputStr.equals("y")){
            System.out.println("请输入商家地址关键字");
            businessAddress=input.next();
        }

        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list=dao.listBusiness(businessName,businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b:list){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+
                    b.getBusinessExplain()+"\t"+b.getStarPrice()+"\t"+b.getDeliveryPrice());
        }
    }

    @Override
    public void saveBusiness() {
        System.out.println("输入商家名称");
        String businessName = input.next();
        BusinessDao dao = new BusinessDaoImpl();
        int businessId=dao.saveBusiness(businessName);
        if(businessId > 0){
            System.out.println("新建成功！编号为："+businessId);
        }else {
            System.out.println("新建失败！");
        }
    }

    @Override
    public void deleteBusiness() {
        boolean a=false;
        System.out.println("请输入商家编号");
        int businessId=input.nextInt();
        System.out.println("确认要删除吗？y/n");
        String inputDD=input.next();
        if(inputDD.equals("y")){
            BusinessDao dao = new BusinessDaoImpl();
            a=dao.deleteBusiness(businessId);
        }
        if(a){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }
    }
}
