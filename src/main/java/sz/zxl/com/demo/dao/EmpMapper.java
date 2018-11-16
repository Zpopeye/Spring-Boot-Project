package sz.zxl.com.demo.dao;


import java.util.List;

import sz.zxl.com.demo.pojo.Emp;

public interface EmpMapper {

	List<Emp> findmgr();
	
	List<Emp> findjob();
	
	List<Emp> findAllEmp();
	
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}