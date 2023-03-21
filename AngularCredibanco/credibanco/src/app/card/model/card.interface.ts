import {IUser} from "./user.interface"

export interface ICard {
    id: number;
    pan: string;
    state: string;
    type: string;
    validationNumber: number;
    user: IUser;
}