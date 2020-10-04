import { Component, OnInit } from '@angular/core';
import { DisplayService } from 'src/app/Service/display.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { DistributorDto } from 'src/app/dto/distributor-dto';

@Component({
  selector: 'app-display-distributor-details',
  templateUrl: './display-distributor-details.component.html',
  styleUrls: ['./display-distributor-details.component.css']
})
export class DisplayDistributorDetailsComponent implements OnInit {

  service:DisplayService;
  router:Router;
  distributorDto:DistributorDto;

  distributorIds=[10001,10002,10003,10004];
  
  constructor(service:DisplayService,router:Router) { 
    this.service=service;
    this.router=router;
  }

  ngOnInit(): void {
  }

  displayDistributor(form:any){
    let details=form.value;
    let distributorId=details.distributorId;

    let result:Observable<DistributorDto>=this.service.getDistributorByDistributorId(distributorId);
    result.subscribe((distributorDto:DistributorDto)=>{
      this.distributorDto=distributorDto;

    },
    err=>{
    console.log("err="+err);
    } );

  }
}
