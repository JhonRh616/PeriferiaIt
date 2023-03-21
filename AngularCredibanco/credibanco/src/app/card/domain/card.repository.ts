import { ICard } from "../model/card.interface"
import { Observable } from 'rxjs'
import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';

@Injectable()
export class CardRepository {
    
    constructor(private http: HttpClient){}

    listCards(url: string){
        return this.http.get<ICard[]>(url);
    }
}