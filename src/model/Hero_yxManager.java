package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hero_yxManager {
	private Hero_yx hero_yx;
	private List<Hero_yx> heros_yx;
	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement ps;
	
	//连接数据库
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
	public void addHero(Hero_yx hero_yx){
		String sql = "insert into Hero values (id,?,?,?,?,?,?)";
		con = getConnection();
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, hero_yx.getHerosName());
			ps.setString(2, hero_yx.getHerosNickName());
			ps.setString(3, hero_yx.getHerosDesc());
			ps.setString(4, hero_yx.getHerosImgS());
			ps.setString(5, hero_yx.getHerosImgB());
			ps.setString(6, hero_yx.getHerosImgM());
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//修改英雄信息
	public void modifyMyhero(Hero_yx hero_yx){
		String sql = "update Hero set HERO_NAME = '?'"
				+ ",HERO_NICKNAME='?'"
				+ ",HERO_DESC='?' "
				+ ",HERO_IMGS='?' "
				+ ",HERO_IMGB='?' "
				+ ",HERO_IMGM='?' "
				+ "WHERE ID = '"+ hero_yx.getHerosID()+"' ";
		
		con = getConnection();
		
		try {
			ps.setString(1, hero_yx.getHerosName());
			ps.setString(2, hero_yx.getHerosNickName());
			ps.setString(3, hero_yx.getHerosDesc());
			ps.setString(4, hero_yx.getHerosImgS());
			ps.setString(5, hero_yx.getHerosImgB());
			ps.setString(6, hero_yx.getHerosImgM());
			ps.executeUpdate();				
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//查询全部英雄信息
	public List<Hero_yx> allHero(){

		con = getConnection();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Hero");
			heros_yx = new ArrayList<Hero_yx>();
			
			while(rs.next()){
				hero_yx = new Hero_yx();
				
				hero_yx.setHerosName(rs.getString("HERO_NAME"));
				hero_yx.setHerosNickName(rs.getString("HERO_NICKNAME"));
				hero_yx.setHerosDesc(rs.getString("HERO_DESC"));
				hero_yx.setHerosImgS(rs.getString("HERO_IMGS"));
				hero_yx.setHerosImgB(rs.getString("HERO_IMGB"));
				hero_yx.setHerosImgM(rs.getString("HERO_IMGM"));
				
				heros_yx.add(hero_yx);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros_yx;
		
	}
	
	//删除英雄信息
	public void deleteHero(Hero_yx hero_yx){
		String sql = "update Hero set HERO_DELETE = true"
				+ "WHERE ID = '"+ hero_yx.getHerosID()+"' ";
		
		con = getConnection();
	}

}
