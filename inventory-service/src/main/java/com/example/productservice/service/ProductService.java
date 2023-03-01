package com.example.productservice.service;

import com.example.productservice.domain.Product;
import com.example.productservice.dto.ProductDTO;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.utils.ErrorMessage;
import com.example.productservice.utils.MapperUtil;
import com.example.productservice.utils.ProductException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;



    public void createProduct(ProductRequest request){
        log.info("ProductService.createProduct(): {}",request);
        Product product = new Product();
        BeanUtils.copyProperties(request,product);
        try {
            productRepository.save(product);
        }catch (Exception e) {
            throw new ProductException(ErrorMessage.SYSTEM_ERROR);
        }
    }

    public List<ProductDTO> getAll(){
        log.info("ProductSerice.getAll() ");
        List<Product> entitys = productRepository.findAll();
        List<ProductDTO> result =   entitys.stream()
                .map(entity -> MapperUtil.toDto(entity,new ProductDTO()))
                .collect(Collectors.toList());
        return result;
    }

}
