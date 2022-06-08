package com.icesi.store.finalproyect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.icesi.store.finalproyect.businessdelegate.BusinessDelegate;
import com.icesi.store.finalproyect.businessdelegate.BusinessDelegateImpl;
import com.icesi.store.finalproyect.model.product.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@ContextConfiguration(classes= FinalProjectApplication.class)
public class BusinessDelegateTest {

    private final String baseurl = "http://localhost:8081/api";

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    BusinessDelegateImpl delegate;
    Product pro;
    Location loc;
    Productcategory pc;
    Productsubcategory psc;
    Productcosthistory pch;
    Productinventory pi;



    @BeforeAll
    static void init() {
        System.out.println("--------------- BUSINESS DELEGATE TESTING -----------------");
        System.out.println(" ");
    }

    @Nested
    @DisplayName("Test methods for product")
    class ProductTests{
        @BeforeEach
        void setUp() {
            Productcategory pCategory = new Productcategory();
		    pCategory.setName("Tech");

		    Productsubcategory pSubCategory = new Productsubcategory();
	    	pSubCategory.setName("Iphone");
    		pSubCategory.setProductcategory(pCategory);

            pro = new Product();
		    pro.setName("iphone");
		    pro.setProductnumber("21");
		    pro.setSellstartdate(LocalDate.of(2022, 3, 14));
		    pro.setSellenddate(LocalDate.of(2022, 3, 15));
		    pro.setProductsubcategory(pSubCategory);
		    pro.setSize(BigDecimal.valueOf(12));
		    pro.setWeight(BigDecimal.valueOf(12));


            delegate= new BusinessDelegateImpl();
            delegate.setRestTemplate(restTemplate);

        }

        @Test
        void findAllProductTest() {
            Product[] productList= new Product[4];
            for (int i = 0; i < productList.length; i++) {
                Product pro= new Product();
                productList[i]= pro;
                delegate.addProduct(pro);
            }

            when(restTemplate.getForObject(baseurl+"/productsRest/list",Product[].class)).thenReturn(productList);

            assertEquals(delegate.showProductList().size(),4);
        }

        @Test
        void addProductTest() {
            Productcategory pCategory = new Productcategory();
            pCategory.setName("Tech");

            Productsubcategory pSubCategory = new Productsubcategory();
            pSubCategory.setName("Samsung");
            pSubCategory.setProductcategory(pCategory);

            Product p = new Product();
            p.setName("S20");
            p.setProductnumber("14");
            p.setSellstartdate(LocalDate.of(2022, 3, 14));
            p.setSellenddate(LocalDate.of(2022, 3, 15));
            p.setProductsubcategory(pSubCategory);
            p.setSize(BigDecimal.valueOf(12));
            p.setWeight(BigDecimal.valueOf(12));
            delegate.addProduct(p);
            when(restTemplate.postForObject(baseurl + "/productsRest/addproduct/", p, Product.class)).thenReturn(p);
            assertEquals(delegate.getProduct(p.getProductid()), p.getProductid());
        }

        @Test
        void findByIdProductTest() {
            when(restTemplate.getForObject(baseurl + "/productsRest/view/"+pro.getProductid(), Product.class)).thenReturn(pro);
            assertEquals(delegate.getProduct(pro.getProductid()).getProductid(), pro.getProductid());
        }
/*
		@Test
		void updateProductTest(){
			delegate.addProduct(pro);
			pro.setName("Xiaomi");
			delegate.editProduct(pro,pro.getProductid());

			verify(restTemplate).put(baseurl + "/productsRest/addproduct/"+pro.getProductid(), pro, Product.class);
		}

		@Test
		void deleteProductTest() {
            Productcategory pCategory = new Productcategory();
            pCategory.setName("Tech");

            Productsubcategory pSubCategory = new Productsubcategory();
            pSubCategory.setName("OPPO");
            pSubCategory.setProductcategory(pCategory);

            Product p = new Product();
            p.setName("A55");
            p.setProductnumber("11");
            p.setSellstartdate(LocalDate.of(2022, 3, 14));
            p.setSellenddate(LocalDate.of(2022, 3, 15));
            p.setProductsubcategory(pSubCategory);
            p.setSize(BigDecimal.valueOf(12));
            p.setWeight(BigDecimal.valueOf(12));
			delegate.addProduct(p);

			delegate.deleteProduct(p);
			verify(restTemplate).put(baseurl + "/productsRest/delete/" +p.getProductid(), p, Product.class);
		}*/
    }

