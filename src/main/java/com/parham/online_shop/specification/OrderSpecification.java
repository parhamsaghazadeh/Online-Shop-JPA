package com.parham.online_shop.specification;

import com.parham.online_shop.entity.Orders;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class OrderSpecification {
    public static Specification<Orders> hasPaymentMethod(String paymentMethod) {
        return (root, query, cb) ->
                paymentMethod == null ? null : cb.equal(root.get("paymentMethod"), paymentMethod);
    }
    public static Specification<Orders> hasPersonName(String personName) {
        return (root, query, cb) ->
        {if (personName == null) return null;
            Join<Orders, Orders> personJoin = root.join("person");
            return cb.like(cb.lower(personJoin.get("name")), "%" + personName + "%");
        };
    }
    public static Specification<Orders> paymentAfterDate(LocalDateTime date){
        return (root, query, cb) ->
                date == null ? null : cb.greaterThanOrEqualTo(root.get("paymentDate"), date);
    }
    public static Specification<Orders> paymentBeforeDate(LocalDateTime date){
        return (root, query, cb) ->
                date == null ? null : cb.lessThan(root.get("paymentDate"), date);
    }

}
