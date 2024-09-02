package ag.selm.customer.service;

import ag.selm.customer.entity.FavouriteProduct;
import ag.selm.customer.repository.FavouriteProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultFavouriteProductsService implements FavouriteProductsService {

    private final FavouriteProductRepository favouriteProductRepository;
    @Override
    public Mono<FavouriteProduct> addProductToFavourite(int productId) {
        FavouriteProduct favouriteProduct = new FavouriteProduct(UUID.randomUUID(), productId);
        return favouriteProductRepository.save(favouriteProduct);
    }

    @Override
    public Mono<Void> removeProductFromFavourites(int productId) {
        return favouriteProductRepository.deleteByProductId(productId);
    }

    @Override
    public Mono<FavouriteProduct> findFavouriteProductByProduct(int produtId) {
        return favouriteProductRepository.findByProductId(produtId);
    }
}
