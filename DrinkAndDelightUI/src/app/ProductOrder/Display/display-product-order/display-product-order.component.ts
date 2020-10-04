import { Component, OnInit } from '@angular/core';
import { DisplayService } from 'src/app/Service/display.service';
import { Router } from '@angular/router';
import { SearchProductOrder } from 'src/app/Model/search-product-order';
import { Observable } from 'rxjs';
import { ProductOrderDto } from 'src/app/dto/product-order-dto';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-display-product-order',
  templateUrl: './display-product-order.component.html',
  styleUrls: ['./display-product-order.component.css'],
  providers: [DatePipe]
})
export class DisplayProductOrderComponent implements OnInit {

  service:DisplayService;
  router:Router;
  dateError:boolean=false;
  date:any;

  distributorIds=[10001,10002,10003,10004];
  deliveryStatuses=["DISPATCHED","CANCELLED","DELIVERED","BOOKED"]
  constructor(service:DisplayService,router:Router,datePipe:DatePipe) { 
    this.service=service;
    this.router=router;
    this.date=datePipe.transform(new Date(),'yyyy-MM-dd');
  }

  ngOnInit(): void {
  }

  productOrder:SearchProductOrder;
  productOrderList:ProductOrderDto[]=[];
  error:Error;
  

  displayProductOrder(form:any){
    let details=form.value;

    let distributorId=details.distributorId;
    let deliveryStatus=details.deliveryStatus;
    let startDate=details.startDate;
    let endDate=details.endDate;
    if(endDate== ''){
      endDate=this.date;
    }
    this.productOrder= new SearchProductOrder();
    this.productOrder.distributorId=distributorId;
    this.productOrder.deliveryStatus=deliveryStatus;
    this.productOrder.startDate=startDate;
    this.productOrder.endDate=endDate;

    this.dateError=this.validateDate(startDate,endDate);
    if(this.dateError == true){
      let result:Observable<ProductOrderDto[]>=this.service.getListOfProductOrder(this.productOrder);
      result.subscribe((productOrderList:ProductOrderDto[])=>{
        this.productOrderList=productOrderList;
      },
      err=>{
        this.error=err;
      } );
    }

  }

  validateDate(startDate:Date,endDate:Date):any{
    if(startDate<=endDate){
       return this.dateError=true;
    }
    else{
      alert("Start Date must be Less than or Equal End  date");
      return this.dateError=false;
    }
}

}
