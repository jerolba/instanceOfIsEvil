package com.funius.instanceofevil;

import com.funius.instanceofevil.template.Repository;
import com.funius.instanceofevil.xx.HasXX;
import com.funius.instanceofevil.yy.HasYY;
import com.funius.instanceofevil.zz.HasZZ;

public class Probar {

	public static void main(String[] params){
		Printer printer=new Printer(new Contexto(), new Repository());
		
		HasXX xx=new HasXX();
		printer.print(xx);
		
		HasYY yy1=new HasYY(-1);
		printer.print(yy1);
		
		HasYY yy2=new HasYY(1);
		printer.print(yy2);
		
		HasYY yy3=new HasYY(10,"template1");
		printer.print(yy3);
		
		HasZZ zz=new HasZZ() {

			@Override
			public String getId() {
				return null;
			}

			@Override
			public void setId(String id) {
		}};
		printer.print(zz);
		
		
	}
}
