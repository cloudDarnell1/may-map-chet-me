package thaovan.lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thaovan.lab8.entity.ProductsEntity;
import thaovan.lab8.service.ProductsService;

@Controller
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public String index(Model model, @RequestParam(required = false) Long cid) {
        model.addAttribute("products", this.productsService.findByCategoryIdOrAll( cid ));
        return "product/list";
    }

    @GetMapping(path = "/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        ProductsEntity productsEntity = this.productsService.findById(id);
        model.addAttribute("product", productsEntity);
        return "product/detail";
    }

}
