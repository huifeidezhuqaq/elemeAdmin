package com.neusoft.dao;

import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
    public List<Business> listBusiness(String businessName,String businessAddress);
    public int saveBusiness(String businessName);
    public boolean deleteBusiness(int businessId);
}
