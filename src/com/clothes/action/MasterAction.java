package com.clothes.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.clothes.dao.MasterDao;
import com.clothes.model.Master;
import com.opensymphony.xwork2.ActionSupport;
@Controller @Scope("prototype")
public class MasterAction extends ActionSupport implements SessionAware{
	@Resource MasterDao masterDao;
	private Master master;
	private String errMessage;
	private Map<String,Object> session;
	private String prePage;
	
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getPrePage() {
		return prePage;
	}
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	
	public String reg() throws Exception{
		masterDao.AddMaster(master);
		session.put("master", master);
		return "show_view";

	}
	
public String login() {
		
		ArrayList<Master> listmaster = masterDao.queryMasterInfo(master.getName());
		if(listmaster.size()==0) { 
			
			this.errMessage = "账号不存在！";
			System.out.print(this.errMessage);
			return "input";
			
		} 
		else{
			Master db_master = listmaster.get(0);
			if(!db_master.getPassword().equals(master.getPassword())){ 
		
			this.errMessage = "密码不正确！";
			System.out.print(this.errMessage);
			return "input";
		    }
		else{
		    	session.put("master", db_master);
				prePage = (String) session.get("prePage");
				System.out.println("将要跳到"+ prePage);
				session.remove("prePage");  
				return "success";
		    }
		}
	}
}
