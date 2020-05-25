/*
 *  Copyright 2006 The Apache Software Foundation
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

package org.mybatis.generator.internal;

import org.mybatis.generator.api.DAOMethodNameCalculator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.internal.rules.Rules;

/**
 * @author Jeff Butler
 * 
 */
public class DefaultDAOMethodNameCalculator implements DAOMethodNameCalculator {

    /**
     * 
     */
    public DefaultDAOMethodNameCalculator() {
        super();
    }

    public String getInsertMethodName(IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"insert"; //$NON-NLS-1$
    }

    /**
     * 1. if this will be the only updateByPrimaryKey, then the result should be
     * updateByPrimaryKey. 2. If the other method is enabled, but there are
     * seperate base and blob classes, then the method name should be
     * updateByPrimaryKey 3. Else the method name should be
     * updateByPrimaryKeyWithoutBLOBs
     */
    public String getUpdateByPrimaryKeyWithoutBLOBsMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        Rules rules = introspectedTable.getRules();

        if (!rules.generateUpdateByPrimaryKeyWithBLOBs()) {
            return table_name+"updateByPrimaryKey"; //$NON-NLS-1$
        } else if (rules.generateRecordWithBLOBsClass()) {
            return table_name+"updateByPrimaryKey"; //$NON-NLS-1$
        } else {
            return table_name+"updateByPrimaryKeyWithoutBLOBs"; //$NON-NLS-1$
        }
    }

    /**
     * 1. if this will be the only updateByPrimaryKey, then the result should be
     * updateByPrimaryKey. 2. If the other method is enabled, but there are
     * seperate base and blob classes, then the method name should be
     * updateByPrimaryKey 3. Else the method name should be
     * updateByPrimaryKeyWithBLOBs
     */
    public String getUpdateByPrimaryKeyWithBLOBsMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        Rules rules = introspectedTable.getRules();

        if (!rules.generateUpdateByPrimaryKeyWithoutBLOBs()) {
            return table_name+"updateByPrimaryKey"; //$NON-NLS-1$
        } else if (rules.generateRecordWithBLOBsClass()) {
            return table_name+"updateByPrimaryKey"; //$NON-NLS-1$
        } else {
            return table_name+"updateByPrimaryKeyWithBLOBs"; //$NON-NLS-1$
        }
    }

    public String getDeleteByExampleMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"deleteByExample"; //$NON-NLS-1$
    }

    public String getDeleteByPrimaryKeyMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"deleteByPrimaryKey"; //$NON-NLS-1$
    }

    /**
     * 1. if this will be the only selectByExample, then the result should be
     * selectByExample. 2. Else the method name should be
     * selectByExampleWithoutBLOBs
     */
    public String getSelectByExampleWithoutBLOBsMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        Rules rules = introspectedTable.getRules();

        if (!rules.generateSelectByExampleWithBLOBs()) {
            return table_name+"selectByExample"; //$NON-NLS-1$
        } else {
            return table_name+"selectByExampleWithoutBLOBs"; //$NON-NLS-1$
        }
    }

    /**
     * 1. if this will be the only selectByExample, then the result should be
     * selectByExample. 2. Else the method name should be
     * selectByExampleWithBLOBs
     */
    public String getSelectByExampleWithBLOBsMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        Rules rules = introspectedTable.getRules();

        if (!rules.generateSelectByExampleWithoutBLOBs()) {
            return table_name+"selectByExample"; //$NON-NLS-1$
        } else {
            return table_name+"selectByExampleWithBLOBs"; //$NON-NLS-1$
        }
    }

    public String getSelectByPrimaryKeyMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"selectByPrimaryKey"; //$NON-NLS-1$
    }

    @Override
	public String getSelectByNoNPrimaryKeyMethodName(
			IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"selectByNoNPrimaryKey_listPage"; //$NON-NLS-1$
	}
    
    public String getUpdateByPrimaryKeySelectiveMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"updateByPrimaryKeySelective"; //$NON-NLS-1$
    }

    public String getCountByExampleMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"countByExample"; //$NON-NLS-1$
    }

    public String getUpdateByExampleSelectiveMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"updateByExampleSelective"; //$NON-NLS-1$
    }

    public String getUpdateByExampleWithBLOBsMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        Rules rules = introspectedTable.getRules();

        if (!rules.generateUpdateByExampleWithoutBLOBs()) {
            return table_name+"updateByExample"; //$NON-NLS-1$
        } else if (rules.generateRecordWithBLOBsClass()) {
            return table_name+"updateByExample"; //$NON-NLS-1$
        } else {
            return table_name+"updateByExampleWithBLOBs"; //$NON-NLS-1$
        }
    }

    public String getUpdateByExampleWithoutBLOBsMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        Rules rules = introspectedTable.getRules();

        if (!rules.generateUpdateByExampleWithBLOBs()) {
            return table_name+"updateByExample"; //$NON-NLS-1$
        } else if (rules.generateRecordWithBLOBsClass()) {
            return table_name+"updateByExample"; //$NON-NLS-1$
        } else {
            return table_name+"updateByExampleWithoutBLOBs"; //$NON-NLS-1$
        }
    }

    public String getInsertSelectiveMethodName(
            IntrospectedTable introspectedTable) {
    	String table_name = introspectedTable.getTableConfiguration().getTableName().concat("#");
        return table_name+"insertSelective"; //$NON-NLS-1$
    }

	
}
