<script lang="ts">
	import type { Product } from '../models/types';

	export let products: Product[] = [];

	export let add: Function;

	const tableHeaders = {
		name: 'Name',
		price: 'Price',
		blank: ''
	};
</script>

<h2>Products</h2>

<table>
	<thead>
		<tr>
			<th>{tableHeaders.name}</th>
			<th>{tableHeaders.price}</th>
			<th>{tableHeaders.blank}</th>
		</tr>
	</thead>
	<tbody>
		{#each products as product}
			<tr>
				<td>{product.name}</td>
				<td>{product.price}</td>
				<td><button class="add-button" on:click={() => add(product)}>Add</button></td>
			</tr>
		{/each}
	</tbody>
</table>

<style>
	table {
		border-collapse: collapse;
	}

	th {
		border-bottom: 1px solid grey;
	}

	td {
		padding: 0.5em;
	}

	.add-button {
		background: #ffffff;
		border: 2px solid black;
		border-radius: 24px;
		padding: 10px, 28px, 10px, 28px;
		color: black;
	}
</style>
