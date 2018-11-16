package sz.zxl.com.demo.dao;

import java.util.List;

import sz.zxl.com.demo.pojo.HatArea;

public interface HatAreaMapper {

	/**
	 * 根据father 查询区县
	 * @param father
	 * @return
	 */
	List<HatArea> findAreaByFid(String father);
	
    int deleteByPrimaryKey(Integer id);

    int insert(HatArea record);

    int insertSelective(HatArea record);

    HatArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HatArea record);

    int updateByPrimaryKey(HatArea record);
}