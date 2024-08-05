package com.gestao.api.history.controllers;

import com.gestao.api.history.models.dto.HistoryDTO;
import com.gestao.api.history.models.entity.ProductHistory;
import com.gestao.api.history.services.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("history")
@Tag(name = "History Service")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @Operation(summary = "Save product history", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductHistory.class)
                    ),
                    responseCode = "201"
            )
    })
    @PostMapping
    public ResponseEntity saveHistory(@RequestBody HistoryDTO dto){
        historyService.saveHistory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Return all products filtered by name", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "")
    })
    @GetMapping("{name}")
    public ResponseEntity<List<HistoryDTO>> getAllByName(@PathVariable String productName){
        List<HistoryDTO> historyDTOList = historyService.findAllProductsByName(productName);
        return ResponseEntity.ok(historyDTOList);
    }

    @Operation(summary = "Return all products filtered by product id and date interval", method = "GET")
    @GetMapping("filtered/{productId}")
    public ResponseEntity<List<ProductHistory>> getFilteredByIdAndDate(
            @Parameter(description = "Product Id", example = "01")
            @PathVariable String productId,
            @Parameter(description = "Search start date", example = "2024-07-22")
            @RequestParam(name = "startAt") String startAt,
            @Parameter(description = "Search final date", example = "2024-07-25")
            @RequestParam(name = "endAt") String endAt
    ){
        List<ProductHistory> historyDTOList = historyService.findAllByIdAndDate(productId, startAt, endAt);
        return ResponseEntity.ok(historyDTOList);
    }
}
