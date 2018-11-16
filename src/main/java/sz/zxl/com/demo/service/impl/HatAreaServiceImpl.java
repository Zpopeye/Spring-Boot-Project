package sz.zxl.com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sz.zxl.com.demo.dao.HatAreaMapper;
import sz.zxl.com.demo.pojo.HatArea;
import sz.zxl.com.demo.service.HatAreaService;

@Service
public class HatAreaServiceImpl implements HatAreaService {

	@Autowired
	private HatAreaMapper ham;
	
	@Override
	public List<HatArea> findAreaByFid(String father) {
		return ham.findAreaByFid(father);
	}

}
