package sz.zxl.com.demo.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import sz.zxl.com.demo.pojo.HatArea;
import sz.zxl.com.demo.pojo.HatCity;
import sz.zxl.com.demo.pojo.HatProvince;
import sz.zxl.com.demo.pojo.Users;
import sz.zxl.com.demo.service.HatAreaService;
import sz.zxl.com.demo.service.HatCityService;
import sz.zxl.com.demo.service.HatProvinceService;
import sz.zxl.com.demo.service.UserService;
import sz.zxl.com.demo.utils.GraphicHelper;
import sz.zxl.com.demo.utils.HttpUtils;

/**
 * StringUtils 注意导包 org.springframework.util.StringUtils;
 * @author carmelo
 * @version 创建时间：2018年11月8日下午10:48:29
 */
@Controller
public class LoginController {

	@Autowired
	private UserService us;
	@Autowired
	private HatProvinceService hps;
	@Autowired
	private HatCityService hcs;
	@Autowired
	private HatAreaService has;
	
	//明明是修改:
	@RequestMapping("/addUser")
	public String addUsers(Users user,String p,String c,String a,String d) {
		System.out.println("进来增加页面:User:"+user+"--省份:"+p+"--城市:"+c+"--区县a:"+a+"--街道:"+d);
		user.setUseraddress(p+c+a+d);
		us.updateByPrimaryKeySelective(user);
		return "dashboard";
	}
	/**
	 * 登入
	 * @param user
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Users user,Model model,HttpSession session) {
		System.out.println("登入好不好...");
		System.out.println("昵称:"+user.getNickname());
		user = us.findUser(user);
		if (user!=null) {
			session.setAttribute("user", user);
			return "redirect:/main.html";
		} else {
			model.addAttribute("msg", "用户名或密码错误");
			return "login";
		}
	}
	
	//显示验证码，把验证码放入session中
	@RequestMapping("/code.action")
	public void showCode(HttpSession session,HttpServletResponse response) throws IOException {
		String code = GraphicHelper.createCode();
		response.setContentType("image/jpg");
		final int width = 150; // 图片宽度
		final int height = 30; // 图片高度
		final String imgType = "jpg"; // 指定图片格式 (不是指MIME类型)
		final OutputStream output = response.getOutputStream(); // 获得可以向客户端返回图片的输出流
		// (字节流)
		// 创建验证码图片并返回图片上的字符串
		BufferedImage image = GraphicHelper.create(width, height, imgType,code);
		ImageIO.write(image, imgType, output);
		System.out.println("这是啥:==>验证码:"+code);
		session.setAttribute("code", code);
	}
	
	//校验验证码
	@RequestMapping("/isCode")
	@ResponseBody
	public String isCode(String code,HttpSession session) {
		System.out.println("页面传入的code:"+code);
		String sessioncode = (String) session.getAttribute("code");
		System.out.println("sessioncode:"+sessioncode);
		if (code.equals(sessioncode)||code==sessioncode) {
			return "true";
		} else {
			return "false";
		}
	}
	//跳转用户认证
	@RequestMapping("/userau")
	public String  goUserAuthentification(Model model) {
		System.out.println("跳转用户认证页面.....");
		//查询省份
		List<HatProvince> hatProvince = hps.findAllProvince();
		model.addAttribute("hatProvince", hatProvince);
		return "user_au";
	}
	
	//返回查詢到的城市
	@RequestMapping("/showcity")
	@ResponseBody
	public List<HatCity> showCity(String provinceid) {
		System.out.println("获取省份ID...provinceid:"+provinceid);
		//根据省份查询城市
		List<HatCity> hatCity = hcs.findCityByFid(provinceid);
		for (HatCity ha : hatCity) {
			System.out.println("chengshi:"+ha.getCity());
		}
		return hatCity;
	}
	
	//放回查詢到的区县
	@RequestMapping("/showarea")
	@ResponseBody
	public List<HatArea> showArea(String cityid) {
		System.out.println("获取城市ID...cityid:"+cityid);
		//根据省份查询城市
		List<HatArea> hatArea = has.findAreaByFid(cityid);
		for (HatArea ha : hatArea) {
			System.out.println("区县===>>:"+ha.getArea());
		}
		return hatArea;
	}
	
	//实名认证身份证
	@RequestMapping("/isCardNo")
	@ResponseBody
	public Integer isCardNo(String username,String card) {
		System.out.println("验证身份证...");
		String stu = HttpUtils.IsCardNo(username, card);
		System.out.println("Stu接受的数据:"+stu);
		Map map = JSON.parseObject(stu);
		System.out.println("转换成map集合:"+map);
		Integer num = (Integer) ((Map)map.get("resp")).get("code");
		System.out.println("查询结果"+num);
		return num;
	}
	
	//手机短信验证
	@RequestMapping("/checkphone")
	@ResponseBody
	public String checkPhone(String phoneNum,HttpSession session) {
		System.out.println("页面传送的手机号码:"+phoneNum);
		String str = HttpUtils.checkMessage(phoneNum);
		/*Map map = JSON.parseObject(stu);
		System.out.println("转换成map集合:"+map);
		String num = (String) map.get("return_code");*/
		session.setAttribute("str", str);
		System.out.println("随机数:"+str);
		return str;
	}
	//验证手机验证码
	@RequestMapping("/isphonecode")
	@ResponseBody
	public String isPhoneCode(String code,HttpSession session) {
		System.out.println("页面输入的手机验证码:"+code);
		String str = (String) session.getAttribute("str");
		if (str.equals(code)||str==code) {
			return "true";
		} else {
			return "false";
		}
	}
	
	
	
	
	/*@PostMapping(value="/login")
	public String login(@RequestParam("username") String username,
			@RequestParam String password,Map<String,Object> map,HttpSession session) {
		System.out.println("进来登入页:账号=="+username+">>密码=="+password);
		if (!StringUtils.isEmpty(username)&&"123".equals(password)) {
			//登入成功;防止表单重复提交,可以重定向到主页面
			//session保存用户;登入需要拦截
			session.setAttribute("user", username);
			return "redirect:/main.html";
		} else {
			map.put("msg", "用户名或密码错误");
			return "login";
		}
		
	}*/
	
}
