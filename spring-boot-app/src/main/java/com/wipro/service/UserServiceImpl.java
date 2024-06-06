package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.UserDAO;
import com.wipro.model.User;
@Service
public class UserServiceImpl implements UserService {
@Autowired
UserDAO userDao;
	
	@Override
	public User getUserByName(String username) {
		
		return userDao.getUserByName(username);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	@Override
	public String deleteUser(String username) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(username) ;
	}


	@Override
	public User updateUserPassword(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserPassword(user) ;
	}

}
