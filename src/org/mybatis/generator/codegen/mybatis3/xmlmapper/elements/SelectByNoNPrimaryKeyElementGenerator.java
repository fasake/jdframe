/*
 *  Copyright 2009 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * 
 * @author Jeff Butler
 * 
 */
public class SelectByNoNPrimaryKeyElementGenerator extends
        AbstractXmlElementGenerator {
	
	 private boolean isSimple;
    public SelectByNoNPrimaryKeyElementGenerator() {
        super();
        this.isSimple = isSimple;
    }

    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute(
                "id", introspectedTable.getSelectByNoNPrimaryKeyStatementId())); //$NON-NLS-1$
        
        if (introspectedTable.getRules().generateResultMapWithBLOBs()) {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getResultMapWithBLOBsId()));
        } else {
            answer.addAttribute(new Attribute("resultMap", //$NON-NLS-1$
                    introspectedTable.getBaseResultMapId()));
        }
        
        FullyQualifiedJavaType parameterType;
        if (isSimple) {
            parameterType = new FullyQualifiedJavaType(
                    introspectedTable.getBaseRecordType());
        } else {
            parameterType = introspectedTable.getRules()
                    .calculateAllFieldsClass();
        }

        answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
                parameterType.getFullyQualifiedName()));

//        String parameterType;
//        if (introspectedTable.getRules().generatePrimaryKeyClass()) {
//            parameterType = introspectedTable.getPrimaryKeyType();
//        } else {
//            // PK fields are in the base class. If more than on PK
//            // field, then they are coming in a map.
//            if (introspectedTable.getPrimaryKeyColumns().size() > 1) {
//                parameterType = "map"; //$NON-NLS-1$
//            } else {
//                parameterType = introspectedTable.getPrimaryKeyColumns().get(0)
//                        .getFullyQualifiedJavaType().toString();
//            }
//        }
//
//        answer.addAttribute(new Attribute("parameterType", //$NON-NLS-1$
//                parameterType));

        context.getCommentGenerator().addComment(answer);

        StringBuilder sb = new StringBuilder();
        sb.append("select "); //$NON-NLS-1$

        
        answer.addElement(new TextElement(sb.toString()));
        answer.addElement(getBaseColumnListElement());
        if (introspectedTable.hasBLOBColumns()) {
            answer.addElement(new TextElement(",")); //$NON-NLS-1$
            answer.addElement(getBlobColumnListElement());
        }

        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));
        
        boolean and = false;
        int count = 0 ;
        for (IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
        	
//        	if(introspectedTable.getPrimaryKeyColumns().contains(introspectedColumn)){
//        		continue;
//        	}
            sb.setLength(0);
            if(!and){
	            sb.append("<where> \r\n"); //$NON-NLS-1$
	            and = true;
            }
            count ++;
            String blank10 = "          ";
            String blank12 = "          ";
            boolean isDate = (introspectedColumn.getJdbcType() >=91 && introspectedColumn.getJdbcType() <=93); 
            if(isDate){
            	sb.append(blank10+"<if test=\""+introspectedColumn.getJavaProperty()+" != null \">\r\n");
            }else{
            	sb.append(blank10+"<if test=\""+introspectedColumn.getJavaProperty()+" != null  and "+introspectedColumn.getJavaProperty()+" != '' \">\r\n");
            }
            if(count>1){
            	sb.append(blank12+ " and ");
            }else{
            	sb.append(blank12);
            }
            sb.append(MyBatis3FormattingUtilities.getAliasedEscapedColumnName(introspectedColumn));
            sb.append(" = "); //$NON-NLS-1$
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn)).append("\r\n");
            sb.append(blank12+"</if>");
            answer.addElement(new TextElement(sb.toString()));
        }
        
        if(and){
        	sb.append("\r\n       </where>");
        	answer.addElement(new TextElement(sb.toString()));
        }
         
        if (context.getPlugins()
                .sqlMapSelectByPrimaryKeyElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
    }
}
