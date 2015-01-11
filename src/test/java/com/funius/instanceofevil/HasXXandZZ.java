package com.funius.instanceofevil;

import com.funius.instanceofevil.xx.HasXX;
import com.funius.instanceofevil.zz.HasZZ;

public class HasXXandZZ extends HasXX implements HasZZ{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit((HasZZ)this);
	}
}
