<script lang="ts">
	import type { Product } from '../models/types';
	import ProductTable from './ProductTable.svelte';

	export let products: Product[] = [];

	export let add: Function;

	const action = { name: 'add', function: add };
	const tableHeaders = ['Name', 'Price', ''];
	const header = 'Products';
</script>

<ProductTable {products} {action} {tableHeaders} {header} />
