import { ITransaction } from "../model/transaction.interface"
import { Observable } from 'rxjs'
import { HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';

@Injectable()
export class TransactionRepository {
    
    constructor(private http: HttpClient){}

    listTransactions(url: string){
        return this.http.get<ITransaction[]>(url);
    }
}