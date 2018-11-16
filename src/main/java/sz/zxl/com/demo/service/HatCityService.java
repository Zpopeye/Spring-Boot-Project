package sz.zxl.com.demo.service;

import java.util.List;

import sz.zxl.com.demo.pojo.HatCity;

public interface HatCityService {

	List<HatCity> findCityByFid(String provinceid);
	
}
