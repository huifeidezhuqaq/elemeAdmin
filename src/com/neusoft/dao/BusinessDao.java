package com.neusoft.dao;

import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;

import java.util.List;

public interface BusinessDao {
    public List<Business> listBusiness(String businessName,String businessAddress);
    public int saveBusiness(String businessName);
    public boolean deleteBusiness(int businessId);
    public Business getBusinessByNameByPass(int businessId, String password);
    public Business getBusinessByBusinessId(int businessId);
    public int updateBusiness(Business business);
    public int updateBusinessPassword(Business business);
}
