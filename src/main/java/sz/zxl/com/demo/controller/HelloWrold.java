package sz.zxl.com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ===>接下来就是登入页面
 *
 * @author carmelo
 * @version 创建时间：2018年11月8日下午8:17:53
 */
@Controller
public class HelloWrold {

    //设置默认访问页面
    @RequestMapping({"/", "index.html"})
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

    private final static Logger logger = LoggerFactory.getLogger(HelloWrold.class);


    public static void main(String[] args) {
        logger.info("logback 成功了");
        logger.error("logback 成功了");
        logger.debug("logback 成功了");


        Map map = new HashMap();
        map.put("key1", "lisi1");
        map.put("key2", "lisi2");
        map.put("key3", "lisi3");
        map.put("key4", "lisi4");
        //先获取map集合的所有键的set集合，keyset（）
        Iterator it = map.keySet().iterator();
        //获取迭代器
        while (it.hasNext()) {
            Object key = it.next();
            System.out.println(map.get(key));
        }
        //entry
		System.out.println("=================================>>");
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            System.out.println("键值: " + next.getKey() + "  Value值: " + next.getValue());
        }
    }

}

