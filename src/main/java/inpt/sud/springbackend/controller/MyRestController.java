package inpt.sud.springbackend.controller;

import inpt.sud.springbackend.dao.ProductRepository;
import inpt.sud.springbackend.data.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class MyRestController{
    private ProductRepository productRepository;

    public MyRestController(ProductRepository p){
        productRepository = p;
    }

    @GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Product p = productRepository.findById(id).get();
        System.out.println(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName());
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));
    }

}