import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { ICard } from './model/card.interface'
import { CardRepository } from './domain/card.repository'


@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  cards: any[] = [];

  constructor(private cardRepo: CardRepository) { }

  ngOnInit(): void {
    this.datos();
  }

  private datos(){
    this.cardRepo.listCards('http://localhost:8080/card/consult/all').subscribe(data => this.cards = data);
  }

}
