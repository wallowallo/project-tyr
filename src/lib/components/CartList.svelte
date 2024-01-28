<script lang="ts">
	import type { Product } from '../models/types';
	import ProductTable from './ProductTable.svelte';

	export let products: Product[] = [];

	export let add: Function;

	const tableHeaders = ['Name', 'Qty', 'Price', ''];
	const header = 'Shopping Cart';
</script>

<ProductTable {products} {add} {tableHeaders} {header} />
