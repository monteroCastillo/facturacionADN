INSERT INTO CLIENTE VALUES(111,'Marta','calle 6 #14-78', '5874622', 'marta@gmail.com', 'COMUN');

INSERT INTO FACTURA VALUES(12,111,10.25,'ACTIVA', '2022-06-18');



INSERT INTO EMPLEADO VALUES (123,'Shirley', 'Av 6','4545456','shi@gmail.com','2022-05-22', 'ADMINISTRADOR' );
INSERT INTO EMPLEADO VALUES (124,'luna', 'Av 5', '55555','luna@gmail.com','2022-06-05','VENDEDOR' );


INSERT INTO PLANTA VALUES(12, 'Margarita', 'flor amarilla', '2022-12-05', 50, 12000, 'PLANTASDEFLOR' );
INSERT INTO PLANTA VALUES(13, 'Jazmin', 'Planta con buen olor en las noches', '2022-12-05', 10, 25000, 'PLANTASDEFLOR' );

INSERT INTO PRODUCTO_FACTURAR VALUES(1,12,13,58);
-- insert into producto_facturar( id_factura, id_planta, cantidad ) values(12, 12, 158);
-- insert into producto_facturar( id_factura, id_planta, cantidad ) values(14, 13, 158);

INSERT INTO PROVEEDOR VALUES(22, 'plantas y plantas', 'Av vasquez Cobo', '5656565', 'plantasyplantas.com.co');
INSERT INTO PROVEEDOR VALUES(23, 'Vivero Marinela', 'Calle 23 # 25-46', '2481476', 'viveromarinela.com.co');

INSERT INTO PLANTAPORPROVEEDOR VALUES(1, 22, 12);