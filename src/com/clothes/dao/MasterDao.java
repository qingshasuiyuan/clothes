package com.clothes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clothes.model.Master;

@Service @Transactional
public class MasterDao {
	@Resource SessionFactory factory;
	/*添加店主信息*/
	public void AddMaster(Master master) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(master);
    }
	//删除店主信息
	public void DeleteMaster (Integer masterId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object master = s.load(Master.class, masterId);
        s.delete(master);
    }
	//更新店主信息
	public void UpdateMaster(Master master) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(master);
    }
	//查询所有店主信息
	
	public ArrayList<Master> queryAllMaster() {
        Session s = factory.getCurrentSession();
        String hql = "From Master";
        Query q = s.createQuery(hql);
        List<Master> masterList = q.list();
        return (ArrayList<Master>) masterList;
    }
	//根据主键获取对象
	public Master GetMasterById(Integer masterid) {
        Session s = factory.getCurrentSession();
        Master master = (Master)s.get(Master.class, masterid);
        return master;
    }
	/*根据查询条件查询*/
	 
	public ArrayList<Master> queryMasterInfo(String name) {
	    	
		    Session s = factory.getCurrentSession();
	    	
	    	String hql = "From Master master where 1=1";
	    	List masterList;
	    	 if(!name.equals("")){
	    		 hql = hql + " and master.name like '%" + name + "%'";
			    	Query q = s.createQuery(hql);
			    	masterList = q.list();
		    	
	    	}else{
	    		
	    		masterList =null;
	    	
	    	}
	    	return (ArrayList<Master>) masterList;
	    }
	
}
