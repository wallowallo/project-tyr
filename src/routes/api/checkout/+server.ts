import { json } from '@sveltejs/kit';

export const POST = async ({request, fetch}) => {
    const data = await request.json();
    const res = await fetch(`http://localhost:8080/api/v1/checkout`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const responseData = await res.json();
    return json(responseData);
}