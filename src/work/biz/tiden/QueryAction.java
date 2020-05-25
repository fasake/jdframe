package work.biz.tiden;

import com.jdframe.sys.core.action.JdframeAction;
import java.util.ArrayList;
import work.biz.tiden.*;
import work.dao.model.T_work_tiden;
 
// TODO: Auto-generated Javadoc
/** 
 * The Path : work.biz.tiden.QueryAction
 *  
 * Last-Modified-Time : 2014-1-8 17:05:34
 *
 * @author 
 * @see
 * @version 1.0
 */
public class QueryAction extends work.biz.tiden.Action {
	
  
   
    @Override
    protected String initial(){
    	var = new T_work_tiden();
    	return INITIAL;
    }
    
	 
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		ArrayList list  = (ArrayList) sqlsession.selectList("t_work_tiden#selectByNoNPrimaryKey_listPage", var);
		this.setPagenationList(list);
		return SUCCESS;
	}

	
 
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
	}
	
  
}
