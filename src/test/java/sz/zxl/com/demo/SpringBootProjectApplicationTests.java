package sz.zxl.com.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sz.zxl.com.demo.pojo.Emp;
import sz.zxl.com.demo.service.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootProjectApplicationTests {

	@Autowired
	private EmpService es;
	
	@Test
	public void contextLoads() {
		List<Emp> le = es.findAllEmp();
		for (Emp emp : le) {
			System.out.println("员工姓名:"+emp.getEname()+"员工部门:"+
		emp.getDept().getDname()+"工资等级:"+emp.getSalgrade().getGrade());
		}
	}

}
