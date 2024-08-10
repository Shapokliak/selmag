package ag.selm.catalogue.service;

import ag.selm.catalogue.entity.Product;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Iterable<Product> findAllProducts(String filter);

    Optional<Product> findProduct(int productId);

    void updateProduct(Integer id, String title, String details);

    void deleteProduct(Integer id);

    Product createProduct(String title, String details);
}
