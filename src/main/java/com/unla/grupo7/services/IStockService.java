package com.unla.grupo7.services;

import java.util.List;

import com.unla.grupo7.entities.Stock;

public interface IStockService 
{
	///Encontrar:
	
	//Encontramos el stock con determinado id o lanzamos una excepción por stock inexistente:
	public Stock findByStockId(int stockId) throws Exception;
		
	//Encontramos el stock con determinado producto o lanzamos una excepción por stock inexistente:
	public Stock findByProduct(int productId) throws Exception;
		
	//Encontramos los stock con determinada cantidad mínima:
	public List<Stock> findByMinimumAmount(int minimumAmount);
		
	//Encontramos los stocks con determinada cantidad actual:
	public List<Stock> findByActualAmount(int actualAmount);
		
	//Encontramos los stocks con una cantidad actual mayor o igual a determinada cantidad:
	public List<Stock> findByActualAmountGreaterThanOrEqualTo(int amount);
		
	//Encontramos los stocks con una cantidad actual menor o igual a determinada cantidad:
	public List<Stock> findByActualAmountLessThanOrEqualTo(int amount);
		
	//Encontramos los stocks con una cantidad actual entre dos cantidades determinadas (extremos incluidos):
	public List<Stock> findByActualAmountRange(int minimumAmount, int maximumAmount);

	///Obtener:
	
	//Obtenemos los stocks:
	public List<Stock> getAll();
	
	//Obtenemos la cantidad actual de stock de un producto:
	public int actualAmount(int productId);
	
	///Agregar o modificar:
	
	//Agregamos o modificamos un stock:
	public Stock insertOrUpdate(Stock stock);
	
	///Verificar:
	
	//Verificamos que el stock del producto sea suficiente:
	public void availableStock(int productId, int amount) throws Exception;
}
