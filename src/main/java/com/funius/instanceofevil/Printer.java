package com.funius.instanceofevil;

import java.util.List;

import com.funius.instanceofevil.template.HasTemplate;
import com.funius.instanceofevil.template.Repository;
import com.funius.instanceofevil.template.TemplatePrint;
import com.funius.instanceofevil.xx.HasXX;
import com.funius.instanceofevil.xx.XXPrint;
import com.funius.instanceofevil.yy.HasYY;
import com.funius.instanceofevil.yy.YYPrint1;
import com.funius.instanceofevil.yy.YYPrint2;
import com.funius.instanceofevil.zz.HasZZ;

public class Printer {

	private Contexto context;
	
	private Repository repository;
	
	public Printer(Contexto context,Repository repository){
		this.context=context;
		this.repository=repository;
	}
	
	public void print(List<Visible> collection){
		for (Visible visible : collection) {
			print(visible);
		}
	}
	
	
	public void print(Visible visible){
		if (visible instanceof HasTemplate){
			HasTemplate objectWithTemplate=(HasTemplate) visible;
			String template=objectWithTemplate.getTemplate();
			if (template==null){
				template=repository.getTemplate(context.getAtributo1());
			}
			if (template!=null){
				TemplatePrint print=new TemplatePrint(template);
				print.print(objectWithTemplate,context.getAtributo1());
				return;
			}				
		}
		
		if (visible instanceof HasZZ){
			return;
		} if (visible instanceof HasXX){
			HasXX objectWithXX=(HasXX) visible;
			XXPrint print=new XXPrint();
			print.print(objectWithXX,context.getAtributo2(), context.getAtributo3());
		}else if (visible instanceof HasYY){
			HasYY objectWithYY=(HasYY) visible;
			if (objectWithYY.getAttr()<0){
				YYPrint1 print=new YYPrint1();
				print.print(objectWithYY,context.getAtributo1());
			}else{
				YYPrint2 print=new YYPrint2();
				print.print(objectWithYY,context.getAtributo2());
			}
		}
	}
}
