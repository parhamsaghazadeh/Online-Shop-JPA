package com.parham.online_shop.controller;

import com.parham.online_shop.entity.DisplayOrder;
import com.parham.online_shop.model.DisplayOrderModel;
import com.parham.online_shop.service.DisplayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/display")
@Slf4j
public class DisplayOrderController {
    private DisplayService displayService;

    @Autowired
    public DisplayOrderController(DisplayService displayService) {
        this.displayService = displayService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayOrderModel>> getAll() {
        try {
            List<DisplayOrderModel> displayOrderModels = displayService.getAll();
            return ResponseEntity.ok(displayOrderModels);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
