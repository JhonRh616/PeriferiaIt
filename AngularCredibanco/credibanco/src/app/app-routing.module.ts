import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { TransactionComponent } from './transaction/transaction.component'
import { CardComponent } from './card/card.component'

const routes: Routes = [
    {path: 'card', component: CardComponent},
    {path: 'transaction', component: TransactionComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{}