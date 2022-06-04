package com.icesi.store.finalproyect.services.implementation;

import java.util.Optional;

import com.icesi.store.finalproyect.model.product.UserApp;
import com.icesi.store.finalproyect.repositories.UserRepository;
import com.icesi.store.finalproyect.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(UserApp user) {
		userRepository.save(user);
	}

	@Override
	public Optional<UserApp> findById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public Iterable<UserApp> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(UserApp user) {
		userRepository.delete(user);
	}

}
