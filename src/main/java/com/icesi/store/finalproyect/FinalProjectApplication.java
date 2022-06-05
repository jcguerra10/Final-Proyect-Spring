package com.icesi.store.finalproyect;

import com.icesi.store.finalproyect.model.product.UserApp;
import com.icesi.store.finalproyect.model.product.UserType;
import com.icesi.store.finalproyect.services.implementation.UserServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext os = SpringApplication.run(FinalProjectApplication.class, args);

//		UserServiceImp usi = os.getBean(UserServiceImp.class);
//
//		UserApp uaAdmin = new UserApp();
//
//		uaAdmin.setId(1);
//		uaAdmin.setUsername("admin1");
//		uaAdmin.setPassword("{noop}123456");
//		uaAdmin.setType(UserType.administrator);
//
//		UserApp uaOper = new UserApp();
//
//		uaOper.setId(2);
//		uaOper.setUsername("oper1");
//		uaOper.setPassword("{noop}123456");
//		uaOper.setType(UserType.operator);
//
//		usi.save(uaAdmin);
//		usi.save(uaOper);

//		ClientRepository clientRepository = os.getBean(ClientRepository.class);
//		StoreRepository storeRepository = os.getBean(StoreRepository.class);
//
//		Store st1 = new Store();
//		Store st2 = new Store();
//
//		Client cl1 = new Client();
//		Client cl2 = new Client();
//
//		st1.setName("Apple");
//		st2.setName("Samsung");
//
//		storeRepository.save(st1);
//		storeRepository.save(st2);
//
//		cl1.setName("Juan");
//		cl1.setStore(st1);
//
//		cl2.setName("Christian");
//		cl2.setStore(st2);
//
//		clientRepository.save(cl1);
//		clientRepository.save(cl2);
	}

}
