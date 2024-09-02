package ag.selm.customer.controller;

import ag.selm.customer.client.ProductsClient;
import ag.selm.customer.entity.Product;
import ag.selm.customer.service.FavouriteProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@RequestMapping("customer/products/{productId:\\d++}")
public class ProductController {

    private final ProductsClient productsClient;

    private final FavouriteProductsService favouriteProductsService;

    @ModelAttribute(name = "product", binding = false)
    public Mono<Product> loadProduct(@PathVariable("productId") int id) {
        return productsClient.findProduct(id);
    }

    @GetMapping
    public Mono<String> getProductPage(@PathVariable("productId") int id, Model model) {
        model.addAttribute("inFavourite", false);
        return favouriteProductsService.findFavouriteProductByProduct(id)
                .doOnNext(favouriteProduct -> model.addAttribute("inFavourite", true))
                .thenReturn("customer/products/product");
    }

    @PostMapping("add-to-favourites")
    public Mono<String> addProductToFavourites(@ModelAttribute("product") Mono<Product> productMono) {
        return productMono
                .map(Product::id)
                .flatMap(productId -> favouriteProductsService.addProductToFavourite(productId)
                        .thenReturn("redirect:/customer/products/%d".formatted(productId)));
    }

    @PostMapping("remove-from-favourites")
    public Mono<String> removeProductFromFavourites(@ModelAttribute("product") Mono<Product> productMono) {
        return productMono
                .map(Product::id)
                .flatMap(productId -> favouriteProductsService.removeProductFromFavourites(productId)
                        .thenReturn("redirect:/customer/products/%d".formatted(productId)));
    }
}
