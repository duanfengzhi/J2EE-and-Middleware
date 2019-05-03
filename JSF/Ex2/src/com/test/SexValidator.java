package com.test;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class SexValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object  obj)
			throws ValidatorException {
		
		String sex=(String)obj;
		if(!(sex.equals("F")||sex.equals("M"))){
			FacesMessage message = new FacesMessage( 
					FacesMessage.SEVERITY_ERROR,"�Ա������д�","�Ա�ֻ����'F'��'M'");
					throw new ValidatorException(message);
			
	  }
	}

}
