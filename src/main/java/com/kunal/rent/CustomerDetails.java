package com.kunal.rent;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public class CustomerDetails {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Number is required")
    private String number;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    private boolean acceptTerms;

    public CustomerDetails() {}

    public CustomerDetails(String name, String number, String email, String address, boolean acceptTerms) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.acceptTerms = acceptTerms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }
}
