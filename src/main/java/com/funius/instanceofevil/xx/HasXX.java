package com.funius.instanceofevil.xx;

import com.funius.instanceofevil.Visible;
import com.funius.instanceofevil.Visitor;

public class HasXX implements Visible{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public String getId() {
		return "2";
	}

	@Override
	public void setId(String id) {
	}

	//Atributos usados en XXprint
}
