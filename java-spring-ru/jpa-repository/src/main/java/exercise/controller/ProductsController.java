package exercise.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

//    Создайте в контроллере метод, который обрабатывает GET-запросы по адресу /products и возвращает список товаров.
//    Метод должен поддерживать фильтрацию товаров по максимальной и минимальной цене и возвращать все товары,
//    цена которых лежит в указанном диапазоне. Параметры передаются в строке запроса.
//    Например, запрос на адрес /products?min=30&max=40 должен вернуть все товары, которые дороже 30 и дешевле 40:

    // BEGIN
    @GetMapping(path = "")
    public List<Product> showPriceRange(@RequestParam(name = "min", defaultValue = "") String minParam,
                                        @RequestParam(name = "max", defaultValue = "") String maxParam) {

        int min = 0, max = 0;

        try {
            min = Integer.parseInt(minParam);
            } catch (NumberFormatException e) {
        }
        try {
            max = Integer.parseInt(maxParam);
            } catch (NumberFormatException e) {
        }

        if (max == 0) {
            List<Product> ret = productRepository.findByPriceGreaterThanEqual(min).stream()
                    .sorted(Comparator.comparing(Product::getPrice))
                    .toList();

            return ret;
        } else {
            List<Product> ret = productRepository.findByPriceBetween(min, max).stream().
                    sorted(Comparator.comparing(Product::getPrice)).
                    toList();
            return ret;
        }
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
