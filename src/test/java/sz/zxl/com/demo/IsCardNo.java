package sz.zxl.com.demo;

import java.util.Map;

import com.alibaba.fastjson.JSON;

public class IsCardNo {

	public static void main(String[] args) {

		String stu = "{\"data\":{\"sex\":\"男\",\"address\":\"广东省-韶关市-南雄县\",\"birthday\":\"1993-08-28\"},\"resp\":{\"code\":5,\"desc\":\"不匹配\"}}";
		Map map = JSON.parseObject(stu);  
		System.out.println(((Map)map.get("resp")).get("code"));
		
		String str = "{\"return_code\":\"00000\",\"order_id\":\"ALY1542427163524458429\"}";
		Map m = JSON.parseObject(str); 
		System.out.println("结果:"+m.get("return_code"));
	}
}
