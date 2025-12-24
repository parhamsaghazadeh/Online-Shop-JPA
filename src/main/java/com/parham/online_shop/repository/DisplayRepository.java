package com.parham.online_shop.repository;

import com.parham.online_shop.entity.DisplayOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DisplayRepository  extends JpaRepository<DisplayOrder, Long> {
    @Query("""
SELECT p.name              AS person_name,
    p.lastName          AS person_lastname,
    p.birthday       AS person_birthday,
    c.title             AS category_title,
    po.name             AS product_name,
    po.brand            AS product_brand,
    po.model            AS product_model,
    po.madeIn          AS product_made_in,
    po.yareOfMenuFacture AS product_year,
    po.name           AS product_design,
    po.price            AS product_price,
    o.paymentMethod    AS order_payment_method,
    o.paymentDate      AS order_payment_date,
    orr.quantity        AS order_quantity,
    orr.price           AS order_price,
    pr.registrationDate AS product_registration_date,
    l.title             AS location_title,
    l.type              AS location_type,
    l.openTime         AS location_open_time
            FROM Product po
            JOIN po.category c
            JOIN OrderItem orr ON orr.product = po
            JOIN Orders o ON orr.orders = o
            JOIN o.person p
            JOIN DisplayOrder d ON d.orderId = o
            JOIN d.locationId l
            JOIN ProductRegistration pr
     ON pr.product = po AND pr.person = p

""")
    Optional<DisplayOrder> findByPersonName(String person_name);
}
