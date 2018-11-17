package sz.zxl.com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sz.zxl.com.demo.dao.UsersMapper;
import sz.zxl.com.demo.pojo.Users;
import sz.zxl.com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersMapper um;
	
	@Override
	public Users findUser(Users user) {
		return um.findUser(user);
	}

	@Override
	public int deleteByPrimaryKey(Integer userid) {
		return 0;
	}

	@Override
	public int insert(Users record) {
		return 0;
	}

	/**
	 * 动态增加
	 */
	@Override
	public int insertSelective(Users record) {
		return um.insertSelective(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer userid) {
		return null;
	}
	
	/**
	 * 动态修改
	 */
	@Override
	public int updateByPrimaryKeySelective(Users record) {
		return um.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Users record) {
		return 0;
	}

}
