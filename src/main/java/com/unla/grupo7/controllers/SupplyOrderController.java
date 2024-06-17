package com.unla.grupo7.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo7.entities.Product;
import com.unla.grupo7.entities.SupplyOrder;
import com.unla.grupo7.helpers.ViewRouteHelper;
import com.unla.grupo7.repositories.ISupplyOrderRepository;
import com.unla.grupo7.services.ISupplyOrderService;

@Controller
@RequestMapping("/supplyOrder")
public class SupplyOrderController {
	
	private ISupplyOrderService supplyOrderService;

	public SupplyOrderController(ISupplyOrderService supplyOrderService) {

		this.supplyOrderService = supplyOrderService;
	}

	//1- AGREGAR PRODUCTOS
	@GetMapping("/supplyOrderAdd")
	public ModelAndView supplyOrderAdd() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.SUPPLY_ORDER_ADD);
		modelAndView.addObject("supplyOrder", new Product ());
		return modelAndView;
	}
	
	///2- GUARDAR EN LA BD
	@PostMapping("/supplyOrderSave") 
	public ModelAndView create(@ModelAttribute("supplyOrder") SupplyOrder supplyOrder) {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.SUPPLY_ORDER_SAVE);
		try {
			supplyOrderService.insert(supplyOrder);
		} 
		catch(Exception e){
			
			e.getMessage();
		}
		
		modelAndView.addObject("supplyOrder", supplyOrder);
		return modelAndView;
	}
	
	///3 LISTA DE 
	@GetMapping("/supplyOrders")
	public ModelAndView supplyOrders() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.SUPPLY_ORDERS);
		List <SupplyOrder> listaSuppyOrders = supplyOrderService.getAll();
		modelAndView.addObject("listaSupplyOrders", listaSuppyOrders);
		return modelAndView;
	}
	
	
	
	
	

}