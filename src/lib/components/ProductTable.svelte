<script lang="ts">
	import type { Product, CartItem } from '../models/types';

	export let products: Product[] | CartItem[] = [];
	export let action: { name: string; function: Function };
	export let tableHeaders: string[] = [];
	export let header = '';
</script>

<h4>{header}</h4>

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

				{#if action.name === 'remove'}
					<td>
						<button class="remove-button" on:click={() => action.function(product)}>
							<img src="/delete.svg" alt="remove" />
						</button>
					</td>
				{/if}

				{#if action.name === 'add'}
					<td><button class="add-button" on:click={() => action.function(product)}>Add</button></td>
				{/if}
			</tr>
		{/each}
	</tbody>
</table>

<style>
	table {
		border-collapse: collapse;
		width: 80%;
		margin-bottom: 3rem;
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
		border: 1px solid black;
		border-radius: 24px;
		padding: 5px 14px 5px 14px;
		color: black;
		&:hover {
			cursor: pointer;
			background-color: #f5e0ff;
		}
	}

	.remove-button {
		border: none;
		background: #ffffff;
		&:hover {
			cursor: pointer;
		}
	}

	img {
		width: 1.5rem;
	}
</style>
