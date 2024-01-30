package com.example.Catcafe_Customers;

import org.apache.coyote.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/catcafe")
public class CatcafeCustomersApplication {

	private CatcafeCustomersRepository catcafeCustomersRepository;

	//lombokの@RequiredArgsConstructorを使うと、コンストラクタを自動で作ってくれる。
	public CatcafeCustomersApplication(CatcafeCustomersRepository catcafeCustomersRepository){
		this.catcafeCustomersRepository = catcafeCustomersRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(CatcafeCustomersApplication.class, args);
	}

	@GetMapping
	public List<CatcafeCustomers>getCatcafeCustomers(){
		return catcafeCustomersRepository.findAll();
	}

	//requestbodyを使うと、リクエストボディを受け取ることができる。
	//Java14からは、recordを使うことで、簡単にクラスを作ることができる。
	static record NewCatcafeCustomersRequest(String name, String email, Integer age){
	}

	@PostMapping
	public void addCatcafeCustomers(@RequestBody NewCatcafeCustomersRequest request){
		CatcafeCustomers catcafeCustomers = new CatcafeCustomers();
		catcafeCustomers.setName(request.name());
		catcafeCustomers.setEmail(request.email());
		catcafeCustomers.setAge(request.age());
		catcafeCustomersRepository.save(catcafeCustomers);
	}

	@DeleteMapping("{catcafeId}")
	public void deleteCatcafe(@PathVariable("catcafeId") Integer id){
		catcafeCustomersRepository.deleteById(id);
	}



}
