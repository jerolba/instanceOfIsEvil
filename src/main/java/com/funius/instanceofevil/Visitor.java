package com.funius.instanceofevil;

import com.funius.instanceofevil.template.HasTemplate;
import com.funius.instanceofevil.xx.HasXX;
import com.funius.instanceofevil.yy.HasYY;
import com.funius.instanceofevil.zz.HasZZ;

public interface Visitor {
	void visit(HasXX visited);
	void visit(HasYY visited);
	void visit(HasZZ visited);
}
