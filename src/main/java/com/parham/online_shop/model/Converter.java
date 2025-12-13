package com.parham.online_shop.model;

import com.parham.online_shop.entity.Category;
import com.parham.online_shop.entity.Person;
import com.parham.online_shop.entity.Product;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {
    private static final DecimalFormat df = new DecimalFormat("#,##0.00");
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    public ProductModel toModelProduct(Product product) {


        ProductModel productModel = new ProductModel();
        productModel.setId(product.getId());
        productModel.setName(product.getName());
        productModel.setBrand(product.getBrand());
        productModel.setModel(product.getModel());
        productModel.setMadeIn(product.getMadeIn());
        productModel.setPrice(df.format(product.getPrice()));

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
        return personModel;
    }

}
