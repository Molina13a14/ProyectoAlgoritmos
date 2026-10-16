/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_algoritmos;

import java.util.Scanner;

/**
 *
 * @author molin
 */
public class programa {
    
     public static void VentasFacturacion(){
        Scanner teclado = new Scanner (System.in);
        
       int totalventas = 0;
       int totalproductos = 0;
       double totalvendido = 0;
       int ventasefectivo = 0;
       int ventastarjeta = 0;
       int ventastransferencia = 0;
       int productos;
       int opcion;
       double subtotal = 0;
       int unidades = 0;
       int i;
       double descuento;
       double porcentaje;
       double montodescuento;
       double IVA;
       double totaldescuento;
       double total;
       double subtotalproducto;
       String nombre = null;
       double precio = 0;
       int cantidad = 0;
       String codigo = null;
       int forma = 3;
       double recibido = 0;
       double vuelto = 0;
       int codigotarjeta;
       int codigotransferencia;
       double mayorventa = 0;
       double menorventa = 0;
       double promedioventas;
       int confirmar;
       
       
       
       do{
           System.out.println(" MENU PRINCIPAL \n" );
           System.out.println(" 1. Registrar una venta \n");
           System.out.println(" 2. Consutar caja \n");
           System.out.println(" 3. Mostrar estadisticas \n");
           System.out.println(" 4. Salir \n");
           opcion = teclado.nextInt();
           
           
           switch (opcion){
               case 1:
                   System.out.println(" Ingrese la cantidad de productos que tendra la compra: ");
                   productos = teclado.nextInt();
                   
                   while (productos <= 0){
                       System.out.println(" No ha ingresado la cantidad de productos ");
                       System.out.println(" Ingrese nuevamente la cantidad de productos ");
                       productos = teclado.nextInt();
                   }
                   
                   
                  for (i = 1; i <= productos; i ++){
                     System.out.println(" PRODUCTOS " + i + " de " + productos + " : ");
    
                      System.out.println("Codigo: ");
                      codigo = teclado.next();
    
                      System.out.println("Nombre: ");
                      nombre = teclado.next();
     
                      System.out.println("Precio: Q");
                      precio = teclado.nextDouble();
    
               while (precio <= 0){
                System.out.println("No ha ingresado ningun precio. Ingrese de nuevo el precio: ");
                precio = teclado.nextDouble();
              }
    
               System.out.println("Cantidad: ");
               cantidad = teclado.nextInt();
    
              while (cantidad <= 0){
              System.out.println("No ha ingresado ninguna cantidad. Ingrese de nuevo la cantidad: ");
              cantidad = teclado.nextInt();
            }
    
            subtotalproducto = cantidad * precio;
            subtotal += subtotalproducto;
            unidades += cantidad;
    
            System.out.println("Subtotal del producto Q " + subtotalproducto);
    
           
         }
                   
           //Descuento segun el subtotral de la compra
           if (subtotal < 200 ){
               porcentaje = 0;
               System.out.println("No tiene ningun descuento");
           }
           else if(subtotal < 500){
               porcentaje = 0.05;
               System.out.println("Tiene un 5% de descuento.");
           }
           else if (subtotal < 1000){
               porcentaje = 0.08;
               System.out.println("Tiene un 8% de descuento.");
           }
           else{
               porcentaje = 0.10;
           System.out.println("Tiene un 10% de descuento.");
           }
           descuento = subtotal * porcentaje;
           montodescuento = subtotal - descuento;
           
           IVA = montodescuento * 0.12;
           
           totaldescuento = montodescuento + IVA;
           total = totaldescuento;
           
           
                   
           //Formas de pago
           System.out.println("CUAL ES LA FORMA DE PAGO.");
           System.out.println("1. Efectivo \n");
           System.out.println("2. Tarjeta \n");
           System.out.println("3. Transferencia \n");
           forma = teclado.nextInt();
           
          
           
           switch (forma){
               case 1:
                   System.out.println("EFECTIVO");
                  System.out.println("Ingrese el dinero recibido.");
                   recibido = teclado.nextDouble();
                   
                   while (recibido < total){
                       System.out.println("El efectivo no es suficiente ");
                       System.out.println("Ingrese de nuevo el dinero.");
                       recibido = teclado.nextDouble();
                       
                   }
                   
                   vuelto = (recibido - total);
                   ventasefectivo++;
                   
                   System.out.println("Efectivo recibido: Q" + recibido);
                   System.out.println("Cambio: Q" + vuelto);
                   
                   break;
                   
               case 2:
                   System.out.println("TARJETA");
                   System.out.println("Ingrese el codigo de la tarjeta.");
                   codigotarjeta = teclado.nextInt();
                   ventastarjeta++;
                   
                   break;
                   
               case 3: 
                   System.out.println("TRANSFERENCIA");
                   System.out.println("Ingrese el codigo de transferencia.");
                   codigotransferencia = teclado.nextInt();
                   ventastransferencia++;
                  
                   break;
                   
          
           }
           //Resumen de la venta
                   System.out.println(" RESUMEN DE LA VENTA");
                   System.out.println("Cantidad de productos: \n" + unidades);
                   System.out.println("Subtotal: Q \n" + subtotal);
                   System.out.println("Descuento: Q \n" + descuento);
                   System.out.println("IVA: Q \n" + IVA);
                   System.out.println("Total a pagar: Q \n" +total);
                   System.out.println("Forma de pago: \n" + forma);
                   if(forma == 1){
                       System.out.println("Efectivo recibido \n" + recibido);
                       System.out.println("cambio \n" + vuelto);
                   }
                   
                   //actulizacion de datos
                 
                   
                   if (totalventas == 1){
                       totalventas++;
                       totalventas--;
                   }else{
                       if(total > mayorventa){  
                           mayorventa = total;
                       }
                       if (total < menorventa){
                           menorventa = total;
                       }
                   }
                    totalventas++;
                   totalproductos+= unidades;
                   totalvendido+= total;
                   
                   break;
           
               case 2:     
                   //Consultar caja
                   System.out.println("  CONSULTAR CAJA  ");
                   System.out.println("total de ventas realizadas: \n" + totalventas);
                   System.out.println("total de productos vendidos: \n" + totalproductos);
                   System.out.println("total vendido: \n" + totalvendido);
                   System.out.println("total de ventas en efectivo: \n" + ventasefectivo);
                   System.out.println("total de ventas con tarjeta: \n" + ventastarjeta);
                   System.out.println("total de ventas con transferencia: \n" + ventastransferencia);
                   break;
                   
               case 3:
                   //Estadisticas
                   if ( totalventas == 0){
                       System.out.println("No existe ninguna venta registrada");
                   }else{
                       System.out.println(" ESTADISTICAS  ");
                       System.out.println(" Numero total de ventas: \n" + totalventas );
                       System.out.println(" Cantidad de productos vendidos: \n" + totalproductos);
                       System.out.println(" total de dinero vendido: \n" + totalvendido);
                       
                       promedioventas = totalvendido/totalventas;
                       System.out.println(" Promedio de dinero de venta: \n" + promedioventas);
                       System.out.println(" Cantidad de formas de pago: 3 \n" );
                       System.out.println(" Venta de mayor valor: \n" + mayorventa);
                       System.out.println(" Venta de menor valor: \n" + menorventa); 
                   }
                   break;
               case 4:{
                   System.out.println(" SALIR ");
                   System.out.println(" ¿Seguro que desea salir? ");
                   System.out.println(" 1. SI");
                   System.out.println(" 2. NO");
                   confirmar = teclado.nextInt();
                   
                   if (confirmar == 1){
                       System.out.println(" Saliendo del sistema...");
                   }else{
                       opcion = 0;
                       System.out.println(" Regresando al Menu principal...");
                   }
               }
         }
          
           
       }while (opcion != 4);
       } 
}
