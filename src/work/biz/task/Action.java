package work.biz.task;

import com.jdframe.sys.core.action.JdframeAction;
 
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
	public String title; //����
	public String priority; //���ȼ�
	public String link; //���ӵ�ַ
	public String from; //����ϵͳ
	public java.util.Date enddate; //����ʱ��
	public String menu_id; //�˵�Ȩ��Id,�ж�ϵͳ����Ȩ��
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public java.util.Date getEnddate() {
		return enddate;
	}
	public void setEnddate(java.util.Date enddate) {
		this.enddate = enddate;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	 
	
}
