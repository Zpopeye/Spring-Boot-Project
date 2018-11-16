package sz.zxl.com.demo;


import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Test {

	public static void main(String[] args) {
		 try {
			List<String> warnings = new ArrayList<String>();
			 //是否覆盖现有文件
			 boolean overwrite = true;
			 //指定 逆向工程配置文件
			 //以流的形式读取配置文件
			 InputStream is = Test.class.getResourceAsStream("/MyBatisConfig.xml");
			 //创建配置文件解析器
			 ConfigurationParser cp = new ConfigurationParser(warnings);
			 //解析配置文件，得到所有配置信息
			 Configuration config = cp.parseConfiguration(is);
			 //生成了代码之后的回调
			 DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			 //配置代码生成对象
			 MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			 //执行代码生成操作
			 myBatisGenerator.generate(null);
			 
			 
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
