package com.parham.online_shop.service;

import com.parham.online_shop.entity.DisplayOrder;
import com.parham.online_shop.model.DisplayOrderModel;
import com.parham.online_shop.repository.DisplayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayService {

    private DisplayRepository displayRepository;

    @Autowired
    public DisplayService(DisplayRepository displayRepository) {
        this.displayRepository = displayRepository;
    }

    public List<DisplayOrderModel> getAll() {
        return displayRepository.findByPersonName();
    }
}
