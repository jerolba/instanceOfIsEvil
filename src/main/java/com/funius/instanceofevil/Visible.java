package com.funius.instanceofevil;

import java.io.Serializable;

public interface Visible extends Serializable {

	String getId();
	void setId(String id);
	
	void accept(Visitor visitor);
}
