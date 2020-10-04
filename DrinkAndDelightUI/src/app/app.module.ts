import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { DisplayProductOrderComponent } from './ProductOrder/Display/display-product-order/display-product-order.component';
import { DisplaySupplierDetailsComponent } from './Supplier/Display/display-supplier-details/display-supplier-details.component';
import { DisplayDistributorDetailsComponent } from './Distributor/Display/display-distributor-details/display-distributor-details.component';
import { DisplayService } from './Service/display.service';
import { DisplayRawMaterialOrderComponent } from './RawMaterialOrder/Display/display-raw-material-order/display-raw-material-order.component';

@NgModule({
  declarations: [
    AppComponent,
    DisplayRawMaterialOrderComponent,
    DisplayProductOrderComponent,
    DisplaySupplierDetailsComponent,
    DisplayDistributorDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule
  ],
  providers: [DisplayService],
  bootstrap: [AppComponent]
})
export class AppModule { }
