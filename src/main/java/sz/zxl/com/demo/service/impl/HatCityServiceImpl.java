package sz.zxl.com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sz.zxl.com.demo.dao.HatCityMapper;
import sz.zxl.com.demo.pojo.HatCity;
import sz.zxl.com.demo.service.HatCityService;

@Service
public class HatCityServiceImpl implements HatCityService {

	@Autowired
	private HatCityMapper hcm;
	
	@Override
	public List<HatCity> findCityByFid(String provinceid) {
		return hcm.findCityByFid(provinceid);
	}

}
