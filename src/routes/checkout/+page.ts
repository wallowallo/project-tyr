import type { Product } from "$lib/types";
import products from "data/products.json";

/**
 * Load products from JSON file.
 * Exported in +page.svelte as data.products
 */
export function load() {
	return { products };
}