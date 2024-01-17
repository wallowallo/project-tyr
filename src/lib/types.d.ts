export type Product = {
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