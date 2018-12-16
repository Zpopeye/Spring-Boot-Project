package sz.zxl.com.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * ===>接下来就是登入页面
 * @author carmelo
 * @version 创建时间：2018年11月8日下午8:17:53
 */
@Controller
public class HelloWrold {

	//设置默认访问页面
	@RequestMapping({"/","index.html"})
	public String index() {
		return "index";
	}
	/*@ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
	
	//模板引擎跳转页面
	@RequestMapping("/login")
	public String login(Map<String,Object> map){
		map.put("name","张三" );
		map.put("age","<h1>20</h1>" );
		map.put("users",Arrays.asList("zhangsan","lisi","wangwu"));
        return "loginss";
    }*/
}

