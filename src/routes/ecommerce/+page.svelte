<script lang="ts">
	import type { Product, ProductPageData } from "$lib/types";

	export let data: ProductPageData;

    export let cart: string[] = [];
    export let total: number = 0;
    
    async function add(product: Product) {
        console.log("adding product", product);
        cart.push(product.id);
    }

    async function checkout() {
		console.log("cart", cart);
		const response = await fetch('/api/checkout', {
			method: 'POST',
			body: JSON.stringify(cart),
			headers: {
				'content-type': 'application/json'
			}
		});

		const res = await response.json();
        total = res.price;
	}

</script>

<h1>Webshop</h1>

<h2>Products</h2>

<ul>
	{#each data.products as product}
        <li>{product.name} - {product.price} <button class="add-button" on:click={() => add(product)}>Add</button></li>
	{/each}
</ul>

<button on:click={checkout}>Checkout</button>
<p>Total: {total}</p>
