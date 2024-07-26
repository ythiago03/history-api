package com.gestao.api.history.controllers;

import com.gestao.api.history.models.dto.HistoryDTO;
import com.gestao.api.history.models.entity.ProductHistory;
import com.gestao.api.history.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @PostMapping
    public ResponseEntity saveHistory(@RequestBody HistoryDTO dto){
        historyService.saveHistory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{name}")
    public ResponseEntity<List<HistoryDTO>> getAllByName(@PathVariable String productName){
        List<HistoryDTO> historyDTOList = historyService.findAllProductsByName(productName);
        return ResponseEntity.ok(historyDTOList);
    }

    @GetMapping("filtered/{productId}")
    public ResponseEntity<List<ProductHistory>> getFilteredByIdAndDate(
            @PathVariable String productId,
            @RequestParam(name = "startAt") String startAt,
            @RequestParam(name = "endAt") String endAt
    ){
        List<ProductHistory> historyDTOList = historyService.findAllByIdAndDate(productId, startAt, endAt);
        return ResponseEntity.ok(historyDTOList);
    }
}
