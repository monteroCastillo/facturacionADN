SELECT PLANTA.NOMBRE, PLANTA.CANTIDAD FROM PLANTA
     INNER JOIN PLANTAPORPROVEEDOR
            ON PLANTA.ID = PLANTAPORPROVEEDOR.ID_PLANTA
                WHERE PLANTAPORPROVEEDOR.ID_PROVEEDOR = :id