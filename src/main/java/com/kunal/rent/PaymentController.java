package com.kunal.rent;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

@Controller
public class PaymentController {
    @GetMapping("/")
    public String getOrderSummary(Model model) {
        String productName = "Rental Product";
        BigDecimal price = new BigDecimal("100.00");
        String orderId = "12345";
        LocalDate orderDate = LocalDate.now();
        model.addAttribute("productName", productName);
        model.addAttribute("price", price);
        model.addAttribute("orderId", orderId);
        model.addAttribute("orderDate", orderDate);
        return "order-summary";
    }

    @GetMapping("/customer-details")
    public String getCustomerDetails(Model model, @ModelAttribute("customerDetails") CustomerDetails customerDetails) {
        boolean acceptTerms = false; // Add your own default value for the terms and conditions checkbox
        model.addAttribute("acceptTerms", acceptTerms);
        return "customer-details";
    }

    @PostMapping("/customer-details")
    public String postCustomerDetails(Model model, @ModelAttribute("customerDetails") @Validated CustomerDetails customerDetails) {
        model.addAttribute("customerDetails", customerDetails);
        BigDecimal price = new BigDecimal("100.00");
        boolean acceptTerms = customerDetails.isAcceptTerms();
        model.addAttribute("acceptTerms", acceptTerms);
        model.addAttribute("price", price);
        return "payment";
    }

    @PostMapping("/payment")
    public String postPayment(Model model) {
        BigDecimal price = new BigDecimal("100.00");
        boolean paymentSuccess = new Random().nextBoolean();
        model.addAttribute("paymentSuccess", paymentSuccess);
        model.addAttribute("price", price);
        return "payment-result";
    }
}
