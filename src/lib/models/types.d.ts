export type Product = {
    [key: string]: unknown;
    id: string;
    name: string;
    price: number;
}

export type Cart = string[];

export type ProductPageData = {
    products: Product[];
}

export type CheckoutResponse = {
    price: number;
}

export type CartItem = Product & {
    [key: string]: unknown;
    quantity: number;
}