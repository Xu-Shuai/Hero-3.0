package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Myhero;

public class MyheroManager {

	private Myhero hero;//保存从数据库内获取的一个英雄数据
	private List<Myhero> heroes;//保存从数据库内获取的多个英雄数据
	
	private Connection conn; //数据库相关变量
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	
	/*
	 * 根据传递过来的id查找一个英雄
	 */
	public Myhero findOne(int id) {
		
		conn = getConnetion();
		
		try {
			
			stmt = conn.createStatement();
			//执行查询
			rs=stmt.executeQuery("select * from hero where id = " + id);
			
			hero = new Myhero(id);
			
			//将获取到的结果集(rs)，放到hero里面封装好。
			while(rs.next()){
				hero.setHeroName(rs.getString("heroName"));
				hero.setHeroCode(rs.getString("heroCode"));
				hero.setHeroLogo(rs.getString("heroLogo"));
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		//返回封装好的hero。
		return hero;
	}
	
	/*
	 * 查找所有英雄
	 */
	public List<Myhero> findAll() {
		conn = getConnetion();
		try {
			stmt = conn.createStatement();
			//执行查询
			rs=stmt.executeQuery("select * from hero");
			
			//声明一个列表变量heroes来放所有的hero
			heroes = new ArrayList<Myhero>();
			
			while(rs.next()){
				//每读一条数据就新生成一个hero
				hero = new Myhero();
				//将每一条数据的值取出，放入刚才声明的hero。
				hero.setId(rs.getInt("id"));
				hero.setHeroName(rs.getString("name"));
				hero.setHeroCode(rs.getString("nick_name"));
				hero.setHeroLogo(rs.getString("image"));
				//将装好的hero放到之前申明的heroes列表中。
				heroes.add(hero);
			}
			
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回所有的英雄
		return heroes;
	}
	
	/*
	 * 增加一个英雄
	 */
	public void add(Myhero hero){
		
		String sql = "insert into hero (name, nick_name, avatar, image, description) values(?,?,?,?,?)";
		conn = getConnetion();
		
		try {
			//预处理，准备向数据库插入新的英雄
			ps = conn.prepareStatement(sql);
			//从传递过来的hero中取出英雄的属性，放入将要查询的sql中。
			ps.setString(1, hero.getHeroName());
			ps.setString(2, hero.getHeroCode());
			ps.setString(3, hero.getHeroLogo());
			
			//执行查询。
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 修改一个英雄
	 */
	public void modify(Myhero hero) {
		
		String sql = "update hero set name = ?, nick_name = ?, avatoar = ?"
					+ "image = ?, description = ? where id = ?" ;
		
		conn = getConnetion();
		
		try {
			//预处理，准备向数据库更新的英雄
			ps = conn.prepareStatement(sql);
			//从传递过来的hero中取出英雄的属性，放入将要查询的sql中。
			ps.setString(1, hero.getHeroName());
			ps.setString(2, hero.getHeroCode());
			ps.setString(3, hero.getHeroLogo());
			ps.setInt(6, hero.getId());
			//执行查询。
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * 获取数据库连接
	 */
	public Connection getConnetion(){
		
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/material";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url, user, password);//将连接好的对象connection返回，供调用。
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public MyheroManager() {
	}

}
