import type { Product } from "$lib/types";

export function load() {
	return {
		products: [
			{ id: '0001', name: 'Rolex Watch', price: 1000.00 },
            { id: '0002', name: 'Michael Kors Purse', price: 80.00 },
			{ id: '0003', name: 'iPhone XS', price: 400.00 },
            { id: '0004', name: 'Casio Watch', price: 30.00 },
		] as Product[]
	};
}