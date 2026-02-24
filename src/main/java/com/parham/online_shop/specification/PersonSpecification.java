package com.parham.online_shop.specification;

import com.parham.online_shop.entity.Person;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class PersonSpecification {
    public static Specification<Person> hasPersonAge(Integer age){
        return (root, query, cb) ->
                age < 0  ? null : cb.equal(root.get("age") , age);
    }
    public static Specification<Person> hasPersonBirthday(LocalDateTime birthday){
        return (root, query, cb) ->
                birthday == null ? null : cb.greaterThanOrEqualTo(root.get("birthday"), birthday);

    }
}
