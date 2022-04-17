package com.sportyshoes.service;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.sportyshoes.model.Admin;
//import com.sportyshoes.model.Product;
import com.sportyshoes.repository.AdminRepository;
//import com.sportyshoes.repository.ProductRepository;
//import com.sportyshoes.repository.ProductRepository;

	@Service
	public class AdminService {
		@Autowired
		AdminRepository obj;
		
		public Admin putPass(Admin p) {
			return obj.save(p);
		}
}
