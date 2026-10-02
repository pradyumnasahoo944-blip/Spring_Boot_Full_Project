package com.example.method_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //custum query methods
        Optional<Product>findByProductName(String name);

        List<Product> findAllByProductPriceBetween(double startingPrice
           ,double endPrice);

        List<Product> findAllByProductPriceGreaterThanEqual(double price );
        Optional<Product> findByProductNameAndProductBrand(String name ,String brand);


        ///jpql is used for avoiding the lengthy method name 
        /// 
        /// it not support  ? so i put ?position
//       @Query("SELECT p FROM Product p WHERE p.productName = ?1 AND p.productBrand = ?2")//indec=xing parameter 
// Optional<Product> getProduct(String name, String brand);


// @Query ("SELECT P FROM Product p WHERE p.productName =:name AND p.productBrand=:brand ")//named pareameter 
// Optional<Product> getProduct(String name, String brand);



@Query(nativeQuery = true,value ="SELECT * FROM product  WHERE product_name=? AND product_brand=?")
  Optional<Product>getProduct(String name ,String brand );

  //for update 
  //as hibernate cannt upoadte so if i weant to upadte it then must be use a annotation @modifyuing

  @Modifying 
  @Transactional // while it used DML queiry or performing multipke DB operation 
  // //IT EIther useed in case of service llayer or repository layer 
  @Query (nativeQuery = true,
    value = "UPDATE product SET product_price=:price WHERE product_id=:id")
    int updatePrice(double price , int id);
}
