package com.funius.instanceofevil.yy;

import com.funius.instanceofevil.Visible;
import com.funius.instanceofevil.template.HasTemplate;

public class HasYY implements Visible, HasTemplate {

	private int attr;
	private String template;
	
	public HasYY(int attr){
		this.attr=attr;
	}
	
	public HasYY(int attr,String template){
		this.attr=attr;
		this.template=template;
	}

	
	public int getAttr(){
		return attr;
	}

	@Override
	public String getTemplate() {
		//A veces puede tomar valor y a veces devolver null
		return template;
	}

	@Override
	public String getId() {
		return "1";
	}

	@Override
	public void setId(String id) {
	}
	
	//M‡s atributos que ser‡n usados en YYPrint
}
