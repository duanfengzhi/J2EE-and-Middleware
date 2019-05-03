package com.test;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.bean.ManagedBean;

public class MyConverter implements Converter {

	public String[] getAsObject(FacesContext context, UIComponent component, String str){
		
		String [] ss=str.split(":");
		
		return ss;
		
		
	}
	public String getAsString(FacesContext context, UIComponent component, Object obj){
		
		
		return obj.toString();
		
	}


}
