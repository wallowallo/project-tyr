<script>
	import Nav from '$lib/components/Nav.svelte';
</script>

<div class="layout">
	<Nav />
	<main>
		<slot />
	</main>
</div>

<style>
	.layout {
		display: flex;
		flex-direction: row;
	}

	main {
		flex: 1;
	}
</style>
