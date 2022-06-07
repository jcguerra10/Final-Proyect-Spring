package com.icesi.store.finalproyect.controllers;

import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.services.implementation.ProductServiceImp;
import com.icesi.store.finalproyect.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/queries")
public class QueriesShop {

    private final ProductDaoImp dao;

    public QueriesShop(ProductDaoImp dao) {
        this.dao = dao;
    }

    @GetMapping("/special1")
    public String specialQuery1() {

        return "";
    }

    @GetMapping("/special2")
    public String specialQuery2(Model model) {
        List<?> list = dao.specialQuery2();
        model.addAttribute("querylist", list);
        System.out.println(">>: " + list.size());
        list.forEach(l ->
                System.out.println("->" + l));
        return "/queries/product-by-subcategory";
    }
}
