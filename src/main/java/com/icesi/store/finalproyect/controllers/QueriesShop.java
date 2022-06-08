package com.icesi.store.finalproyect.controllers;

import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.dao.ProductsubcategoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/queries")
public class QueriesShop {

    private final ProductDaoImp dao;
    private final ProductsubcategoryDao daoSub;

    public QueriesShop(ProductDaoImp dao, ProductsubcategoryDao daoSub) {
        this.dao = dao;
        this.daoSub = daoSub;
    }

    @GetMapping("/special1")
    public String specialQuery1(Integer subcategory, Model model) {
        model.addAttribute("subcategories", daoSub.getAll());
        if (subcategory != null) {
            List<?> list = dao.specialQuery(subcategory);
            model.addAttribute("querylist", list);
            System.out.println(">>: " + list.size());
            list.forEach(l ->
                    System.out.println("->" + l));
        }
        return "/queries/product-between-dates";
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
