package ag.selm.customer.service;

import ag.selm.customer.entity.FavouriteProduct;
import reactor.core.publisher.Mono;

public interface FavouriteProductsService {

    Mono<FavouriteProduct> addProductToFavourite(int productId);

    Mono<Void> removeProductFromFavourites(int productId);

    Mono<FavouriteProduct> findFavouriteProductByProduct(int produtId);
}
