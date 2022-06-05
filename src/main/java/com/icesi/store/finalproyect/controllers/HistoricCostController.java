package com.icesi.store.finalproyect.controllers;

import com.icesi.store.finalproyect.businessdelegate.BusinessDelegateImpl;
import com.icesi.store.finalproyect.dao.ProductDaoImp;
import com.icesi.store.finalproyect.dao.ProductcosthistoryDaoImp;
import com.icesi.store.finalproyect.model.product.Productcosthistory;
import com.icesi.store.finalproyect.services.implementation.ProductServiceImp;
import com.icesi.store.finalproyect.services.implementation.ProductcosthistoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Optional;

@Controller
@RequestMapping("/historiccosts")
public class HistoricCostController {

    @Autowired
    BusinessDelegateImpl delegate;

    @GetMapping("")
    public String products(Model model) {
        model.addAttribute("historiccosts", delegate.showProductList());
        return "/historicCosts/index";
    }

    @GetMapping("/add/")
    public String productAddScreen(Model model) {
        model.addAttribute(new Productcosthistory());
        model.addAttribute("products", delegate.showProductList());
        return "/historiccosts/add";
    }

    @PostMapping("/add/")
    public String productAdd(@Valid @ModelAttribute Productcosthistory productcosthistory, BindingResult bindingResult,
                             Model model, @RequestParam(value = "action", required = true) String action) {

        String ret = "redirect:/historiccosts/";

        if (!action.equals("Cancel")) {
            if (!bindingResult.hasErrors()) {
                delegate.addProductHistoriccost(productcosthistory);
            } else {
                bindingResult.getAllErrors().forEach(t ->
                        System.out.println(t)
                );

                ret = "/historiccosts/add";
                model.addAttribute(new Productcosthistory());
                model.addAttribute("products", delegate.showProductList());
            }
        }
        return ret;
    }

    private Timestamp Convert(String date) {
        String res = "";
        String[] splt = null;

        if (!date.isEmpty() || !date.isBlank()) {
            splt = date.split("T");

            res += splt[0];

            res += " " + splt[1] + ":00";
        }
        return Timestamp.valueOf(res);
    }

    // ----------------- EDIT -----------------

    @GetMapping("/edit/{id}")
    public String editHistoriccostScreen(@PathVariable("id") Integer id, Model model) {
        Productcosthistory find = delegate.getProductHistoriccost(id);

        model.addAttribute("productcosthistory", find);
        model.addAttribute("products", delegate.showProductList());
        return "/historiccosts/edit";
    }

    @PostMapping("/edit/{id}")
    public String editHistoriccosts(@Valid @ModelAttribute Productcosthistory productcosthistory, BindingResult bindingResult, Model model, @PathVariable("id") Integer id,
                                    @RequestParam(value = "action", required = true) String action, String enddatelb, String standardcost) {


        String dir = "redirect:/historiccosts/";

        if (!action.equals("Cancel")) {

            delegate.editProductHistoriccost(id,productcosthistory);
        }
        return dir;
    }

}
