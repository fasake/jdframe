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
			setSystemMessage("标题不能为空!", true, null);
			return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getLink()) || !this.getLink().matches("[a-zA-z]+://[^s]*")){
        	setSystemMessage("链接地址不能为空或者格式不正确，正确格式为: 协议://地址!", true, null);
        	return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getFrom())){
        	setSystemMessage("接收系统不能为空!", true, null);
        	return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getEnddate())){
        	setSystemMessage("到期时间不能为空!", true, null);
        	return;
		}
        if(ValidateUtils.isNullOrEmpty(this.getMenu_id())){
        	setSystemMessage("接收权限不能为空!", true, null);
        	return;
		}
	}

}
