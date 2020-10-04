import { Component, OnInit } from '@angular/core';
import { DisplayService } from 'src/app/Service/display.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SupplierDto } from 'src/app/dto/supplier-dto';

@Component({
  selector: 'app-display-supplier-details',
  templateUrl: './display-supplier-details.component.html',
  styleUrls: ['./display-supplier-details.component.css']
})
export class DisplaySupplierDetailsComponent implements OnInit {

  supplierIds=[101,102,103,104];
  
  service:DisplayService;
  router:Router;
  supplierDto:SupplierDto;

  constructor(service:DisplayService,router:Router) { 
    this.service=service;
    this.router=router;
  }

  ngOnInit(): void {
  }

  displaySupplier(form:any){
    let details=form.value;
    let supplierId=details.supplierId;

    let result:Observable<SupplierDto>=this.service.getSupplierBySupplierId(supplierId);
    result.subscribe((supplierDto:SupplierDto)=>{
      this.supplierDto=supplierDto;
    },
    err=>{
    console.log("err="+err);
    } );
    // form.reset();
  }

}
