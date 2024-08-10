package ag.selm.catalogue.repository;

import ag.selm.catalogue.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(value = "select p from Product p where p.title ilike :filter")
    Iterable<Product> findAllByTitleLikeIgnoreCase(String filter);

}
