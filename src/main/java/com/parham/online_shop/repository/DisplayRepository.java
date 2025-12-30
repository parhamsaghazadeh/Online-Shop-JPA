package com.parham.online_shop.repository;

import com.parham.online_shop.entity.DisplayOrder;
import com.parham.online_shop.model.DisplayOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisplayRepository  extends JpaRepository<DisplayOrder, Long> {
    @Modifying
    @Query("""       
SELECT new com.parham.online_shop.model.DisplayOrderModel(
    p.name,
    p.lastName,
    p.birthday,
    c.title,
    po.brand,
    po.model,
    po.madeIn,
    po.yareOfMenuFacture,
    po.name,
    po.price,
    o.paymentMethod,
    o.paymentDate,
    orr.quantity,
    orr.price,
    pr.registrationDate,
    l.title,
    l.type,
    l.openTime
)
FROM OrderItem orr
JOIN orr.product po
JOIN po.category c
JOIN orr.orders o
JOIN o.person p
JOIN DisplayOrder d ON d.orderId = o
JOIN d.locationId l
JOIN ProductRegistration pr ON pr.product = po AND pr.person = p
""")
    List<DisplayOrderModel> findAllDisplayOrders();
}
