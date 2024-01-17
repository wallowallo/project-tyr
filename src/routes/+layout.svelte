<nav>
	<a href="/">Home</a>
	<a href="/checkout">Checkout</a>
</nav>

<div class="layout">
	<main>
		<slot />
	</main>
</div>

<style>
	@media (min-width: 640px) {
		.layout {
			display: grid;
			gap: 2em;
			grid-template-columns: 1fr 16em;
		}
	}
</style>
