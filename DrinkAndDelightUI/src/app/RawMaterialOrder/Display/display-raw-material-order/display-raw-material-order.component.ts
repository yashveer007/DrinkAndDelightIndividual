import { Component, OnInit } from '@angular/core';
import { DisplayService } from 'src/app/Service/display.service';
import { Router } from '@angular/router';
import { SearchRawMaterialOrder } from 'src/app/Model/search-raw-material-order';
import { Observable } from 'rxjs';
import { RawMaterialOrderDto } from 'src/app/dto/raw-material-order-dto';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-display-raw-material-order',
  templateUrl: './display-raw-material-order.component.html',
  styleUrls: ['./display-raw-material-order.component.css'],
  providers: [DatePipe]
})
export class DisplayRawMaterialOrderComponent implements OnInit {

  service:DisplayService;
  router:Router;

  dateError:boolean=false;
  date:any;
  isTrue:boolean;
  error:Error;


  supplierIds=[101,102,103,104];
  deliveryStatuses=["DISPATCHED","CANCELLED","DELIVERED","BOOKED"];

  constructor(service:DisplayService,router:Router,datePipe:DatePipe) { 
    this.service=service;
    this.router=router;
    this.date=datePipe.transform(new Date(),'yyyy-MM-dd');
   // console.log(this.date);
  }

  ngOnInit(): void {
  }

  rawMaterialOrder:SearchRawMaterialOrder;
  rawMaterialOrderList:RawMaterialOrderDto[]=[];

  displayRawMaterialOrder(form:any){
    let details=form.value;
    let supplierId=details.supplierId;
    let deliveryStatus=details.deliveryStatus;
    let startDate=details.startDate;
    let endDate=details.endDate;
    if(endDate== ''){
      endDate=this.date;
    }

    this.rawMaterialOrder=new SearchRawMaterialOrder();
    this.rawMaterialOrder.supplierId=supplierId;
    this.rawMaterialOrder.deliveryStatus=deliveryStatus;
    this.rawMaterialOrder.startDate=startDate;
    this.rawMaterialOrder.endDate=endDate;
    this.dateError=this.validateDate(startDate,endDate);
    if(this.dateError == true){

      let result:Observable<RawMaterialOrderDto[]>=this.service.getListOfRawMaterialOrder(this.rawMaterialOrder);
      result.subscribe((rawMaterialOrderList:RawMaterialOrderDto[])=>{
        this.rawMaterialOrderList=rawMaterialOrderList;
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
