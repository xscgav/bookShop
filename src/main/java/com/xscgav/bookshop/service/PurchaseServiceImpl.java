package com.xscgav.bookshop.service;

import com.xscgav.bookshop.controller.dto.FinishPurchaseRequest;
import com.xscgav.bookshop.entity.OrderEntity;
import com.xscgav.bookshop.entity.ProductEntity;
import com.xscgav.bookshop.entity.PurchaseItemEntity;
import com.xscgav.bookshop.entity.UserEntity;
import com.xscgav.bookshop.repository.OrderEntityRepo;
import com.xscgav.bookshop.repository.PurchaseItemRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {

    private final ProductService productService;
    private final UserService userService;
    private final OrderEntityRepo orderEntityRepo;
    private final PurchaseItemRepo purchaseItemRepo;


    @Override
    public Integer finishPurchase(FinishPurchaseRequest request) {
        log.info("creating order from : {}", request);
        OrderEntity orderEntity = new OrderEntity();
        UserEntity userEntity = userService.findOrCreateUser(request.getUserName(), request.getUserSurname(),
                request.getPhone(), request.getEmail(), request.getAddress());
        orderEntity.setUserEntity(userEntity);
        orderEntity.setComment(request.getComment());
        orderEntity = orderEntityRepo.save(orderEntity);
        Map<Integer, Integer> productIdProductCount = getProductIdProductCountMap(request);

        for (Map.Entry<Integer, Integer> entry : productIdProductCount.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            ProductEntity productEntity = productService.findById(k);
            PurchaseItemEntity purchaseItem = new PurchaseItemEntity();
            purchaseItem.setProductEntity(productEntity);
            purchaseItem.setCount(v);
            purchaseItem.setOrderEntity(orderEntity);
            purchaseItemRepo.save(purchaseItem);
        }

        if (request.getPassword() != null && request.getPassword().length() > 1) {
            userService.setPassword(userEntity.getId(), request.getPassword());
        }
        return orderEntity.getId();
    }

    private Map<Integer, Integer> getProductIdProductCountMap(FinishPurchaseRequest request) {
        Map<Integer, Integer> productIdProductCount = new HashMap<>();
        request.getProductIds().forEach(it -> {
            if (productIdProductCount.containsKey(it.getId())) {
                Integer productCount = productIdProductCount.get(it.getId());
                productCount = productCount + 1;
                productIdProductCount.put(it.getId(), productCount);
            } else {
                productIdProductCount.put(it.getId(), 1);
            }
        });
        return productIdProductCount;
    }
}
