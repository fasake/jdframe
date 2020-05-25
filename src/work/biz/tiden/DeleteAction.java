package work.biz.tiden;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.util.*;
import work.biz.tiden.*;

 
// TODO: Auto-generated Javadoc
/** 
 * The Path : work.biz.tiden.DeleteAction
 *  
 * Last-Modified-Time : 2014-1-8 17:05:34
 *
 * @author 
 * @see
 * @version 1.0
 */
public class DeleteAction extends work.biz.tiden.Action {
 
    @Override
	protected String initial() {
		// TODO Auto-generated method stub
    	return INITIAL;
	}
	
 
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
			int i = sqlsession.delete("t_work_tiden#deleteByPrimaryKey", var);
			if(i>0){
				setSystemMessage("Delete Item Success!");
			}else{
				setSystemMessage("Delete Item Failed!");
				return INPUT;
			}
		var = new work.dao.model.T_work_tiden();
		return SUCCESS;
		  
	}

 
	
	
 
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
  
	}

  
	
	
	
	
}
