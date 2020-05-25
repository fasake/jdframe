package com.jdframe.sys.core.tags;
import com.opensymphony.xwork2.util.ValueStack;   
import java.io.IOException;   
import java.io.Writer;   
import java.util.ArrayList;
import java.util.Stack;
  
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.struts2.components.Component;   

import com.jdframe.sys.core.db.CodesCache;
import com.jdframe.sys.dao.model.T_sys_code;
 

 // TODO: Auto-generated Javadoc
/**
  * 系统代码转换Tag.
  * 
  * @copyright www.jdframe.com
  * @Package com.jdframe.sys.core.tags 
  * @Description: TODO
  * @author: support@jdframe.com
  * @date: 2013-09-15 17:16:29
  * @version v1.0
  */
public class CodesComponent extends Component {  
	 
	 Logger log  = Logger.getLogger(CodesComponent.class);
	 private String CodeNo="0";  //代码编号
	 private String CodeType="0";  //代码类型  
     

	/**
	 * Instantiates a new codes component.
	 *
	 * @param arg0 the arg0
	 */
	public CodesComponent(ValueStack arg0) {   
        super(arg0);   
    }   
  
    @Override  
    public boolean start(Writer writer) {   
        boolean __result = super.start(writer);  
        try {   
            String __str = "";   
            
            String __codeno_tmp = (String)this.getStack().findValue(CodeNo);   
            if(__codeno_tmp!=null && !__codeno_tmp.equals("") ){
            	this.CodeNo = __codeno_tmp;
            }
            
            Object __obj = CodesCache.findCode(this.CodeNo, this.CodeType);
            if(__obj!=null){
            	T_sys_code code = (T_sys_code)__obj;
                __str = code.getCode_name();	
                code = null;
                __obj = null;
            }
            writer.write(__str);   
        } catch (IOException ex) {   
        	ex.printStackTrace();
            log.debug(ex.getMessage());
        }   
        return __result;   
    }

	/**
	 * Gets the code no.
	 *
	 * @return the code no
	 */
	public String getCodeNo() {
		return CodeNo;
	}

	/**
	 * Sets the code no.
	 *
	 * @param codeNo the new code no
	 */
	public void setCodeNo(String codeNo) {
		CodeNo = codeNo;
	}

	/**
	 * Gets the code type.
	 *
	 * @return the code type
	 */
	public String getCodeType() {
		return CodeType;
	}

	/**
	 * Sets the code type.
	 *
	 * @param codeType the new code type
	 */
	public void setCodeType(String codeType) {
		CodeType = codeType;
	}
 
	

	
 }  

