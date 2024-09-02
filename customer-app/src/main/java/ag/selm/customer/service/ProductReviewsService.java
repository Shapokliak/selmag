package ag.selm.customer.service;

import ag.selm.customer.entity.ProductReview;
import reactor.core.publisher.Mono;

public interface ProductReviewsService {
    Mono<ProductReview> createProductReview(int productId, int rating, String review);


}
