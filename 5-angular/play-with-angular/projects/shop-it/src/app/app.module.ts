import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {CommonModule} from "@angular/common";
import { HeaderComponent } from './components/header/header.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductComponent } from './components/product/product.component';
import { ReviewComponent } from './components/review/review.component';
import { CartBadgeComponent } from './components/cart-badge/cart-badge.component';
import { CartViewComponent } from './components/cart-view/cart-view.component';
import { DxcCardComponent } from './components/dxc-card/dxc-card.component';
import { HighlightDirective } from './directives/highlight.directive';
import { DiscountPipe } from './pipes/discount.pipe';
import {HttpClientModule} from "@angular/common/http";
import { ReviewFormComponent } from './components/review-form/review-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

const routes:Routes=[
  {
    path: '',
    component:HomeComponent
  },
  {
    path: 'products',
    component:ProductListComponent
  },
  {
    path: 'cart',
    component:CartViewComponent
  },
  {
    path:'**',
    component:NotFoundComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProductListComponent,
    ProductComponent,
    ReviewComponent,
    CartBadgeComponent,
    CartViewComponent,
    DxcCardComponent,
    HighlightDirective,
    DiscountPipe,
    ReviewFormComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
