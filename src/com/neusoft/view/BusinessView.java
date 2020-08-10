package com.neusoft.view;


import com.neusoft.domain.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void deleteBusiness();
    public Business login();
    public void showBusinessInfo(int businessId);
    public void updateBusinessInfo(int businessId);
    public void updateBusinessPassword(int businessId);
}
