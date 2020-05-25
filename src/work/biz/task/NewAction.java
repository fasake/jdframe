package work.biz.task;

import com.jdframe.sys.core.model.Tokens;
import com.jdframe.sys.core.util.*;

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
public class NewAction extends work.biz.task.Action {

	@Override
	protected String initial() {
		return INITIAL;
	}

	@Override
	protected String perform() {
		// TODO Auto-generated
		// Initialization Primary Key Propertity!
 

		// Send Task
		boolean isSend = sendTask(title, Tokens.PRIORITY.CRITICAL,
				link, from,DateUtils.formatDateMid(enddate), menu_id);
		if (isSend)
			setSystemMessage("Success!");
		else
			setSystemMessage("Send Failed!", true, null);

		return SUCCESS;
	}

	@Override
	protected void validators() {
		// TODO Auto-generated method stub
		if(ValidateUtils.isNullOrEmpty(this.getTitle())){
			setSystemMessage("���ⲻ��Ϊ��!", true, null);
			return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getLink()) || !this.getLink().matches("[a-zA-z]+://[^s]*")){
        	setSystemMessage("���ӵ�ַ����Ϊ�ջ��߸�ʽ����ȷ����ȷ��ʽΪ: Э��://��ַ!", true, null);
        	return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getFrom())){
        	setSystemMessage("����ϵͳ����Ϊ��!", true, null);
        	return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getEnddate())){
        	setSystemMessage("����ʱ�䲻��Ϊ��!", true, null);
        	return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getMenu_id())){
        	setSystemMessage("����Ȩ�޲���Ϊ��!", true, null);
        	return;
		}
	}

}
