package com.parham.online_shop.model;

import com.parham.online_shop.entity.Category;
import com.parham.online_shop.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
@Component
public class Converter {
    private static final DecimalFormat df = new DecimalFormat("#,##0.00");

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

    public CategoryModel toModelProduct(Category category) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(category.getId());
        categoryModel.setTitle(category.getTitle());
        categoryModel.setCode(category.getCode());
        return categoryModel;
    }
}
