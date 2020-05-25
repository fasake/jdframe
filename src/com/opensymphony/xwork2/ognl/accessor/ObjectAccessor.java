/**
 * 
 */
package com.opensymphony.xwork2.ognl.accessor;

import com.jdframe.sys.core.interceptor.ReflectHelper;
import com.jdframe.sys.core.model.T_vo;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.util.reflection.ReflectionContextState;
import ognl.ObjectPropertyAccessor;
import ognl.OgnlException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Map;

import org.apache.log4j.Logger;

public class ObjectAccessor extends ObjectPropertyAccessor {
	Logger log = Logger.getLogger(ObjectAccessor.class);
    @Override
    public Object getProperty(Map map, Object o, Object o1) throws OgnlException {
        Object obj = super.getProperty(map, o, o1);

        map.put(XWorkConverter.LAST_BEAN_CLASS_ACCESSED, o.getClass());
        map.put(XWorkConverter.LAST_BEAN_PROPERTY_ACCESSED, o1.toString());
        ReflectionContextState.updateCurrentPropertyPath(map, o1);
        return obj;
    }

    @Override
    public void setProperty(Map map, Object o, Object o1, Object o2) throws OgnlException {
    	try{
            //super.setProperty(map, o, o1, o2);
  
            if(o != null && o instanceof T_vo){
            	String classname = o.getClass().toString();
            	if(o1 != null || !"".equals(o1)){
            		String fieldname = o1.toString();
            		
            		Field fld  = ReflectHelper.getFieldByFieldName(o, fieldname);
            		
            		log.debug(classname+"."+fieldname+" type:"+fld.getType()+" isPrimitive:"+fld.getType().isPrimitive()+"  isSynthetic():"+fld.getType().isSynthetic());
            		if(fld.getType()==java.lang.String.class) {
            			//The String 
            			super.setProperty(map, o, o1, o2);
            		}else if(fld.getType()==java.math.BigDecimal.class){
            			//The BigDecimal
            			if(o2 != null &&  o2.getClass().isArray()){
            				//Not null and is String's Array
            				if(o2.getClass() == java.lang.String[].class){
            					String[] vs = (String[])o2;
            					//check o2 is emput?
            					boolean isempty = true;
            					for (int i = 0; i < vs.length; i++) {
									if(vs[i].trim().length() != 0){
										isempty = false;
									}
								}
            					if(isempty){
            						super.setProperty(map, o, o1, null);
            					}else{
            						super.setProperty(map, o, o1, o2);
            					}
            				}
            				
            			}else if(o2 != null && o2.toString().length() > 0){
            				//Not null and is String 
            				BigDecimal v = new BigDecimal(o2.toString());
            				super.setProperty(map, o, o1, v);
            			} else{
            				//The others
            				super.setProperty(map, o, o1, null);
            			}
            		}else{
            			super.setProperty(map, o, o1, o2);
            		}
            	}
            }else{
            	super.setProperty(map, o, o1, o2);
            }
    	}catch(Exception e){
    		log.error("OgnlException:"+e.getMessage());
    	}
    }
}