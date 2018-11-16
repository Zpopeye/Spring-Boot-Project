package sz.zxl.com.demo.dao;

import sz.zxl.com.demo.pojo.Users;

public interface UsersMapper {

	/**
	 * 登入
	 * @param user
	 * @return
	 */
	Users findUser(Users user);
	
    int deleteByPrimaryKey(Integer userid);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}