<script lang="ts">
	import type { Cart, CheckoutResponse, Product, ProductPageData } from '$lib/models/types';
	import ProductList from '$lib/components/ProductList.svelte';
	import CartList from '$lib/components/CartList.svelte';

	export let data: ProductPageData;
	export let cart: Cart = [];
	export let total: number = 0;

	/**
	 * Add a product to the cart
	 */
	async function add(product: Product) {
		console.log('adding product', product);
		cart.push(product.id);
	}

	const remove = (product: Product) => {
		console.log('removing product', product);
		cart = cart.filter((id) => id !== product.id);
	};

	/**
	 * Checkout the cart and get the total price by calling /api/checkout.
	 */
	async function checkout() {
		console.log('cart', cart);
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

<div class="productContent">
	<ProductList products={data.products} {add} />
</div>

<div class="productContent">
	<CartList products={data.products} {remove} />
</div>

<button on:click={checkout}>Calculate price</button>
<p>Total: {total}</p>

<style>
	.productContent {
		margin-top: 10rem;
		display: grid;
		flex-direction: column;
		align-items: center;
		width: 80%;
		margin: 0 auto;
	}
</style>
