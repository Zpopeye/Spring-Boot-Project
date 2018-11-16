package sz.zxl.com.demo.dao;

import java.util.List;

import sz.zxl.com.demo.pojo.HatProvince;

public interface HatProvinceMapper {
	
	/**
	 * 查询全部省份
	 * @param 
	 * @return
	 */
	List<HatProvince> findAllProvince();
	
    int deleteByPrimaryKey(Integer id);

    int insert(HatProvince record);

    int insertSelective(HatProvince record);

    HatProvince selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HatProvince record);

    int updateByPrimaryKey(HatProvince record);
}