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
		String sql = "insert into Equipment values (id,?,?,?,?)";
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
	//查询所有装备
	public List<MyEquipment> allMusic(){
		con = getConnection();		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Equipment");
			myEquipments = new ArrayList<MyEquipment>();			
			while(rs.next()){
				myEquipment = new MyEquipment();				
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
	//修改英雄信息
		public void modifyMyhero(MyEquipment myEquipment){
			String sql = "UPDATE Equipment SET NAME = '?'"
					+ ",IMGID='?'"
					+ ",BD='?'"
					+ ",SX='?' WHERE ID = '"+myEquipment.getId()+"' ";
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
		

}
