package com.parham.online_shop.repository;

import com.parham.online_shop.entity.Person;
import com.parham.online_shop.model.OrderByPersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {
    @Query("""
            SELECT new com.parham.online_shop.model.OrderByPersonModel(
            p.name , p.lastName , o.paymentMethod , o.paymentDate, ot.quantity,ot.price,pr.registrationDate
            )
                        from Orders o
                        join o.person p
                        join OrderItem ot on ot.orders = o
                        join ProductRegistration pr on pr.person = p
            
            """)
    List<OrderByPersonModel> findAllPerson();
}