    @Nested
    @DisplayName("Test methods for location ")
    class LocationTest{
        @BeforeEach
        void setUp() {
            loc = new Location();
            loc.setLocationid(1);
            loc.setName("stan1");
            loc.setAvailability(BigDecimal.valueOf(2));
            loc.setCostrate(BigDecimal.valueOf(1));

            delegate= new BusinessDelegateImpl();
            delegate.setRestTemplate(restTemplate);
        }

        @Test
        void findAllLocationTest(){
            Location[] locationList= new Location[2];
            for (int i = 0; i < locationList.length; i++) {
                Location loc2= new Location();
                locationList[i]= loc2;
                delegate.addLocation(loc2);
            }
            when(restTemplate.getForObject(baseurl + "/locationsRest/list",Location[].class)).thenReturn(locationList);
            assertEquals(delegate.showLocations().size(),2);
        }

        @Test
        void addLocationTest(){
            Location l = new Location();
            l.setName("stan1");
            l.setAvailability(BigDecimal.valueOf(2));
            l.setCostrate(BigDecimal.valueOf(1));
            delegate.addLocation(l);
            when(restTemplate.postForObject(baseurl + "/locationsRest/addlocation/", l, Location.class)).thenReturn(l);
            assertEquals(delegate.getLocation(l.getLocationid()), l.getLocationid());
        }

        @Test
        void findByIdLocationTest(){
            when(restTemplate.getForObject(baseurl + "/locationsRest/view/" +loc.getLocationid(), Location.class)).thenReturn(loc);
            assertEquals(delegate.getLocation(loc.getLocationid()).getLocationid(), loc.getLocationid());
        }
    }

    @Nested
    @DisplayName("Test methods for Productcategory")
    class ProductcategoryTest{
        @BeforeEach
        void setUp() {
            pc= new Productcategory();
            pc.setName("Tech");

            delegate= new BusinessDelegateImpl();
            delegate.setRestTemplate(restTemplate);
        }

        @Test
        void findAllProductcategoryTest() {
            Productcategory[] pcList= new Productcategory[3];
            for (int i = 0; i < pcList.length; i++) {
                Productcategory personquota= new Productcategory();
                pcList[i]= personquota;
                delegate.addProductcategory(personquota);
            }
            when(restTemplate.getForObject(baseurl + "/productcategoryRest/list",Productcategory[].class)).thenReturn(pcList);
            assertEquals(delegate.showProductcategoryList().size(),3);
        }



    }
    @Nested
    @DisplayName("Test methods for Productsubcategory")
    class ProductsubcategoryTest{
        @BeforeEach
        void setUp() {
            Productcategory pCategory = new Productcategory();
            pCategory.setName("Tech");

            psc = new Productsubcategory();
            psc.setName("Huawei");
            psc.setProductcategory(pCategory);

            delegate= new BusinessDelegateImpl();
            delegate.setRestTemplate(restTemplate);
        }

