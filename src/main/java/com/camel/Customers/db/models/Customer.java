package com.camel.Customers.db.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String index;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "company")
    private String company;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "email")
    private String email;

    @Column(name = "subscription_date")
    private String subscriptionDate;

    @Column(name = "website")
    private String website;

    public void setIndex(String index) {
        this.index = index;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "index='" + index + '\'' +
                ", customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", email='" + email + '\'' +
                ", subscriptionDate='" + subscriptionDate + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
