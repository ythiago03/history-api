package com.gestao.api.history.services;

import com.gestao.api.history.models.dto.HistoryDTO;
import com.gestao.api.history.models.entity.ProductHistory;
import com.gestao.api.history.repository.ProductHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService {

    private ProductHistoryRepository productHistoryRepository;

    public void saveHistory(HistoryDTO dto){
        ProductHistory history = new ProductHistory(dto);
        productHistoryRepository.save(history);
    }

    public List<HistoryDTO> findAllProductsByName(String productName){
        List<HistoryDTO> historyDTOList = productHistoryRepository.findAllByProductName(productName);
        return historyDTOList;
    }

    public List<ProductHistory> findAllByIdAndDate(String productId, String startAt, String endAt){
        List<ProductHistory> productHistory = productHistoryRepository.findAllByIdAndDate(productId, startAt, endAt);
        return productHistory;
    }
}
