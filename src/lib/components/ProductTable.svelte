<script lang="ts">
	import type { Product, CartItem } from '../models/types';

	export let products: Product[] | CartItem[] = [];
	export let add: Function;
	export let tableHeaders: string[] = [];
	export let header = '';
</script>

<h2>{header}</h2>

<table>
	<thead>
		<tr>
			{#each tableHeaders as header}
				<th>{header}</th>
			{/each}
		</tr>
	</thead>
	<tbody>
		{#each products as product (product.id)}
			<tr>
				{#each Object.keys(product) as key}
					{#if key !== 'id'}
						<td>{product[key]}</td>
					{/if}
				{/each}
				<td><button class="add-button" on:click={() => add(product)}>Add</button></td>
			</tr>
		{/each}
	</tbody>
</table>

<style>
	table {
		border-collapse: collapse;
		width: 80%;
	}

	th {
		border-bottom: 1px solid grey;
		text-align: left;
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
