import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DistributorDto } from '../dto/distributor-dto';
import { ProductOrderDto } from '../dto/product-order-dto';
import { RawMaterialOrderDto } from '../dto/raw-material-order-dto';
import { SupplierDto } from '../dto/supplier-dto';
import { SearchProductOrder } from '../Model/search-product-order';
import { SearchRawMaterialOrder } from '../Model/search-raw-material-order';

@Injectable({
  providedIn: 'root'
})
export class DisplayService {

  client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }

  baseUrl="http://localhost:8087/display/";


  /**
  * 
  * @param supplierId // this method is used to get Supplier details by supplierId
  */
  getSupplierBySupplierId(supplierId:Number):Observable<SupplierDto>{
    let url=this.baseUrl+supplierId+"/showsupplierdetails";
    let result:Observable<SupplierDto>= this.client.get<SupplierDto>(url);
    return result;
  }

  /**
  * 
  * @param distributorId this method is used to get Distributor details by distributorId
  */
  getDistributorByDistributorId(distributorId:Number):Observable<DistributorDto>{
    let url=this.baseUrl+distributorId+"/showdistributordetails";
    let result:Observable<DistributorDto>= this.client.get<DistributorDto>(url);
    return result;
  }

  /**
   * 
   * @param serachRawMaterialOrder  this method is used to get the list of RawMaterial Order 
   */
  getListOfRawMaterialOrder(serachRawMaterialOrder:SearchRawMaterialOrder):Observable<RawMaterialOrderDto[]>{
    let url=this.baseUrl+"getAllRawMaterialOrder";
    let result:Observable<RawMaterialOrderDto[]>=this.client.post<RawMaterialOrderDto[]>(url,serachRawMaterialOrder);
    return result;
    
  }

  /**
   * 
   * @param searchProductOrder this method is used to get the List of Product Order
   */
  getListOfProductOrder(searchProductOrder:SearchProductOrder):Observable<any>{
    let url=this.baseUrl+"getAllProductOrder";
    let result:Observable<any>=this.client.post<any>(url,searchProductOrder);
    return result;
  }

}
