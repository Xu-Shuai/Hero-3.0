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
	
	//�������ݿ�
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
	
	//���Ӣ����Ϣ
	public void addHero(Hero_yx hero_yx){
		String sql = "insert into Hero (HERO_NAME,HERO_NICKNAME,HERO_DESC,HERO_IMGB,HERO_IMGM) values (?,?,?,?,?)";
		
		con = getConnection();
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, hero_yx.getHerosName());
			ps.setString(2, hero_yx.getHerosNickName());
			ps.setString(3, hero_yx.getHerosDesc());
			
			ps.setString(4, hero_yx.getHerosImgB());
			ps.setString(5, hero_yx.getHerosImgM());
			
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�޸�Ӣ����Ϣ
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

	
	//��ѯȫ��Ӣ����Ϣ
	public List<Hero_yx> allHero(int cp){
		// 1������ÿҳҪ��ʾ�ļ�¼��
				int lineSize = 16;
				// 2������һ����ǰ�ǵڼ�ҳ
				int currentPage = 1;
				//���ܴ������ĵ�ǰҳ
				
				 try{
					  currentPage = cp;
					 }catch(Exception e){
					  e.printStackTrace();
					 }

		con = getConnection();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Hero where HERO_DELETE = false");
			heros_yx = new ArrayList<Hero_yx>();
			
			for(int x=0; x<(currentPage-1)*lineSize; x++){
			  	rs.next();
			 }
			 for(int x=0; x<lineSize; x++){
				  if(rs.next()){
					  hero_yx = new Hero_yx();
						hero_yx.setHerosID(rs.getInt("HERO_ID"));
						hero_yx.setHerosName(rs.getString("HERO_NAME"));
						hero_yx.setHerosNickName(rs.getString("HERO_NICKNAME"));
						hero_yx.setHerosDesc(rs.getString("HERO_DESC"));
						hero_yx.setHerosImgS(rs.getString("HERO_IMGS"));
						hero_yx.setHerosImgB(rs.getString("HERO_IMGB"));
						hero_yx.setHerosImgM(rs.getString("HERO_IMGM"));
						hero_yx.setCurrentPage(currentPage);
						
						heros_yx.add(hero_yx);
				  }
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heros_yx;
		
	}
	
	//��ѯĳ��Ӣ��
	public List<Hero_yx> oneheros_yx(int herosID){
		con = getConnection();		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from hero where HERO_ID = "+ herosID);
			heros_yx = new ArrayList<Hero_yx>();			
			while(rs.next()){
				hero_yx=new Hero_yx();
				hero_yx.setHerosID(rs.getInt("HERO_ID"));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros_yx;		
	}
	
	//ɾ��Ӣ����Ϣ
	public void deleteHero(int  hero_yx){
//		String sql = "delete from Hero where HERO_ID ="+ hero_yx;
		String sql = "update Hero set HERO_DELETE = true where HERO_ID="+ hero_yx;
		
		con = getConnection();
		try {
			
			ps = con.prepareStatement(sql);
			ps.executeUpdate();	
			//�ر�
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean findByUsername(String herosName){
		String sql = "select * from Hero where HERO_NAME = ?";
		con = getConnection();
		boolean isExist = false;
		
		try {
			ps = con.prepareStatement(sql);//Ԥ����
			
			ps.setString(1, herosName);
			
			rs = ps.executeQuery();//ִ��
			
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
