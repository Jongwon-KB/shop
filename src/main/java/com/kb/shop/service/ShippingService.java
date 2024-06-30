package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired
    ShippingRepository shippingRepository;

    public ShippingInfo getShippingInfo (Long id) {
        return shippingRepository.selectShippingInfo(id);
    }

    public Boolean changeShippingStatus(Long shippingId, String newShippingStatus) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo.setId(shippingId);
        shippingId.setShippingStatus(newShippingStatus);
        shippingRepository.save(shippingInfo);
        return True;
    }

    public ShippingInfo setShippingInfo (ShippingInfo shippingInfo) {
        shippingRepository.setShippingInfo(shippingInfo);
        return shippingRepository.selectShippingInfo(shippingInfo.getId());
    }
}