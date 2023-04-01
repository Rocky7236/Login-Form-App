package com.prog.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.prog.bean.Customer;

public class CustomerImpl implements CustomerDao{

	static Connection con = null;
	static PreparedStatement psmt;
	@Override
	public int insertCustomer(Customer c) {
		int status = 0;
		
		try {
			
			con= Get_Connection.getConnection();
			psmt = con.prepareStatement("insert into customer values(?,?,?)");
			psmt.setString(1,c.getUsername());
			psmt.setString(2,c.getPassword());
			psmt.setString(3,c.getName());
			status = psmt.executeUpdate();
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public Customer getCustomer(String Username, String pass) {
		
		Customer cus = new Customer();
		try {
			con= Get_Connection.getConnection();
			psmt = con.prepareStatement("select * from customer where username=? and password=?");
			psmt.setString(1,Username);
			psmt.setString(2,pass);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next())
			{
			cus.setUsername(rs.getString(1));
			cus.setPassword(rs.getString(2));
			cus.setName(rs.getString(3));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return cus;

}
}
