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
			 * 1. ��ҳ�����������
			 */
			String task_title = "�Ǽǹ��������Ǽ�->ȷ�����ܻ���";
			/**
			 * 2. ��ҳ������������, ��ϵͳ����Ϊ���·��������Ϊ����·��
			 */
			String task_link = "/com/jdframe/work/biz/swdj/updateQdzgswjg!init?nsrsbm="
					+ nsrxx.getNsrsbm();
			/**
			 * 3. ϵͳ��01Ϊ��ϵͳ����ϵͳ����ʹ�����·��������Ϊ����ϵͳ����ʹ�����·��
			 */
			String task_from = "01";
			/**
			 * 4. ��ҳ���������ʱ��
			 */
			String Task_expire_date = DateUtils.newDateTime(5);
			/**
			 * 5. �˵�id,ϵͳ����Ȩ���ж���Щ������Ա��Ȩ���մ˴�������
			 */
			String menu_id = "1000028";
			/**
			 * 6. �����������ȼ�
			 */
			Tokens.PRIORITY priority = Tokens.PRIORITY.CRITICAL;
			// ���ʹ�������
			boolean isSend = sendTask(task_title, priority, task_link,
					task_from, Task_expire_date, menu_id);
			if (isSend){
				setSystemMessage("�����Ǽǲ����ɹ���");
			}else{
				setSystemMessage("�����Ǽǲ���ʧ��,�����޴������������Ա��", true, null);
				sqlsession.rollback();
			}
		} else {
			// ����ʧ�ܣ�������inputҳ��
			setSystemMessage("�����Ǽǲ���ʧ�ܣ�", true, null);
		}
		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		String nsrmc = getDj_nsrxx().getNsrmc();

		if (ValidateUtils.isNullOrEmpty(nsrmc)) {
			this.setSystemMessage("��˰�����Ʋ���Ϊ��", true, null);
		}

	}

	@Override
	protected String initial() {
		// TODO Auto-generated method stub
		return INITIAL;
	}

}
