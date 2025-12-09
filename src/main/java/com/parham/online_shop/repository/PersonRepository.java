package com.parham.online_shop.repository;

import com.parham.online_shop.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
