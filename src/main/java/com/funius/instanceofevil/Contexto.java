package com.funius.instanceofevil;

import java.util.Random;

public class Contexto {

	public String getAtributo1(){
		Random r=new Random();
		if (r.nextBoolean()){
			return "valor1";
		}
		return null;
	}
	
	public Long getAtributo2(){return 2L;}
	public boolean getAtributo3(){return false;}
	
}
