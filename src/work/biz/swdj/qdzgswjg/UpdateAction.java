package work.biz.swdj.qdzgswjg;


import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import work.biz.swdj.Action;
import work.dao.model.T_work_dj_nsrxx;

import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_station;
import com.jdframe.sys.dao.model.T_sys_task;

// TODO: Auto-generated Javadoc
 
/**
 * The Class QdzgswjgUpdateAction.
 * 
 * @copyright www.jdframe.com
 * @Package work.biz.swdj.qdzgswjg
 * @Description: TODO
 * @author: support@jdframe.com
 * @date: 2013-9-17 15:20:58
 * @version v1.0
 */
public class UpdateAction extends Action {
	//下级主管税务机关集合
	/** The sub org. */
	public HashMap subOrg = new HashMap();
	//请求参数， 纳税人识别码 
    /** The nsrsbm. */
	public String nsrsbm = "";
	 
	
	/* (非 Javadoc)
	* <p>Title: perform</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#perform()
	*/
	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		T_work_dj_nsrxx nsrxx = getDj_nsrxx();
		Date s = nsrxx.getDjzjyqxqsrq();
		Date e = nsrxx.getDjzjyqxzzrq();
		String nsrsbm = ValidateUtils.sNull(getActionArguments("nsrsbm"));
		nsrxx.setNsrsbm(nsrsbm);
		nsrxx.setZgswjgDm("000000");
		nsrxx.setSwdjzh("-1");
		nsrxx.setNsrztDm("4");
		int i = sqlsession.update("t_work_dj_nsrxx$updateByPrimaryKeySelective",nsrxx);
		if(i>0){
			 
			try {
				boolean o = finishTask(ValidateUtils.sNull(getActionArguments("task_id")));
				if(!o){
					setSystemMessage("确定主管机关操作失败！",true,null);
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				setSystemMessage("确定主管机关操作失败！",true,null);
				e1.printStackTrace();
				
			}
			setSystemMessage("确定主管机关操作成功！");
		}else{
			//操作失败，并返回input页面
			setSystemMessage("确定主管机关操作失败！",true,null);
		}
		return SUCCESS;
	}

	/* (非 Javadoc)
	* <p>Title: validators</p>
	* <p>Description: </p>
	* @see com.jdframe.sys.core.action.JdframeAction#validators()
	*/
	@Override
	protected void validators() {
		// TODO Auto-generated method stub
//		String nsrmc = getDj_nsrxx().getNsrmc();
//		
//		if(Tools.isNullOrEmpty(nsrmc)){
//			this.setSystemMessage("纳税人名称不能为空","");
//		}
		
	}

	/* (非 Javadoc)
	* <p>Title: initial</p>
	* <p>Description: </p>
	* @return
	* @see com.jdframe.sys.core.action.JdframeAction#initial()
	*/
	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		String zzjg_dm_sj= getUserProfileFromSession().getUser().getUser_zzjg_sj().getZzjg_dm();
		String nsrsbm = getNsrsbm();
		String task_id = getTask_id();
		
		T_work_dj_nsrxx nsrxx = sqlsession.selectOne("t_work_dj_nsrxx$selectByPrimaryKey", nsrsbm);
		if(nsrxx!=null){
			setDj_nsrxx(nsrxx);
		}
		String zzjg_bz="J";
		subOrg = getSubOrgDmAndMcByDmAndBz(zzjg_dm_sj, zzjg_bz);
		
		setActonArguments("nsrsbm", nsrsbm);
		setActonArguments("task_id", task_id);
		return INITIAL;
	}
	
	
	/**
	 * Gets the sub org.
	 *
	 * @return the sub org
	 */
	public HashMap getSubOrg() {
		return subOrg;
	}

	/**
	 * Sets the sub org.
	 *
	 * @param subOrg the new sub org
	 */
	public void setSubOrg(HashMap subOrg) {
		this.subOrg = subOrg;
	}

	/**
	 * Gets the nsrsbm.
	 *
	 * @return the nsrsbm
	 */
	public String getNsrsbm() {
		return nsrsbm;
	}

	/**
	 * Sets the nsrsbm.
	 *
	 * @param nsrsbm the new nsrsbm
	 */
	public void setNsrsbm(String nsrsbm) {
		this.nsrsbm = nsrsbm;
	}

	 
}
