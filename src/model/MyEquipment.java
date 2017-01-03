package model;

public class MyEquipment {
	private int id;
	private String name;
	private String imgId;
	private String bd;
	private String sx;

	public MyEquipment() {		
		 
	}
	public MyEquipment(int id,String name,String imgId,String bd,String sx) {
		this.id=id;
		this.name=name;
		this.imgId=imgId;
		this.bd=bd;
		this.sx=sx;	 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgId() {
		return imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getSx() {
		return sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}

}
