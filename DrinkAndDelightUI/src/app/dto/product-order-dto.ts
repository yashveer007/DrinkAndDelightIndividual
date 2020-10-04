export class ProductOrderDto {
    
    orderId:Number;
    name:String;
    distributorId:Number;
    quantityValue:Number;
    quantityUnit:String;
    dateOfOrder:Date;
    dateOfDelivery:Date;
    totalPrice:Number;
    pricePerUnit:Number;
    deliveryStatus:String;
    warehouseId:Number;
}
