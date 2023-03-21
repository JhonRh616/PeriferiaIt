import { Component, OnInit } from '@angular/core';
import { TransactionRepository } from './domain/transaction.repository';
import { ITransaction } from './model/transaction.interface';
import { Observable } from 'rxjs'

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {

  transactions: ITransaction[] = [];
  observable: Observable<ITransaction> = new Observable;

  constructor(private transactionRepo: TransactionRepository) { }

  ngOnInit(): void {
    this.datos();
  }

  private datos(){
    return this.transactionRepo.listTransactions('http://localhost:8080/transaction/consult/all').subscribe(data => this.transactions = data);
  } 

}
