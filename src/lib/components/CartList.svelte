<script lang="ts">
	import type { Product, CartItem } from '../models/types';
	import ProductTable from './ProductTable.svelte';

	export let products: Product[] | CartItem[] = [];

	export let remove: Function;

	const action = { name: 'remove', function: remove };
	const tableHeaders = ['Name', 'Price', 'Qty', ''];
	const header = 'Shopping Cart';
</script>

<ProductTable {products} {action} {tableHeaders} {header} />
