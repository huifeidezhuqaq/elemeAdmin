package com.neusoft.dao.Impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Business;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    Connection conn = null;
    private  PreparedStatement pstmt = null;
    private ResultSet rs = null;
    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        ArrayList<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if(businessName != null && !businessName.equals("")){
            sql.append(" and businessName like '%").append(businessName).append("%' ");
        }if(businessAddress != null && !businessAddress.equals("")){
            sql.append(" and businessAddress like '%").append(businessAddress).append("%' ");
        }
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    @Override
    public int saveBusiness(String businessNema) {
        List<Business> list = new ArrayList<>();
        try{
        conn = JDBCUtils.getConnection();
        String sql="INSERT INTO business(business.businessName,business.`password`) VALUES(?,123);";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,businessNema);
        pstmt.executeUpdate();
        list=listBusiness2(businessNema);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list.get(0).getBusinessId();
    }

    @Override
    public boolean deleteBusiness(int businessId) {
        List<Business> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            String sql="delete from business where businessId=?;";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            pstmt.executeUpdate();
            list=listBusiness3(businessId);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        if(list.size()<1){
            return true;
        }else {
            return false;
        }


    }

    public List<Business> listBusiness2(String businessName) {
            List<Business> list = new ArrayList<>();
            String sql ="select * from business where businessName=?";
            try{
                conn = JDBCUtils.getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,businessName);
                rs = pstmt.executeQuery();
                while (rs.next()){
                    Business business = new Business();
                    business.setBusinessId(rs.getInt("businessId"));
                    business.setPassword(rs.getString("password"));
                    business.setBusinessAddress(rs.getString("businessAddress"));
                    business.setBusinessName(rs.getString("businessName"));
                    business.setBusinessExplain(rs.getString("businessExplain"));
                    business.setStarPrice(rs.getDouble("starPrice"));
                    business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                    list.add(business);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                JDBCUtils.close(rs, pstmt, conn);
            }
            return list;
        }

    public List<Business> listBusiness3(int businessId) {
        List<Business> list = new ArrayList<>();
        String sql ="select * from business where businessId=?";
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setPassword(rs.getString("password"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                list.add(business);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pstmt, conn);
        }
        return list;
    }


}
