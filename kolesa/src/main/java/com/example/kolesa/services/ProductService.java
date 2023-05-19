package com.example.kolesa.services;

import com.example.kolesa.models.Category;
import com.example.kolesa.models.Product;
import com.example.kolesa.repositories.ProductRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Данный метод позволяет получить список всех товаров
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    // Данный метод позволяет получить товар по id
    public Product getProductId(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    // Данный метод позволяет сохранить товар
    @Transactional
    public void saveProduct(Product product, Category category){
        product.setCategory(category);
        productRepository.save(product);
    }

    // Данный метод позволяет обновить данные о товаре
    @Transactional
    public void updateProduct(int id, Product product){
        product.setId(id);
        productRepository.save(product);
    }

    // Данный метод позволяет удалить товар по id
    @Transactional
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }

    //Данный метод позволяет искать товар по названию вне зависимости от регистра
    public List<Product> getTitleContainingAllProduct(String name){
        return productRepository.findByTitleContainingIgnoreCase(name);
    }

    //Данный метод позволяет искать товар по названию и в ценовой категории
    public List<Product> getTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(String title,float ot,float Do){
        return productRepository.findByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(title,ot,Do);
    }

    //Данный метод позволяет искать товар по названию и сортировать по возрастанию цены
    public List<Product> getTitleOrderByPriceAsc(String title,float ot,float Do){
        return productRepository.findByTitleOrderByPriceAsc(title, ot, Do);
    }

    //Данный метод позволяет искать товар по названию и сортировать по убыванию цены
    public List<Product> getTitleOrderByPriceDesc(String title,float ot,float Do){
        return productRepository.findByTitleOrderByPriceDesc(title, ot, Do);
    }

    //Данный метод позволяет искать товар по названию, сортировка по возрастанию и поиск по категории
    public List<Product> getTitleAndCategoryOrderByPriceAsc(String title,float ot,float Do,int category){
        return productRepository.findByTitleAndCategoryOrderByPriceAsc(title, ot, Do, category);
    }
    // Данный метод позволяет искать товар по названию, сортировка по убыванию и поиск по категории
    public List<Product> getTitleAndCategoryOrderByPriceDesc(String title,float ot,float Do,int category){
        return productRepository.findByTitleAndCategoryOrderByPriceDesc(title, ot, Do, category);
    }
}
