package com.javaex.ex;

public class Phone{
	
	private String name;
	private String hp;
	private String cp;

	// 생성자
	public Phone() {}

	public Phone(String name, String hp, String cp) {
		this.name = name;
		this.hp = hp;
		this.cp = cp;
	}

	// 메소드 gs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	// 메소드 일반
	@Override
	public String toString() {
		return "Phone [name=" + name + ", hp=" + hp + ", cp=" + cp + "]";
	}

	public void showInfo() {
		System.out.println(name + "    " + hp + "    " + cp);
	}
}
