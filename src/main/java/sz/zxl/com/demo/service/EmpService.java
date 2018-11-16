package sz.zxl.com.demo.service;

import java.util.List;

import sz.zxl.com.demo.pojo.Emp;

public interface EmpService {
	
	List<Emp> findAllEmp();
	
	List<Emp> findjob();
	
	List<Emp> findmgr();
	
	int insertSelective(Emp record);
}
