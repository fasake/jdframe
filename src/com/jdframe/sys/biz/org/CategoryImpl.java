package com.jdframe.sys.biz.org;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.jdframe.sys.core.model.tree.Category;
import com.jdframe.sys.core.util.DbUtils;
import com.jdframe.sys.dao.model.T_sys_organization;

public class CategoryImpl extends Category {
	Logger log = Logger.getLogger(CategoryImpl.class);
	
	public CategoryImpl(){
		
	}
	public CategoryImpl(String id, String name, CategoryImpl... children) {
		//super(id, name, children);
		this.id = id;
		this.name = name;
		this.children = new ArrayList<CategoryImpl>();
		for (CategoryImpl child : children) {
			this.children.add(child);
		}
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public  CategoryImpl getById(String sj_dm){
		
		SqlSession session = DbUtils.buildSqlSession();
		CategoryImpl root_cat  = null;
		try{
			 
			List<T_sys_organization> all = session.selectList("getSubOrgByDm",sj_dm);
			 
			List allCategory = new ArrayList();
			for (int j = 0; j < all.size(); j++) {
			 
				CategoryImpl  self_category  = null;
				String self_code = all.get(j).getZzjg_dm();
				String self_name = all.get(j).getZzjg_name();	 
				 
				
					List<T_sys_organization> l = session.selectList("getSubOrgByDm",self_code);
					List subCategory = new ArrayList();
					for (int i = 0; i < l.size(); i++) {
						String _code = l.get(i).getZzjg_dm();
						String _name = l.get(i).getZzjg_name();
						subCategory.add(new CategoryImpl(_code,_name));
					}
					if(subCategory.size()>0){
						CategoryImpl[] childr = new CategoryImpl[subCategory.size()];
						for (int i = 0; i < subCategory.size(); i++) {
							if(subCategory.get(i) instanceof CategoryImpl){
								childr[i] = (CategoryImpl)subCategory.get(i);
							}
						}
						self_category  = new CategoryImpl(self_code,self_name,childr);
					}else{
						self_category  = new CategoryImpl(self_code,self_name);
					}
					allCategory.add(self_category);
					
			 }
			CategoryImpl[] allchildr = new CategoryImpl[allCategory.size()];
			if(allCategory.size()>0){
				
				for (int i = 0; i < allCategory.size(); i++) {
					if(allCategory.get(i) instanceof CategoryImpl){
						allchildr[i] = (CategoryImpl)allCategory.get(i);
					}
				}
				root_cat  = new CategoryImpl("-1","Root",allchildr);
			}else{
				root_cat  = new CategoryImpl("-1","Root");
			}
			
			
			//if(sj_dm.equals("76300000000")){
			//	root_cat = self_category;
			//}
		}finally{
			if(session!=null)session.close();
		}
		return root_cat;
		 
	}
	
	@Override
	public CategoryImpl getRootById(String id) {
		// TODO Auto-generated method stub
		SqlSession session = DbUtils.buildSqlSession();
		CategoryImpl root_cat  = null;
		try{
			 
			List<T_sys_organization> all = session.selectList("getOrgBySwjgDm",id);
			 
			List allCategory = new ArrayList();
			for (int j = 0; j < all.size(); j++) {
			 
				CategoryImpl  self_category  = null;
				String self_code = all.get(j).getZzjg_dm();
				String self_name = all.get(j).getZzjg_name();	 
				 
				
					List<T_sys_organization> l = session.selectList("getSubOrgByDm",self_code);
					List subCategory = new ArrayList();
					for (int i = 0; i < l.size(); i++) {
						String _code = l.get(i).getZzjg_dm();
						String _name = l.get(i).getZzjg_name();
						subCategory.add(new CategoryImpl(_code,_name));
					}
					if(subCategory.size()>0){
						CategoryImpl[] childr = new CategoryImpl[subCategory.size()];
						for (int i = 0; i < subCategory.size(); i++) {
							if(subCategory.get(i) instanceof CategoryImpl){
								childr[i] = (CategoryImpl)subCategory.get(i);
							}
						}
						self_category  = new CategoryImpl(self_code,self_name,childr);
					}else{
						self_category  = new CategoryImpl(self_code,self_name);
					}
					allCategory.add(self_category);
					
			 }
			CategoryImpl[] allchildr = new CategoryImpl[allCategory.size()];
			if(allCategory.size()>0){
				
				for (int i = 0; i < allCategory.size(); i++) {
					if(allCategory.get(i) instanceof CategoryImpl){
						allchildr[i] = (CategoryImpl)allCategory.get(i);
					}
				}
				root_cat  = new CategoryImpl("-1","Root",allchildr);
			}else{
				root_cat  = new CategoryImpl("-1","Root");
			}

		}finally{
			if(session!=null)session.close();
		}
		return root_cat;
	}
 
 
}
