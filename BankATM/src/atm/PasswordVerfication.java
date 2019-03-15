package atm;

import java.util.HashMap;

public class PasswordVerfication {
	

HashMap<String, String> dictionary ;
	
public PasswordVerfication()
{
	dictionary =  new HashMap<String, String>();
	dictionary.put("moataz", "5602");
	dictionary.put("cce20", "aaa");
	
}
		public boolean nameAndPwChecker(String user , String Password)
			{	
				String fetchedPw = (String) dictionary.get(user.toLowerCase());
				if (fetchedPw != null)
					{
						return (fetchedPw.equalsIgnoreCase(Password));
					}
					else return false;
	}
}










