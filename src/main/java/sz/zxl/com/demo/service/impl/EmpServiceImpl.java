package sz.zxl.com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sz.zxl.com.demo.dao.EmpMapper;
import sz.zxl.com.demo.pojo.Emp;
import sz.zxl.com.demo.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper em;
	
	@Override
	public List<Emp> findAllEmp() {
		return em.findAllEmp();
	}

	@Override
	public List<Emp> findjob() {
		return em.findjob();
	}

	@Override
	public List<Emp> findmgr() {
		return em.findmgr();
	}

	@Override
	public int insertSelective(Emp record) {

		return em.insertSelective(record);
	}

}
