package work.biz.tiden;

import com.jdframe.sys.core.action.JdframeAction;
import work.biz.tiden.*;
 
// TODO: Auto-generated Javadoc
/** 
 * The Path : work.biz.tiden.Action
 *  
 * Last-Modified-Time : 2014-1-8 17:05:34
 *
 * @author 
 * @see
 * @version 1.0
 */
public abstract class Action extends JdframeAction {
	//Auto-generated Propertity
	protected work.dao.model.T_work_tiden var = new work.dao.model.T_work_tiden();
	
	public work.dao.model.T_work_tiden getVar() {
		return var;
	}

	public void setVar(work.dao.model.T_work_tiden var) {
		this.var = var;
	}
}
