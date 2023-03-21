import { ICard } from "src/app/card/model/card.interface";

export interface ITransaction{
    id: number;
    address: string;
    referenceNumber: string;
    totalPurchase: number;
    date: string;
    status: string;
    card: ICard;
}