package com.gestao.api.history.services;

import com.gestao.api.history.models.dto.HistoryDTO;
import com.gestao.api.history.models.entity.ProductHistory;
import com.gestao.api.history.repository.ProductHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HistoryService {

    private ProductHistoryRepository productHistoryRepository;

    public void saveHistory(HistoryDTO dto){
        ProductHistory history = new ProductHistory(dto);
        productHistoryRepository.save(history);
    }
}
