package com.parham.online_shop.model;

import com.parham.online_shop.entity.*;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {
    private static final DecimalFormat df = new DecimalFormat("#,##0.00");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter formatterTime =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public ProductModel toModelProduct(Product product) {


        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setBrand(product.getBrand());
        productModel.setModel(product.getModel());
        productModel.setMadeIn(product.getMadeIn());
        productModel.setPrice(df.format(product.getPrice()));
        productModel.setSerialNumber(product.getSerialNumber());

        if (product.getIsOriginal() != null){
            productModel.setIsOriginal(product.getIsOriginal().toString());
        }

        if (product.getYareOfMenuFacture() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            productModel.setYear_of_manufacture(sdf.format(product.getYareOfMenuFacture()));
        }

        if (product.getCategory() != null) {
            productModel.setCategory_id(product.getCategory().getId());
        }
        return productModel;
    }

    public CategoryModel toModelCategory(Category category) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(category.getId());
        categoryModel.setTitle(category.getTitle());
        categoryModel.setCode(category.getCode());
        List<ProductModel> productModels = category.getProducts()
                .stream().map(this::toModelProduct).collect(Collectors.toList());
        categoryModel.setProducts(productModels);
        return categoryModel;
    }

    public PersonModel toModelPerson(Person person) {
        PersonModel personModel = new PersonModel();
        personModel.setId(person.getId());
        personModel.setName(person.getName());
        personModel.setLastName(person.getLastName());
        personModel.setBirthday(formatter.format(person.getBirthday()));
        personModel.setUserId(person.getUserId());
        personModel.setGenderId(person.getGenderId());
        personModel.setRoleId(person.getRoleId());
        personModel.setPersonId(person.getId());
        personModel.setPhone(person.getPhone());
        personModel.setAge(person.getAge());

        if (person.getAddress() != null) {
            AddressModel addressModel = new AddressModel();
            addressModel.setCity(person.getAddress().getCity());
            addressModel.setStreet(person.getAddress().getStreet());
            addressModel.setZipcode(person.getAddress().getZipcode());
            personModel.setAddress(addressModel);
        }

        List<OrderModel> orderModels = person.getOrders()
                .stream().map(this::toModelOrder).collect(Collectors.toList());
        personModel.setOrdersList(orderModels);
        List<ProductRegisterModel> productRegisterModels = person.getProductRegistrations()
                .stream().map(this::toModelProductRegister).collect(Collectors.toList());
        personModel.setProductRegisterModels(productRegisterModels);
        return personModel;
    }

    public OrderModel toModelOrder(Orders orders) {
        OrderModel orderModel = new OrderModel();
        orderModel.setId(orders.getId());
        orderModel.setPersonId(orders.getPerson().getId());
        LocalDateTime paymentDate = orders.getPaymentDate();
        if (paymentDate != null) {
            orderModel.setPaymentDate(formatterTime.format(paymentDate));
        }
        orderModel.setPaymentMethod(orders.getPaymentMethod());
        List<OrderItemModel> orderItemModels = orders.getOrderItems()
                .stream().map(this::toModelOrderItem).collect(Collectors.toList());
        orderModel.setOrderItems(orderItemModels);
        return orderModel;
    }

    public OrderItemModel toModelOrderItem(OrderItem orderItem) {
        OrderItemModel orderItemModel = new OrderItemModel();
        orderItemModel.setId(orderItem.getId());
        orderItemModel.setOrderId(orderItem.getOrders().getId());
        orderItemModel.setProductId(orderItem.getProduct().getId());
        orderItemModel.setQuantity(orderItem.getQuantity());
        orderItemModel.setPrice(orderItem.getPrice().toString());
        return orderItemModel;
    }

    public ProductRegisterModel toModelProductRegister(ProductRegistration productRegistration) {
        ProductRegisterModel productRegisterModel = new ProductRegisterModel();
        productRegisterModel.setId(productRegistration.getId());
        productRegisterModel.setPersonId(productRegistration.getPerson().getId());
        productRegisterModel.setProductId(productRegistration.getProduct().getId());
        productRegisterModel.setRegistrationDate(productRegistration.getRegistrationDate());
        return productRegisterModel;
    }
}
