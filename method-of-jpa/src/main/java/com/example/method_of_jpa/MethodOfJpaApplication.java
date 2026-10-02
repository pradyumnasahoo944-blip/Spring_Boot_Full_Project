package com.example.method_of_jpa;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import org.springframework.data.domain.Page;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor 
public class MethodOfJpaApplication {
	private  final ProductRepository productRepository ;
	private  final OrdersService ordersService;

	public static void main(String[] args) {
		SpringApplication.run(MethodOfJpaApplication.class, args);
	}

	@Bean 
	public CommandLineRunner commandLineRunner (){
		return  args ->{
			Product product =Product.builder()
						.productName("Iphone")
						.productBrand("Apple")
						.productPrice(190000.00)
						.build();

	//SAVE
	// Product savedProduct =productRepository.save(product);
	// System.out.println("saved prodycct is "+savedProduct);



	//SAVE ALL
	// productRepository.saveAll(getProducts());
	


	//count
	// long totalProducts = productRepository.count();
	// System.out.println("total num od=f oroduct is "+totalProducts);


	//Exists
    // boolean isIphoneExists =productRepository.existsById(100);
	// System.out.println("is i phone is exist "+isIphoneExists);
	
	// Product existingProduct =productRepository.findById(1).orElseThrow();
	// boolean isIphoneExists2 = productRepository.exists(Example.of(existingProduct));
	// System.out.println("is i phone is exist "+isIphoneExists2);


	//delete
	// productRepository.deleteById(9);
	//delete all1
	// List<Product> products =productRepository.findAll();
	// productRepository.deleteAll(products);
	
	// List<Product> products =
    //     productRepository.findAll(
    //             Sort.by(("productPrice")));
	// products.forEach(System.out::println);
	
	
	// Product producct1 =productRepository.findById(1).orElseThrow();
	// producct1.setProductBrand("Samsung");
	// producct1.setProductPrice(99999.00);
	
	// productRepository.save(producct1);
	// existingProduct.setProductName()
	
	
	
	// Page<Product> products = productRepository.findAll(PageRequest.of(0, 5));
	// Page<Product>products =productRepository.findAll(PageRequest.of(1,5,Direction.DESC,"productId"));
	// System.out.println("page info is "+products);

	// // page number-> 0 based indexing 
	// //page size ->number of data inside the page 
	// products.forEach(System.out::println);

	//those all are pre build method of jpa if i want any custom mehgid then i use 1.custum query methods 2.jpql3.plain sql/row sql
	  

	// Product optGalaxy=productRepository.findByProductName("producct7").orElseThrow();
	// System.out.println(optGalaxy);


	// productRepository.findAllByProductPriceBetween(3000, 7000)
	// 												.forEach(System.out::println);


	// productRepository.findAllByProductPriceGreaterThanEqual(5000).forEach(System.out::println);
	// productRepository.findByProductNameAndProductBrand("producct2", "brand2")
	// 								.ifPresent(p ->System.out.println(p));

	// productRepository.getProduct("producct2", "brand2")
	// 		.ifPresent(p ->System.out.println(p));


	// int affectedRow = productRepository.updatePrice(20000, 2);
	// System.out.println("No oF affected rows "+affectedRow);

	ordersService.placeOrder(1, 9);

	};
	}


	//save all
	private  List<Product> getProducts(){
	return	IntStream.range(1, 10).mapToObj(i ->Product.builder()
			 .productName("producct" + i)
			 .productBrand("brand" + i)
			 .productPrice(1000*i)
			.build())
			.toList();
	}
}




