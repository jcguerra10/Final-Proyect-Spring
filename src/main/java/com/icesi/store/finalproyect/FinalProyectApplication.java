package com.icesi.store.finalproyect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FinalProyectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext os = SpringApplication.run(FinalProyectApplication.class, args);

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
