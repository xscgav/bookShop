package com.xscgav.bookshop.service;

import com.xscgav.bookshop.controller.dto.FinishPurchaseRequest;
import com.xscgav.bookshop.entity.OrderEntity;
import com.xscgav.bookshop.entity.ProductEntity;
import com.xscgav.bookshop.entity.PurchaseItemEntity;
import com.xscgav.bookshop.repository.OrderEntityRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrderEntityRepo orderEntityRepo;

    @Override
    public Integer finishPurchase(FinishPurchaseRequest request) {
        log.info("creating order entity: {} in progress", request);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserEntity(userService.findOrCreateUser(request.getUserName(), request.getUserSurname(), request.getEmail(), request.getPhone(), request.getAddress()));
        orderEntity.setComment(request.getComment());
        orderEntity = orderEntityRepo.save(orderEntity);

        for (Map.Entry<Integer, Integer> entry : request.getProductIdProductCount().entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            ProductEntity productEntity = productService.findById(k);
            PurchaseItemEntity purchaseItemEntity = new PurchaseItemEntity();
            purchaseItemEntity.setProductEntity(productEntity);
            purchaseItemEntity.setCount(v);
            purchaseItemEntity.setOrderEntity(orderEntity);
        }
        return orderEntity.getId();
    }
}
