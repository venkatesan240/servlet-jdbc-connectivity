package com.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.server.Register;

public class Crud {
	DbConnetion db=new DbConnetion();
	public void insertRegister(Register regi) throws SQLException, ClassNotFoundException {
		String insertQuery="insert into user_register(name,email,mobile)values(?,?,?)";
		Connection connection = db.getConnection();
		PreparedStatement ps=connection.prepareStatement(insertQuery);
		ps.setString(1,regi.getName());
		ps.setString(2,regi.getEmail());
		ps.setInt(3,regi.getMobile());
		int rows = ps.executeUpdate();
		System.out.println(rows+" user registered sucessfully");
	}
	
	public ArrayList<Register> getAllUsers() throws ClassNotFoundException, SQLException{
		ArrayList<Register> list=new ArrayList<>();
		String getQuery="select userid,name,mobile,email from user_register";
		Connection con=db.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(getQuery);
		while(rs.next()) {
			 Register regi = new Register();
			regi.setId(rs.getInt("userid"));
			regi.setName(rs.getString("name"));
			regi.setEmail(rs.getString("email"));
			regi.setMobile(rs.getInt("mobile"));
			list.add(regi);
		}
		return list;
		
	}
	
	public void deleteUser(int id) throws ClassNotFoundException, SQLException {
		String deleteQuery="delete from user_register where userid=?";
		PreparedStatement ps=db.getConnection().prepareStatement(deleteQuery);
		ps.setInt(1,id);
		ps.executeUpdate();
	}
	
	public void updateUser(Register register) throws ClassNotFoundException, SQLException {
		String updateQuery="update user_register set name=?,email=?,mobile=? where userid=?";
		PreparedStatement ps=db.getConnection().prepareStatement(updateQuery);
		ps.setString(1,register.getName());
		ps.setString(2,register.getEmail());
		ps.setInt(3,register.getMobile());
		ps.setInt(4,register.getId());
		ps.executeUpdate();
	}
}
