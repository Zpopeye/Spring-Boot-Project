package sz.zxl.com.demo.dao;

import java.util.List;

import sz.zxl.com.demo.pojo.Dept;

public interface DeptMapper {

	//查询部门
	List<Dept> finddept();
	
    int deleteByPrimaryKey(Integer deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}