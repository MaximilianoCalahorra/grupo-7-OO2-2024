package com.unla.grupo7.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="supply_order") //nombre de la tabla

public class SupplyOrder {
	
	@Id //id se genera automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplyOrderId;
		
	// many to one con product
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	
	
	private String supplier;
	
	private int amount;
	
	private String state;

	public SupplyOrder(String supplier, int amount, String state) {
		
		this.supplier = supplier;
		this.amount = amount;
		this.state = state;
	}

	///CONSTRUCTOR COMPLETO
	public SupplyOrder(Product product, String supplier, int amount, String state) {
		
		this.product = product;
		this.supplier = supplier;
		this.amount = amount;
		this.state = state;
	}
	
	
	
	
}
