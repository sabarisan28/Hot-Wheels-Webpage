package com.hotwheels.config;

import com.hotwheels.model.Product;
import com.hotwheels.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        // Only insert if database is empty
        if (productRepository.count() > 0) {
            log.info("Products already exist in database. Skipping data initialization.");
            return;
        }

        log.info("Initializing database with sample products...");

        List<Product> products = new ArrayList<>();

        // Baby Cars (1-12 months)
        products.add(createProduct("Baby Racer Red", "Safe and colorful toy car for babies 1-12 months", 499.99, "download (21).jpeg", 100));
        products.add(createProduct("Baby Speedster Blue", "Soft edges perfect for little hands", 519.99, "download (20).jpeg", 95));
        products.add(createProduct("Baby Cruiser Yellow", "Bright colors stimulate baby's vision", 539.99, "download (19).jpeg", 90));
        products.add(createProduct("Baby Turbo Green", "Easy to grip for tiny fingers", 559.99, "download (18).jpeg", 85));
        products.add(createProduct("Baby Rocket Orange", "Smooth rolling wheels for safe play", 579.99, "download (17).jpeg", 80));
        products.add(createProduct("Baby Flash Pink", "Non-toxic materials, baby-safe", 599.99, "download (16).jpeg", 75));
        products.add(createProduct("Baby Thunder Purple", "Lightweight design for easy handling", 619.99, "download (15).jpeg", 70));
        products.add(createProduct("Baby Lightning White", "Rounded corners for safety", 639.99, "download (14).jpeg", 65));
        products.add(createProduct("Baby Storm Black", "Durable construction for rough play", 659.99, "download (13).jpeg", 60));
        products.add(createProduct("Baby Blaze Silver", "Washable and easy to clean", 679.99, "download (12).jpeg", 55));
        products.add(createProduct("Baby Dash Gold", "Perfect first car for infants", 699.99, "download (11).jpeg", 50));
        products.add(createProduct("Baby Zoom Bronze", "Encourages motor skill development", 719.99, "download (10).jpeg", 45));

        // Fun Racers (1-6 years)
        products.add(createProduct("Fun Racer Turbo", "Exciting racing car for young kids", 599.99, "download (1).jpeg", 120));
        products.add(createProduct("Fun Racer Speed", "Colorful design with racing stripes", 629.99, "images (2).jpeg", 115));
        products.add(createProduct("Fun Racer Flash", "Pull-back action for extra fun", 659.99, "images.jpeg", 110));
        products.add(createProduct("Fun Racer Bolt", "Realistic racing details", 689.99, "images (1).jpeg", 105));
        products.add(createProduct("Fun Racer Storm", "Multiple colors available", 719.99, "images (3).jpeg", 100));
        products.add(createProduct("Fun Racer Thunder", "Durable die-cast metal body", 749.99, "download (2).jpeg", 95));
        products.add(createProduct("Fun Racer Lightning", "Smooth rolling wheels", 779.99, "download (3).jpeg", 90));
        products.add(createProduct("Fun Racer Blaze", "Perfect for racing tracks", 809.99, "download (4).jpeg", 85));
        products.add(createProduct("Fun Racer Rocket", "Aerodynamic design", 839.99, "download (5).jpeg", 80));
        products.add(createProduct("Fun Racer Dash", "Vibrant metallic finish", 869.99, "download (6).jpeg", 75));
        products.add(createProduct("Fun Racer Zoom", "Collectible racing series", 899.99, "download (7).jpeg", 70));
        products.add(createProduct("Fun Racer Nitro", "High-speed racing action", 929.99, "download (8).jpeg", 65));

        // Speedsters (6-12 years)
        products.add(createProduct("Speedster Pro X1", "Professional racing car replica", 699.99, "download (22).jpeg", 60));
        products.add(createProduct("Speedster Pro X2", "Advanced die-cast construction", 724.99, "download (23).jpeg", 58));
        products.add(createProduct("Speedster Pro X3", "Detailed interior and exterior", 749.99, "download (24).jpeg", 56));
        products.add(createProduct("Speedster Pro X4", "Opening doors and hood", 774.99, "download (25).jpeg", 54));
        products.add(createProduct("Speedster Pro X5", "Real rubber tires", 799.99, "download (26).jpeg", 52));
        products.add(createProduct("Speedster Pro X6", "Limited edition racing series", 824.99, "download (27).jpeg", 50));
        products.add(createProduct("Speedster Pro X7", "Authentic racing decals", 849.99, "download (28).jpeg", 48));
        products.add(createProduct("Speedster Pro X8", "Premium metallic paint", 874.99, "download (29).jpeg", 46));
        products.add(createProduct("Speedster Pro X9", "Track-ready performance", 899.99, "download (30).jpeg", 44));
        products.add(createProduct("Speedster Pro X10", "Championship edition", 924.99, "images (4).jpeg", 42));
        products.add(createProduct("Speedster Pro X11", "Turbo boost design", 949.99, "images (5).jpeg", 40));
        products.add(createProduct("Speedster Pro X12", "Ultimate racing machine", 974.99, "images (6).jpeg", 38));

        // Collector Editions (12+ years)
        products.add(createProduct("Collector Edition Classic 1", "Vintage racing legend", 999.99, "images (7).jpeg", 35));
        products.add(createProduct("Collector Edition Classic 2", "Museum-quality replica", 1049.99, "images (8).jpeg", 33));
        products.add(createProduct("Collector Edition Classic 3", "Hand-painted details", 1099.99, "images (9).jpeg", 31));
        products.add(createProduct("Collector Edition Classic 4", "Numbered limited edition", 1149.99, "download (31).jpeg", 29));
        products.add(createProduct("Collector Edition Classic 5", "Certificate of authenticity", 1199.99, "download (32).jpeg", 27));
        products.add(createProduct("Collector Edition Classic 6", "Display case included", 1249.99, "download (33).jpeg", 25));
        products.add(createProduct("Collector Edition Classic 7", "Rare vintage model", 1299.99, "download (34).jpeg", 23));
        products.add(createProduct("Collector Edition Classic 8", "Premium collector's item", 1349.99, "download (35).jpeg", 21));
        products.add(createProduct("Collector Edition Classic 9", "Investment-grade quality", 1399.99, "download (36).jpeg", 19));
        products.add(createProduct("Collector Edition Classic 10", "Exclusive limited run", 1449.99, "download (37).jpeg", 17));
        products.add(createProduct("Collector Edition Classic 11", "Masterpiece collection", 1499.99, "images (10).jpeg", 15));
        products.add(createProduct("Collector Edition Classic 12", "Ultimate collector's dream", 1549.99, "images (11).jpeg", 13));

        // Special Editions
        products.add(createProduct("Hot Wheels Mega Track Set", "Complete track with 2 cars and accessories", 1599.99, "download (9).jpeg", 30));
        products.add(createProduct("Hot Wheels Stunt Set", "Loop-the-loop action set", 1299.99, "images (12).jpeg", 35));
        products.add(createProduct("Hot Wheels City Garage", "Multi-level parking garage playset", 1799.99, "images (13).jpeg", 25));
        products.add(createProduct("Hot Wheels Monster Truck", "Giant monster truck with oversized wheels", 899.99, "download.jpeg", 40));
        products.add(createProduct("Hot Wheels Racing Team Pack", "Set of 5 racing cars", 1999.99, "e23e9beb268164631ee72d6fc8409f2f.jpg", 20));
        products.add(createProduct("Hot Wheels Ultimate Garage", "The biggest Hot Wheels playset", 2499.99, "1685581b3f31942acc035a6696a3d0d7.jpg", 15));

        productRepository.saveAll(products);
        log.info("Successfully inserted {} products into database", products.size());
    }

    private Product createProduct(String name, String description, double price, String imageUrl, int stock) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(BigDecimal.valueOf(price));
        product.setImageUrl(imageUrl);
        product.setStock(stock);
        return product;
    }
}
