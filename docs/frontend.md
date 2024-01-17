# The Frontend Web App

## About

The frontend is a complete Web Application that serves a user interface and runs on a Node.js backend.

This applications depends on a third-party REST API for some of its calculations, e.g. the Ecommerce API.

## Structure

The frontend project is structured like any [SvelteKit project](https://kit.svelte.dev/docs/project-structure).

## Types

We have setup the project using [TypeScript](https://www.typescriptlang.org/). Any custom types can be defined in [src/lib/types.d.ts](../src/lib/types.d.ts) and imported using 

```javascript
import type { Foo } from '$lib/types';
```

## Data flow

### How products are loaded

1. The available products are currently defined in a JSON filed located at [src/data/products.json](../src/data/products.json). 
2. This data is imported into the [ecommerce/+page.ts](../src/routes/ecommerce/+page.ts) file and made available to [ecommerce/+page.svelte](../src/routes/ecommerce/+page.svelte) component through the data prop. [Read more](https://kit.svelte.dev/docs/load).

### How checkout is called

1. The [ecommerce/+page.svelte](../src/routes/ecommerce/+page.svelte) component has a button `on:click` listener that calls the [api/checkout/+server.ts](../src/routes/api/checkout/+server.ts) server component. 
2. The server component then calls the "third-party" Ecommerce API running on http://localhost:8080 to calculate the total price.

Server components are always run on the backend server - which allows to later add logic such as authentication without exposing it in the client. 