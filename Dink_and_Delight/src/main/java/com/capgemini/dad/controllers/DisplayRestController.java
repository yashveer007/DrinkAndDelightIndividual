package com.capgemini.dad.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.dad.dto.DistributorDetails;
import com.capgemini.dad.dto.GetProductOrder;
import com.capgemini.dad.dto.GetSupplierOrder;
import com.capgemini.dad.dto.SupplierDetails;
import com.capgemini.dad.entity.Distributor;
import com.capgemini.dad.entity.ProductOrder;
import com.capgemini.dad.entity.RawMaterialOrder;
import com.capgemini.dad.entity.Supplier;
import com.capgemini.dad.services.IDisplayService;
import com.capgemini.dad.util.DisplayUtil;

@RequestMapping("/display")
@RestController
@Validated
public class DisplayRestController {
	
	// private static final Logger Log = LoggerFactory.getLogger(DisplayRestController.class);
	 
	 @Autowired
	 private IDisplayService displayService;
	 
    /**
     * fetch Supplier object by supplier id
     *
     * @param supplierId
     * @return Supplier object and response to server
     */
     @GetMapping("/{supplierId}/showsupplierdetails")
     public ResponseEntity<SupplierDetails> showSupplierDetailsById(
             @PathVariable("supplierId") String supplierId) {
    	 
    	 Long longSupplierId=Long.parseLong(supplierId);
    	 
         Supplier supplier = displayService.displaySupplierById(longSupplierId);
         
         SupplierDetails supplierDetails = DisplayUtil.convertToSupplierDetails(supplier);
         ResponseEntity<SupplierDetails> response = new ResponseEntity<>(supplierDetails, HttpStatus.OK);
         return response;
     }
     
     /**
      * fetch Distributor object by distributor id
      *
      * @param distributorId
      * @return Distributor object and response to server
      */
      @GetMapping("/{distributorId}/showdistributordetails")
      public ResponseEntity<DistributorDetails> showDistributorDetailsById(
              @PathVariable("distributorId") String distributorId) {
     	  Long longDistributedId=Long.parseLong(distributorId);
          Distributor distributor = displayService.displayDistributorById(longDistributedId);
          DistributorDetails distributorDetails = DisplayUtil.convertToDistributorDetails(distributor);
          ResponseEntity<DistributorDetails> response = new ResponseEntity<>(distributorDetails, HttpStatus.OK);
          return response;
      }

      /**
       * fetch List of RawMaterialOrder object by supplierId,deliveryStatus,startDate & endDate
       *
       * @param supplierId,deliveryStatus,startDate & startDate
       * @return List of RawMaterialOrder object and response to server
       */
       @PostMapping("/getAllRawMaterialOrder")
       public ResponseEntity<List<RawMaterialOrder>> getAllRawMaterialOrder(
    		   @RequestBody GetSupplierOrder request) {
    	   Long supplierId=request.getSupplierId();
    	  
    	   String deliveryStatus=request.getDeliveryStatus();
    	   LocalDate startDate=request.getStartDate();
    	   LocalDate endDate=request.getEndDate();
    	   
    	   //System.out.println("supplier id-->"+supplierId+"/n deliverystatus --->"+deliveryStatus+"/n startDate--->"+startDate+"/n end Date--->"+endDate);
  
      	   List<RawMaterialOrder> listOfRawMaterialOrder=displayService.getAllRawMaterialOrder(supplierId, deliveryStatus, startDate, endDate);
           ResponseEntity<List<RawMaterialOrder>> response = new ResponseEntity<>(listOfRawMaterialOrder, HttpStatus.OK);
           return response;
       } 
       
       /**
        * fetch List of ProductOrder object by distributorId,deliveryStatus,startDate & startDate
        *
        * @param distributorId,deliveryStatus,startDate & startDate
        * @return List of ProductOrder object and response to server
        */
        
        @PostMapping("/getAllProductOrder")
        public ResponseEntity<List<ProductOrder>> getAllProductOrder(@RequestBody GetProductOrder request) {
        	
       	    Long distributedId=request.getDistributorId();
       	    String deliveryStatus=request.getDeliveryStatus();
       	    LocalDate startDate=request.getStartDate();
       	    LocalDate endDate=request.getEndDate();
       	   // System.out.println("distributed id-->"+distributedId+"/n deliverystatus --->"+deliveryStatus+"/n startDate--->"+startDate+"/n end Date--->"+endDate);
         
       	    List<ProductOrder> listOfProductOrder=displayService.getAllProductOrder(distributedId, deliveryStatus, startDate, endDate);
            ResponseEntity<List<ProductOrder>> response = new ResponseEntity<>(listOfProductOrder, HttpStatus.OK);
            
            return response;
        } 
        
        /**
         * Enter data into Supplier Table
         *
         * @param supplierDetails
         * @return String object and response to server
         */
        @PostMapping("/registerSupplier")
   	 	public ResponseEntity<Supplier> registerSupplier(@RequestBody SupplierDetails request) {
           Supplier supplier=DisplayUtil.convertToSupplier(request);
           supplier = displayService.registerSupplier(supplier);
           ResponseEntity<Supplier> response = new ResponseEntity<>(supplier, HttpStatus.OK);
           return response;
   	    }
        
        /**
         * Enter data into Distributor Table
         *
         * @param distributorDetails
         * @return String object and response to server
         */
        @PostMapping("/registerDistributor")
   	 	public ResponseEntity<Distributor> registerDistributor(@RequestBody DistributorDetails request) {
          
           Distributor distributor=DisplayUtil.convertToDistributor(request);
           
           distributor = displayService.registerDistributor(distributor);
           ResponseEntity<Distributor> response = new ResponseEntity<>(distributor, HttpStatus.OK);
           return response;
   	    }
        
}
