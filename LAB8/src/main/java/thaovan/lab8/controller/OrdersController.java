package thaovan.lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import thaovan.lab8.service.OrdersService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/order/checkout")
    public String checkout() {
        return "order/checkout";
    }

    @GetMapping("/order/list")
    public String orderList(Model model, HttpServletRequest request) {
        String remoteUser = request.getRemoteUser();
        model.addAttribute("orders", this.ordersService.findByUsername(remoteUser));
        return "order/list";
    }

    @GetMapping("/order/detail/{id}")
    public String orderDetail(@PathVariable Long id,Model model) {
        model.addAttribute("order", this.ordersService.findById(id));
        return "order/detail";
    }

}
