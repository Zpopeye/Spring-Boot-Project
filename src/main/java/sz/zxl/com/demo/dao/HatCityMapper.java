package sz.zxl.com.demo.dao;

import java.util.List;

import sz.zxl.com.demo.pojo.HatCity;

public interface HatCityMapper {

	/**
	 * 根据省份查询城市
	 * @param provinceid
	 * @return
	 */
	List<HatCity> findCityByFid(String provinceid);
	
    int deleteByPrimaryKey(Integer id);

    int insert(HatCity record);

    int insertSelective(HatCity record);

    HatCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HatCity record);

    int updateByPrimaryKey(HatCity record);
}