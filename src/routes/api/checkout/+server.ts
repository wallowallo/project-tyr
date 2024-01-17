import type { Cart, CheckoutResponse } from '$lib/types';
import { json } from '@sveltejs/kit';

/**
 * Call Ecommerce API to calculate price of cart.
 *  
 * @returns {CheckoutResponse} Calculated price 
 */
export const POST = async ({request, fetch}) => {
    const data: Cart = await request.json();
    const res = await fetch(`http://localhost:8080/api/v1/checkout`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const responseData: CheckoutResponse = await res.json();
    return json(responseData);
}