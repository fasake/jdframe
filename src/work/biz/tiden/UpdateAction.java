package work.biz.tiden;

import org.apache.ibatis.session.SqlSession;

import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.util.*;
import work.biz.tiden.*;

 
// TODO: Auto-generated Javadoc
/** 
 * The Path : work.biz.tiden.UpdateAction
 *  
 * Last-Modified-Time : 2014-1-8 17:05:34
 *
 * @author 
 * @see
 * @version 1.0
 */
public class UpdateAction extends work.biz.tiden.Action {
 
    @Override
	protected String initial() {
		// TODO Auto-generated method stub
		var = sqlsession.selectOne("t_work_tiden#selectByPrimaryKey", var);
    	return INITIAL;
	}
	
 
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		int i = sqlsession.update("t_work_tiden#updateByPrimaryKey", var);
		if(i>0){
			setSystemMessage("Update Item Success!");
		}else{
		    setSystemMessage("Update Item Failed!");
		}
		var = new work.dao.model.T_work_tiden();
		return SUCCESS;
		 
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
  
	}

}
