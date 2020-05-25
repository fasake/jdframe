package work.biz.swdj.sldj;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import work.biz.swdj.Action;
import work.dao.model.T_work_dj_nsrxx;

import com.jdframe.sys.core.model.Tokens;
import com.jdframe.sys.core.model.UserProfile;
import com.jdframe.sys.core.util.DateUtils;
import com.jdframe.sys.core.util.ValidateUtils;
import com.jdframe.sys.dao.model.T_sys_station;
import com.jdframe.sys.dao.model.T_sys_task;

// TODO: Auto-generated Javadoc

public class NewAction extends Action {

	@Override
	protected String perform() {
		// TODO Auto-generated method stub
		T_work_dj_nsrxx nsrxx = getDj_nsrxx();
		String nsrsbm = sqlsession.selectOne("t_work_dj_nsrxx$getNewNsrxxId");
		nsrxx.setNsrsbm(nsrsbm);
		nsrxx.setZgswjgDm("000000");
		nsrxx.setSwdjzh("-1");
		nsrxx.setNsrztDm("4");
		int i = sqlsession.update("t_work_dj_nsrxx$insertSelective", nsrxx);
		if (i > 0) {
			/**
			 * 1. 首页待办事项标题
			 */
			String task_title = "登记管理：设立登记->确定主管机关";
			/**
			 * 2. 首页待办事项链接, 本系统必须为相对路径，否则为绝对路径
			 */
			String task_link = "/com/jdframe/work/biz/swdj/updateQdzgswjg!init?nsrsbm="
					+ nsrxx.getNsrsbm();
			/**
			 * 3. 系统，01为本系统，本系统可以使用相对路径，否则为其他系统不能使用相对路径
			 */
			String task_from = "01";
			/**
			 * 4. 首页待办事项到期时间
			 */
			String Task_expire_date = DateUtils.newDateTime(5);
			/**
			 * 5. 菜单id,系统根据权限判读那些操作人员有权接收此待办事项
			 */
			String menu_id = "1000028";
			/**
			 * 6. 待办事项优先级
			 */
			Tokens.PRIORITY priority = Tokens.PRIORITY.CRITICAL;
			// 发送待办事宜
			boolean isSend = sendTask(task_title, priority, task_link,
					task_from, Task_expire_date, menu_id);
			if (isSend){
				setSystemMessage("设立登记操作成功！");
			}else{
				setSystemMessage("设立登记操作失败,可能无待办事项接收人员！", true, null);
				sqlsession.rollback();
			}
		} else {
			// 操作失败，并返回input页面
			setSystemMessage("设立登记操作失败！", true, null);
		}
		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		String nsrmc = getDj_nsrxx().getNsrmc();

		if (ValidateUtils.isNullOrEmpty(nsrmc)) {
			this.setSystemMessage("纳税人名称不能为空", true, null);
		}

	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return INITIAL;
	}

}
