package com.example.orderservice.service;

import com.example.orderservice.domain.Order;
import com.example.orderservice.domain.OrderLineItems;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.utils.ErrorMessage;
import com.example.orderservice.utils.MapperUtil;
import com.example.orderservice.utils.OrderRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(OrderRequest orderRequest){
        log.info("OrderService.createOrder(): {}",orderRequest);
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTOS().stream()
                .map(dto -> MapperUtil.toEntity(dto,new OrderLineItems())).collect(Collectors.toList());
        Order order = new Order();
        try {
            order.setOrderLineItems(orderLineItems);
            orderRepository.save(order);
        }catch (Exception e){
            throw new OrderRuntimeException(ErrorMessage.SYSTEM_ERROR);
        }
    }
}
