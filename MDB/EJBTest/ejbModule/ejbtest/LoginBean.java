package ejbtest;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local()
public class LoginBean implements Login {
	
	public boolean isTrue(String username ,String password){
			
	if((username.equals("admin"))&&(password.equals("admin123")))
		return true;
	
	else return false;
	
	
   }

}
