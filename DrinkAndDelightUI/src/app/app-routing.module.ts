import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DisplayRawMaterialOrderComponent } from './RawMaterialOrder/Display/display-raw-material-order/display-raw-material-order.component';
import { DisplayProductOrderComponent } from './ProductOrder/Display/display-product-order/display-product-order.component';
import { DisplaySupplierDetailsComponent } from './Supplier/Display/display-supplier-details/display-supplier-details.component';
import { DisplayDistributorDetailsComponent } from './Distributor/Display/display-distributor-details/display-distributor-details.component';


const routes: Routes = [
  {path:'DisplayRawMaterialOrder',component:DisplayRawMaterialOrderComponent},
  {path:'DisplayProductOrder',component:DisplayProductOrderComponent},
  {path:'DisplaySupplierDetails',component:DisplaySupplierDetailsComponent},
  {path:'DisplayDistributorDetails',component:DisplayDistributorDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
