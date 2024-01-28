<script lang="ts">
	import type {
		Cart,
		CartItem,
		CheckoutResponse,
		Product,
		ProductPageData
	} from '$lib/models/types';
	import ProductList from '$lib/components/ProductList.svelte';
	import CartList from '$lib/components/CartList.svelte';

	export let data: ProductPageData;
	export let cart: Cart = [];
	export let total: number = 0;

	let cartItems: CartItem[] = [];

	/**
	 * Add a product to the cart
	 */
	async function add(product: Product) {
		console.log('adding product', product);
		cart = [...cart, product.id];
		cartItems = [...cartItems, { ...product, quantity: 1 }];
	}

	const remove = (product: Product) => {
		console.log('removing product', product);
		cartItems = cartItems.filter((item) => item.id !== product.id);
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

<div class="checkoutContainer">
	<div class="productContent">
		<ProductList products={data.products} {add} />
	</div>

	<div class="productContent">
		<CartList products={cartItems} {remove} />
		<p><strong>Total</strong> {total}</p>
	</div>
</div>

<style>
	.checkoutContainer {
		margin-top: 5rem;
		display: flex;
		flex-direction: column;
	}
	.productContent {
		display: grid;
		flex-direction: column;
		width: 80%;
	}

	p {
		text-align: right;
		width: 46%;
	}
	strong {
		margin-right: 2rem;
	}
</style>
