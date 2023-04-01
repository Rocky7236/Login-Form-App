package com.prog.Dao;

import com.prog.bean.Customer;

public interface CustomerDao {
public int insertCustomer(Customer cus);
public Customer getCustomer(String Username , String pass);
}
