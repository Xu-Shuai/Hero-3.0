package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.MyEquipment;


public class MyEquipmentMeranag {
	private MyEquipment myEquipment;
	private List<MyEquipment> myEquipments;
	private Statement stmt;
	private ResultSet rs;
	private Connection con;
	private PreparedStatement ps;

	public MyEquipmentMeranag() {		
	}
	//连接数据库
	public Connection getConnection(){
		String DRIVER = "com.mysql.jdbc.Driver";
		String USER = "root";
		String PASS = "root";
		String URL = "jdbc:mysql://localhost:3306/hero";
		try {
			Class.forName(DRIVER);
		    return DriverManager.getConnection(URL,USER,PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	//添加装备
	public void addMyEquipment(MyEquipment myEquipment){
		String sql = "insert into Equipment (NAME,IMGID,BD,SX) values (?,?,?,?)";
		con = getConnection();
		
		try {
			ps = con.prepareStatement(sql);			
			ps.setString(1, myEquipment.getName());
			ps.setString(2, myEquipment.getImgId());
			ps.setString(3, myEquipment.getBd());
			ps.setString(4, myEquipment.getSx());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//分頁查询所有装备
	public List<MyEquipment> allZb(int cp){
		// 1、定义每页要显示的记录数
		int lineSize = 15;
		// 2、定义一个当前是第几页
		int currentPage = 1;
		//接受传过来的当前页
		
		 try{
			  currentPage = cp;
			 }catch(Exception e){
			  e.printStackTrace();
			 }
		 
		con = getConnection();	
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from equipment ORDER BY ID ");
			myEquipments = new ArrayList<MyEquipment>();	
			for(int x=0; x<(currentPage-1)*lineSize; x++){
			  	rs.next();
			 }
			 for(int x=0; x<lineSize; x++){
				  if(rs.next()){
				myEquipment = new MyEquipment();	
				myEquipment.setId(rs.getInt("ID"));
				myEquipment.setName(rs.getString("NAME"));
				myEquipment.setImgId(rs.getString("IMGID"));
				myEquipment.setCurrentPage(currentPage);
				myEquipments.add(myEquipment);
				  }
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myEquipments;		
	}
	//查询某件装备
	public List<MyEquipment> oneEquipment(int id,String name){
		con = getConnection();		
		try {
			stmt = con.createStatement();
			if(name==null){
				rs = stmt.executeQuery("select * from equipment where ID = "+id);
			}else{
				rs = stmt.executeQuery("select * from hero.equipment where NAME like '%"+name+"%'");
			}
			
			myEquipments = new ArrayList<MyEquipment>();			
			while(rs.next()){
				myEquipment = new MyEquipment();	
				myEquipment.setId(rs.getInt("ID"));
				myEquipment.setName(rs.getString("NAME"));
				myEquipment.setImgId(rs.getString("IMGID"));
				myEquipment.setBd(rs.getString("BD"));
				myEquipment.setSx(rs.getString("SX"));				
				myEquipments.add(myEquipment);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myEquipments;		
	}
	
	//修改装备信息
		public void modifyMyhero(MyEquipment myEquipment){
			String sql ="UPDATE equipment SET NAME=?, BD=?, SX=? WHERE ID='"+myEquipment.getId()+"'";
			con = getConnection();
			
			try {
				
				ps = con.prepareStatement(sql);				
				ps.setString(1, myEquipment.getName());
				ps.setString(2, myEquipment.getBd());
				ps.setString(3, myEquipment.getSx());
				ps.executeUpdate();				
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//ajax
		public boolean findByUsername(String name){
			String sql = "select * from hero where NAME = ?";
			con = getConnection();
			boolean isExist = false;
			
			try {
				ps = con.prepareStatement(sql);//预处理
				
				ps.setString(1, name);
				
				rs = ps.executeQuery();//执行
				
				if(rs.next()){
					isExist = true;
				}
				
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return isExist;
		}
		

}
