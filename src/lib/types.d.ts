export type Product = {
    id: string;
    name: string;
    price: number;
}

export type ProductPageData = {
    products: Product[];
}

export type CheckoutPageData = {
    checkout: string[];
}