package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.MyConnection;
import com.dto.LoginDTO;

public class LoginDAO {
	
	public String loginverify(LoginDTO loginDTO) throws Exception{
		String ret="error";
		Connection con=null;
		try{
			con=new MyConnection().getConnection();
			if(con!=null) {
				
			}
			//login table ek view h
			PreparedStatement ps = con.prepareStatement("select * from login where emailid=? and password=?");
			ps.setString(1,loginDTO.getEmailid());
			ps.setString(2,loginDTO.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				ret=rs.getString("ul");
			}
			rs.close();
			ps.close();
		}finally{
			con.close();
		}
		return ret;
	}
}
