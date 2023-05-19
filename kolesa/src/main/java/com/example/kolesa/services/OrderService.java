package com.example.kolesa.services;

import com.example.kolesa.models.Cart;
import com.example.kolesa.models.Order;
import com.example.kolesa.models.Person;
import com.example.kolesa.models.Product;
import com.example.kolesa.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getByPerson(Person person){
        return orderRepository.findByPerson(person);
    }

    @Transactional
    public void saveOrder(Order order){
        orderRepository.save(order);}
}
