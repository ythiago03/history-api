package com.gestao.api.history.controllers;

import com.gestao.api.history.models.dto.HistoryDTO;
import com.gestao.api.history.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
