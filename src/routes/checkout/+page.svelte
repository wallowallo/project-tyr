<script lang="ts">
	import type { Cart, CheckoutResponse, Product, ProductPageData } from "$lib/types";

	export let data: ProductPageData;

    export let cart: Cart = [];
    export let total: number = 0;
    
	/**
	 * Add a product to the cart
	 */
    async function add(product: Product) {
        console.log("adding product", product);
        cart.push(product.id);
    }

	/**
	 * Checkout the cart and get the total price by calling /api/checkout.
	 */
	async function checkout() {
		console.log("cart", cart);
		const response = await fetch('/api/checkout', {
			method: 'POST',
			body: JSON.stringify(cart),
			headers: {
				'content-type': 'application/json'
			}
		});

		const res: CheckoutResponse = await response.json();
        total = res.price;
	}
</script>

<h2>Products</h2>

<ul>
	{#each data.products as product}
        <li>{product.name} - {product.price} <button class="add-button" on:click={() => add(product)}>Add</button></li>
	{/each}
</ul>

<button on:click={checkout}>Calculate price</button>
<p>Total: {total}</p>
