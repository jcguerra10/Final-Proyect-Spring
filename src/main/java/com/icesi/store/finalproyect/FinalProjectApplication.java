package com.icesi.store.finalproyect;

<<<<<<< HEAD:src/main/java/com/icesi/store/finalproyect/FinalProyectApplication.java
import com.icesi.store.finalproyect.dao.*;
import com.icesi.store.finalproyect.model.product.*;
=======
import com.icesi.store.finalproyect.model.product.UserApp;
import com.icesi.store.finalproyect.model.product.UserType;
>>>>>>> master:src/main/java/com/icesi/store/finalproyect/FinalProjectApplication.java
import com.icesi.store.finalproyect.services.implementation.UserServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {

<<<<<<< HEAD:src/main/java/com/icesi/store/finalproyect/FinalProyectApplication.java
		ConfigurableApplicationContext s = SpringApplication.run(FinalProyectApplication.class, args);
=======
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
>>>>>>> master:src/main/java/com/icesi/store/finalproyect/FinalProjectApplication.java

//		ClientRepository clientRepository = s.getBean(ClientRepository.class);
//		StoreRepository storeRepository = s.getBean(StoreRepository.class);
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

		UserServiceImp usi = s.getBean(UserServiceImp.class);

		UserApp uaAdmin = new UserApp();

		uaAdmin.setId(1);
		uaAdmin.setUsername("admin1");
		uaAdmin.setPassword("{noop}123456");
		uaAdmin.setType(UserType.administrator);

		UserApp uaOper = new UserApp();

		uaOper.setId(2);
		uaOper.setUsername("oper1");
		uaOper.setPassword("{noop}123456");
		uaOper.setType(UserType.operator);

		usi.save(uaAdmin);
		usi.save(uaOper);

		ProductDaoImp pr = s.getBean(ProductDaoImp.class);
		ProductcategoryDao pcr = s.getBean(ProductcategoryDao.class);
		ProductsubcategoryDao pscr = s.getBean(ProductsubcategoryDao.class);
		LocationDao lr = s.getBean(LocationDao.class);

		Productcategory pCategory = new Productcategory();
		pCategory.setName("Tech");

		Productsubcategory pSubCategory = new Productsubcategory();
		pSubCategory.setName("Iphone");
		pSubCategory.setProductcategory(pCategory);

		Product p = new Product();
		p.setName("iphone");
		p.setProductnumber("21");
		p.setSellstartdate(LocalDate.of(2022, 3, 14));
		p.setSellenddate(LocalDate.of(2022, 3, 15));
		p.setProductsubcategory(pSubCategory);
		p.setSize(BigDecimal.valueOf(12));
		p.setWeight(BigDecimal.valueOf(12));

		pcr.save(pCategory);
		pscr.save(pSubCategory);

		pr.save(p);

		Location l = new Location();

		l.setLocationid(1);
		l.setName("stan1");
		l.setAvailability(BigDecimal.valueOf(2));
		l.setCostrate(BigDecimal.valueOf(1));

		lr.save(l);

		ProductcosthistoryDaoImp pchr = s.getBean(ProductcosthistoryDaoImp.class);

		Productcosthistory pch = new Productcosthistory();

		pch.setProduct(p);
		pch.setStartdate(LocalDate.of(2022, 4, 13));
		pch.setEnddate(LocalDate.of(2022, 4, 14));
		pch.setStandardcost(BigDecimal.valueOf(12));

		pchr.save(pch);
	}

}
