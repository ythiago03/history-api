package com.gestao.api.history.repository;

import com.gestao.api.history.models.dto.HistoryDTO;
import com.gestao.api.history.models.entity.ProductHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long> {
    List<HistoryDTO> findAllByProductName(String productName);

    @Query(value = "SELECT * FROM product_history WHERE insertion_date BETWEEN :startAt AND :endAt AND product_id = :productId;", nativeQuery = true)
    List<ProductHistory> findAllByIdAndDate(@Param("productId") String productId, @Param("startAt") String startAt, @Param("endAt") String endAt);
}
