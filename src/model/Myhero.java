package model;

public class Myhero {
	private int id;
	private String heroName;
	private String heroCode;
	private String heroLogo;
	
	public Myhero(int id) {
		//���Ǹ��������Ĺ��췽��
		this.id = id;
	}
	public  Myhero(){
		//���Ǹ��յĹ��췽��
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getHeroCode() {
		return heroCode;
	}

	public void setHeroCode(String heroCode) {
		this.heroCode = heroCode;
	}

	public String getHeroLogo() {
		return heroLogo;
	}

	public void setHeroLogo(String heroLogo) {
		this.heroLogo = heroLogo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	

}
