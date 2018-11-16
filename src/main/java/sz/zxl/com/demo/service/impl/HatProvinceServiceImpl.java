package sz.zxl.com.demo.service.impl;

import java.util.List;

import org.apache.coyote.http2.HpackDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sz.zxl.com.demo.dao.HatProvinceMapper;
import sz.zxl.com.demo.pojo.HatProvince;
import sz.zxl.com.demo.service.HatProvinceService;

@Service
public class HatProvinceServiceImpl implements HatProvinceService {

	@Autowired
	private HatProvinceMapper hp;
	
	@Override
	public List<HatProvince> findAllProvince() {
		return hp.findAllProvince();
	}

}
