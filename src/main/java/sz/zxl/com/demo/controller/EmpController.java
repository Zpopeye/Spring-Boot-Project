package sz.zxl.com.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sz.zxl.com.demo.pojo.Dept;
import sz.zxl.com.demo.pojo.Emp;
import sz.zxl.com.demo.service.DeptService;
import sz.zxl.com.demo.service.EmpService;

import java.util.List;

@Controller
public class EmpController {

	@Autowired
	private EmpService es;
	@Autowired
	private DeptService ds;
	
	//查询
	@GetMapping("/findemps")
	public String list(@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,Model model) {
		System.out.println("CP:===============>"+pageNum);
		PageHelper.startPage(pageNum, 3);
		List<Emp> emps = es.findAllEmp();
		PageInfo<Emp> page = new PageInfo<Emp>(emps);
		System.out.println("当前页码："+page.getPageNum());
		System.out.println("总页码："+page.getPages());
		System.out.println("总记录数："+page.getTotal());
		System.out.println("查询的数据emp:"+page.getList());
		model.addAttribute("page", page);
		return "list";
	}

	//增加功能去增加页面
	@GetMapping("/emp")
	public String goAddpage(Model model) {
		System.out.println("跳转增加页面....");
		List<Emp> jobs = es.findjob();
		List<Emp> mgrs = es.findmgr();
		for (Emp emp : mgrs) {
			System.out.println(emp.getEmpno());
		}
		List<Dept> depts = ds.finddept();
		model.addAttribute("jobs", jobs);
		model.addAttribute("mgrs", mgrs);
		model.addAttribute("depts", depts);
		return "add";
	}
	
	//接受增加员工数据
	@PostMapping("/addemp")
	public String AddEmp(Emp emp,Model model) {
		System.out.println("接受增加数据....mgr===:"+emp+"++++"+emp.getDept().getDeptno());
		int res = es.insertSelective(emp);
		if (res>0) {
			model.addAttribute("msg", "增加成功");
			return "redirect:/findemps";
		} else {
			model.addAttribute("msg", "增加失败");
			return "add";
		}
	}
	
	
}



