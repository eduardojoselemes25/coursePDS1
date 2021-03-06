package com.iftm.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.course.dto.OrderDTO;
import com.iftm.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping
	public 	ResponseEntity<List<OrderDTO>> findAll() {
		return ResponseEntity.ok().body(orderService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(orderService.findById(id));
	}
}
