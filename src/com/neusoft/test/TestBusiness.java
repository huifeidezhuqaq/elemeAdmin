package com.neusoft.test;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.Impl.BusinessDaoImpl;
import com.neusoft.domain.Business;

import java.util.ArrayList;
import java.util.List;

public class TestBusiness {
    public static void main(String[] args) {
        BusinessDao businessDao = new BusinessDaoImpl();
        List<Business> list= new ArrayList<>();
        list = businessDao.listBusiness("饺子","沈阳");
        for (Business business:list){
            System.out.println(business);
        }
    }
}
