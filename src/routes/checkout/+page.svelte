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
	const add = async (product: Product) => {
		const existingCartItem = cartItems.find((item) => item.id === product.id);
		if (existingCartItem) {
			existingCartItem.quantity++;
			cartItems = [...cartItems];
		} else {
			cartItems = [...cartItems, { ...product, quantity: 1 }];
		}
		cart = [...cart, product.id];
		checkout();
	};

	const remove = async (product: Product) => {
		console.log('removing product', product);
		cartItems = cartItems.filter((item) => item.id !== product.id);
		cart = cart.filter((id) => id !== product.id);
		checkout();
	};

	async function checkout() {
		const response = await fetch('/api/checkout', {
			method: 'POST',
			body: JSON.stringify(cart),
			headers: {
				'content-type': 'application/json'
			}
		});

		const res: CheckoutResponse = await response.json();
		total = res.price;
		console.log('total', total);
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
