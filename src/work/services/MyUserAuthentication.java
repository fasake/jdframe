package work.services;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jdframe.sys.core.model.User;
import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.services.IUserService;

// TODO: Auto-generated Javadoc
/**
 * The Path : work.services.MyUserAuthentication.java
 * The Class MyUserAuthentication.
 * Last-Modified-Time : 2013-12-19 11:06:18
 *
 * @author support@jdframe.com
 * @see
 * @version  2.0.3.0 www.jdframe.com
 */
public class MyUserAuthentication implements IUserService {
   Logger log = Logger.getLogger(MyUserAuthentication.class);
	/* (·Ç Javadoc)
	* <p>Title: doService</p>
	* <p>Description: </p>
	* @param req
	* @param res
	* @see com.jdframe.sys.core.services.IUserService#doService(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	*/
	@Override
	public void doService(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		/**
		 * The basic information of the user logged in 
		 */
		UserProfile profile = (UserProfile) req.getSession().getAttribute(com.jdframe.sys.core.model.Tokens._USER_PROFILE);
		User user = profile.getUser();
		//this is the userdm,such as:76300000000
		String userDm = user.getUser_dm();
		//this is the user's privilege
		HashMap privilege = profile.getPrivilege();
		
		/**
		 * Custom login user additional information, such as: through userDm associated permissions, so that used in the subsequent business functions 
		 * ...
		 */
		req.getSession().setAttribute("fn", "jdframe");
		req.getSession().setAttribute("Version", "v2.0.2.1");
		req.getSession().setAttribute("Attr1", "my attr1.");
        
	}

}
