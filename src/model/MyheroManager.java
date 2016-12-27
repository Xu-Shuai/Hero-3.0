package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class MyheroManager {
	private Myhero myhero;
	private List<Myhero> myheros;
	//从这里开始 下面的我都看不懂
	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement ps;
	
	
	public Connection getConnection(){
		String DRIVER = "com.mysql.jdbc.Driver";
		String USER = "root";
		String PASS = "root";
		String URL = "jdbc:mysql://localhost:3306/myhero";
		try {
			Class.forName(DRIVER);
		    return DriverManager.getConnection(URL,USER,PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//添加英雄信息
	public void addMyhero(Myhero myhero){
		String sql = "insert into myhero values (id,?,?,?)";
		con = getConnection();
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, myhero.getHeroName());
			ps.setString(2, myhero.getHeroCode());
			ps.setString(3, myhero.getHeroLogo());
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//修改英雄信息
	public void modifyMyhero(Myhero myhero){
		
	}
	//查询全部英雄信息
	public List<Myhero> allMusic(){

		con = getConnection();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from gedan");
			myheros = new ArrayList<Myhero>();
			
			while(rs.next()){
				myhero = new Myhero();
				
				myhero.setHeroName(rs.getString("heroName"));
				myhero.setHeroCode(rs.getString("heroCode"));
				myhero.setHeroLogo(rs.getString("heroLogo"));
				
				myheros.add(myhero);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myheros;
		
	}
}
