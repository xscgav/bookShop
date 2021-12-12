package com.xscgav.bookshop.controller;

import com.xscgav.bookshop.controller.dto.FinishPurchaseRequest;
import com.xscgav.bookshop.controller.dto.FinishPurchaseResponse;
import com.xscgav.bookshop.service.PurchaseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@AllArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping("/finishPurchase")
    public ResponseEntity finishPurchase(@Valid @RequestBody FinishPurchaseRequest request){
        log.info("finish purchase request: {} in progress", request);
        Integer orderId = purchaseService.finishPurchase(request);
        return ResponseEntity.ok(new FinishPurchaseResponse(orderId));
    }
}