        @Test
        void findAllProductsubcategoryTest() {
            Productsubcategory[] pscList= new Productsubcategory[3];
            for (int i = 0; i < pscList.length; i++) {
                Productsubcategory personquota= new Productsubcategory();
                pscList[i]= personquota;
                delegate.addProductsubcategory(personquota);
            }
            when(restTemplate.getForObject(baseurl + "/productsubcategoryRest/list",Productsubcategory[].class)).thenReturn(pscList);
            assertEquals(delegate.showProductsubcategoryList().size(),3);
        }



    }
    @Nested
    @DisplayName("Test methods for productCostHistory")
    class ProductcosthistoryTest{
        @BeforeEach
        void setUp() {

            pch = new Productcosthistory();
            pch.setProduct(pro);
            pch.setStartdate(LocalDate.of(2022, 4, 13));
            pch.setEnddate(LocalDate.of(2022, 4, 14));
            pch.setStandardcost(BigDecimal.valueOf(12));

            delegate= new BusinessDelegateImpl();
            delegate.setRestTemplate(restTemplate);
        }

        @Test
        void findAllProductCostHistoryTest() {
            Productcosthistory[] costhistoryList= new Productcosthistory[3];
            for (int i = 0; i < costhistoryList.length; i++) {
                Productcosthistory territoryhistory= new Productcosthistory();
                costhistoryList[i]= territoryhistory;
                delegate.addProductHistoriccost(territoryhistory);
            }
            when(restTemplate.getForObject(baseurl + "/historiccostsRest/list",Productcosthistory[].class)).thenReturn(costhistoryList);
            assertEquals(delegate.showProductHistoriccostList().size(),3);
        }

        @Test
        void addProductCostHistoryTest() {
            Productcosthistory th= new Productcosthistory();
            th.setProduct(pro);
            th.setStartdate(LocalDate.of(2022, 8, 13));
            th.setEnddate(LocalDate.of(2022, 8, 18));
            th.setStandardcost(BigDecimal.valueOf(2));
            delegate.addProductHistoriccost(th);
            when(restTemplate.postForObject(baseurl + "/historiccostsRest/addproductcost/", th, Productcosthistory.class)).thenReturn(th);
            assertEquals(delegate.getProductHistoriccost(th.getId()), th.getId());
        }

        @Test
        void findByIdProductCostHistoryTest() {
            when(restTemplate.getForObject(baseurl + "/historiccostsRest/view/"+pch.getId(), Productcosthistory.class)).thenReturn(pch);
            assertEquals(delegate.getProductHistoriccost(pch.getId()).getId(), pch.getId());
        }
    }

    @Nested
    @DisplayName("Test methods for productinventory")
    class ProductinventoryTest{
        @BeforeEach
        void setUp(){
            pi= new Productinventory();
            pi.setLocation(loc);
            pi.setProduct(pro);
            pi.setQuantity(3);

            delegate= new BusinessDelegateImpl();
            delegate.setRestTemplate(restTemplate);
        }

        @Test
        void findAllProductinventoryTest() {
            Productinventory[] piList= new Productinventory[6];
            for (int i = 0; i < piList.length; i++) {
                Productinventory currency= new Productinventory();
                piList[i]= currency;
                delegate.addProductInventory(currency);
            }
            when(restTemplate.getForObject(baseurl + "/inventoryproductRest/list",Productinventory[].class)).thenReturn(piList);
            assertEquals(delegate.showProductInventorytList().size(),6);
        }

        @Test
        void addProductinventoryTest() {
            Productinventory c= new Productinventory();
            c.setLocation(loc);
            c.setProduct(pro);
            c.setQuantity(8);
            delegate.addProductInventory(c);
            when(restTemplate.postForObject(baseurl + "/inventoryproductRest/addproductinventory/", c, Productinventory.class)).thenReturn(c);
            assertEquals(delegate.getProductInventory(c.getId()), c.getId());
        }

        @Test
        void findByIdProductinventoryTest() {
            when(restTemplate.getForObject(baseurl + "/inventoryproductRest/view/"+pi.getId(), Productinventory.class)).thenReturn(pi);
            assertEquals(delegate.getProductInventory(pi.getId()).getId(), pi.getId());
        }
    }

    @AfterAll
    static void end() {
        System.out.println(" ");
        System.out.println("--------------- BUSINESS DELEGATE TEST ENDED -----------------");
    }

}