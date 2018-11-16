package sz.zxl.com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sz.zxl.com.demo.dao.DeptMapper;
import sz.zxl.com.demo.pojo.Dept;
import sz.zxl.com.demo.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper dm;
	
	@Override
	public List<Dept> finddept() {

		return dm.finddept();
	}

}
