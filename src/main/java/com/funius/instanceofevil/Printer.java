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
	
	
	/*
	 	Objetivo: Hay que eliminar los instanceof
		Lo único que comparten todas las clases es la interface Visible
		Para simplificar el ejemplo HasXX y HasYY son clases, pero podrían ser interfaces
		
		Restricciones: 
			* NO PODEMOS mover la implementación de las clases __Print a las clases HasXX y HasYY
			* Las clases que implementan Visible son POJOs y Serializables (resumiento: se puede generar un XML, JSON, etc
			* Los métodos print son cada uno distinto, no tienen ninguno los mismos parámetros o tipos
		
		
		El primer refáctoring está claro, pero os recuerdo que hay que quitar el instanceof, no sacar lo
		que hay dentro de los ifs a otro lado :) 
		
		Hay que intentar dejar los Pojos lo más inalterados posibles, no tienen la culpa de llenarles de métodos y 
		atributos que no tienen que ver con su función, por no saber quitar el instanceof para sacarlos por pantalla.
		
		Os recuerdo que hay que QUITAR los InstanceOf, NO TRASLADARLOS a otra clase (como los __Print)
	*/
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
