package com.hotwheels.controller;

import com.hotwheels.repository.OrderItemRepository;
import com.hotwheels.repository.OrderRepository;
import com.hotwheels.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class AdminController {
    
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    
    /**
     * Clear all products and related data
     * WARNING: This will delete all orders and order items!
     */
    @DeleteMapping("/clear-products")
    public ResponseEntity<Map<String, Object>> clearAllProducts() {
        log.warn("ADMIN: Clearing all products and related data...");
        
        Map<String, Object> result = new HashMap<>();
        
        // Delete in correct order to avoid foreign key constraints
        long orderItemsDeleted = orderItemRepository.count();
        orderItemRepository.deleteAll();
        log.info("Deleted {} order items", orderItemsDeleted);
        
        long ordersDeleted = orderRepository.count();
        orderRepository.deleteAll();
        log.info("Deleted {} orders", ordersDeleted);
        
        long productsDeleted = productRepository.count();
        productRepository.deleteAll();
        log.info("Deleted {} products", productsDeleted);
        
        result.put("orderItemsDeleted", orderItemsDeleted);
        result.put("ordersDeleted", ordersDeleted);
        result.put("productsDeleted", productsDeleted);
        result.put("message", "All products and related data cleared successfully");
        
        log.warn("ADMIN: Database cleared. Restart application to load sample data.");
        
        return ResponseEntity.ok(result);
    }
    
    /**
     * Get database statistics
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Long>> getDatabaseStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("products", productRepository.count());
        stats.put("orders", orderRepository.count());
        stats.put("orderItems", orderItemRepository.count());
        return ResponseEntity.ok(stats);
    }
}
