<script lang="ts">
	import type { Product } from '../models/types';
	import ProductTable from './ProductTable.svelte';

	export let products: Product[] = [];

	export let remove: Function;

	const action = { name: 'remove', function: remove };
	const tableHeaders = ['Name', 'Qty', 'Price', ''];
	const header = 'Shopping Cart';
</script>

<ProductTable {products} {action} {tableHeaders} {header} />
