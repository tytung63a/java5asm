package io.spring.service;

import java.util.Collection;

import io.spring.entities.Cart;

public interface CartService {

	double getAmount();

	int getCount();

	Collection<Cart> getAll();

	void clear();

	Cart update(int productID, int qty);

	void remove(int id);

	void add(Cart item);

}
