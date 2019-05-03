package com.hgd;

public class Fruit {

	private  int appleAmount;
	private  int bananaAmount;
	private  int grapeAmount;
	
	public Fruit(){
		this.appleAmount=this.bananaAmount=this.grapeAmount=0;
	}
	public void set(int a,int b,int c){
		this.appleAmount=a;
		this.bananaAmount=b;
		this.grapeAmount=c;
	}
	
	public int getA(){
		return appleAmount;
	}
	
	public int getB(){
		return bananaAmount;
	}
	
	public int getG(){
		return grapeAmount;
	}
	
}
