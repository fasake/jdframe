package work.biz.tiden;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.core.util.*;
import work.biz.tiden.*;
 
// TODO: Auto-generated Javadoc
/** 
 * The Path : work.biz.tiden.NewAction
 *  
 * Last-Modified-Time : 2014-1-8 17:05:34
 *
 * @author 
 * @see
 * @version 1.0
 */
public class NewAction extends work.biz.tiden.Action {
	
  
   
    @Override
    protected String initial(){
    	return INITIAL;
    }
    
	 
	@Override
	protected String perform() {
	    // TODO Auto-generated 
	//Initialization Primary Key Propertity! 
	if(StringUtils.isEmptyOrNull(var.getLinenumber()))
		var.setLinenumber(DbUtils.getAutoIncrementLsb("t_work_tiden", "LINENUMBER"));
	if(StringUtils.isEmptyOrNull(var.getTpayer()))
		var.setTpayer(DbUtils.getRandomStringLsb().substring(0,20));

		int i = sqlsession.update("t_work_tiden#insertSelective",var);
		if(i>0){
		    /**
			String task_title = "Title";
			String task_link = "url";
			String task_from = "01";//SystemId
			String Task_expire_date = DateUtils._newDateTime(5);
			String menu_id = "1000028";
			
			//Send Task
			boolean isSend  =  _sendTask(task_title, Tokens._priority.CRITICAL, task_link, task_from, Task_expire_date, menu_id);
			if(isSend)
			 setSystemMessage("Success!");
			else
			 setSystemMessage("Send Failed!",true,null);
			*/
			 var = null;
			 var = new work.dao.model.T_work_tiden();
			 setSystemMessage("Save Item Success!",true,null);
		}else{
			//fail
			setSystemMessage("Save Item Failed!",true,null);
		}
		 
		var = new work.dao.model.T_work_tiden();
		return SUCCESS;
	}

	
 
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
	}
	
 
	 
}
