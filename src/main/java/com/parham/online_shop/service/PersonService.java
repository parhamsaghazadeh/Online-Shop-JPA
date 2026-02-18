package com.parham.online_shop.service;

import com.parham.online_shop.entity.DisplayOrder;
import com.parham.online_shop.entity.OrderItem;
import com.parham.online_shop.entity.Orders;
import com.parham.online_shop.entity.Person;
import com.parham.online_shop.model.OrderByPersonModel;
import com.parham.online_shop.model.PersonModel;
import com.parham.online_shop.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person) {
        if (person.getOrders() != null) {
            for (Orders order : person.getOrders()) {
                order.setPerson(person);

                if (order.getOrderItems() != null) {
                    for (OrderItem orderItem : order.getOrderItems()) {
                        orderItem.setOrders(order);

                        if (order.getOrderItems() != null) {
                            for (DisplayOrder displayOrder : order.getDisplayOrders()) {
                                displayOrder.setOrderId(order);
                            }
                        }
                    }
                }
            }
        }
        if (person.getProductRegistrations() != null) {
            person.getProductRegistrations().forEach(pr -> {
                pr.setPerson(person);
            });
        }
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(long id) {
        return personRepository.findById(id).orElse(null);
    }

    public List<OrderByPersonModel> orderPerson() {
        List<OrderByPersonModel> orderByPersonModels = personRepository.findAllPerson();
        return orderByPersonModels;
    }
}
