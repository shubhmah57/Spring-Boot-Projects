package com.spring.app.MultiDB;

import com.spring.app.MultiDB.Model.Product.Product;
import com.spring.app.MultiDB.Model.User.User;
import com.spring.app.MultiDB.Repository.product.ProductRepository;
import com.spring.app.MultiDB.Repository.user.UserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
class MultiDbApplicationTests {

	@Autowired
	private UserRepository userRepository;
	 @Autowired
	 private ProductRepository productRepository;

	@Test
	@Transactional("userTransactionManager")
	public void whenUserCreated(){
		User user = new User();
		user.setUserName("shubmah9415");
		user.setPassword("123456");
		user.setName("Shubham");
		user.setEmail("shubham.mahindru9415@gmail.com");
		user.setAge(27);
		user  = userRepository.save(user);

		Assert.assertNotNull(userRepository.findById(user.getId()));
	}

	 @Test
	 @Transactional("productTransactionManager")
	 public void whenProductsCreated(){

	 	Product product = new Product();
	 	product.setName("Iphone12");
	 	product.setPrice(65000);

	 	product  = productRepository.save(product);

		 productRepository.findById(product.getId()).isPresent();
	 }


}
