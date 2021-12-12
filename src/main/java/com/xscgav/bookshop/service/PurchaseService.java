package com.xscgav.bookshop.service;

import com.xscgav.bookshop.controller.dto.FinishPurchaseRequest;

public interface PurchaseService {

    Integer finishPurchase(FinishPurchaseRequest request);
}
