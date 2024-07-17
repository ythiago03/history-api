package com.gestao.api.history.controllers;

import com.gestao.api.history.models.dto.HistoryDTO;
import com.gestao.api.history.services.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("history")
public class HistoryController {

    private HistoryService historyService;

    @PostMapping
    public ResponseEntity saveHistory(@RequestBody HistoryDTO dto){
        historyService.saveHistory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
