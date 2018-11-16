package sz.zxl.com.demo.service;

import java.util.List;

import sz.zxl.com.demo.pojo.HatArea;

public interface HatAreaService {

	/**
	 * 根据father 查询区县
	 * @param father
	 * @return
	 */
	List<HatArea> findAreaByFid(String father);
	
}
