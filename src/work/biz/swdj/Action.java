package work.biz.swdj;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import work.dao.model.T_work_dj_nsrxx;

import com.jdframe.sys.core.action.JdframeAction;
import com.jdframe.sys.dao.model.T_sys_role;
import com.jdframe.sys.dao.model.T_sys_station;

 
public abstract class Action extends JdframeAction {
	
    
	//通用对象
	/** The station. */
	protected T_work_dj_nsrxx dj_nsrxx = new T_work_dj_nsrxx();

	public T_work_dj_nsrxx getDj_nsrxx() {
		return dj_nsrxx;
	}

	public void setDj_nsrxx(T_work_dj_nsrxx dj_nsrxx) {
		this.dj_nsrxx = dj_nsrxx;
	}
    
}
