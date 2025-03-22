package io.github.edmitsu.autocad.autocad.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeVehicle {
    CAR("01", "CAR"),
    MOTORCYCLE("02", "MOTORCYCLE");

    private String codigo;
    private String tipo;

    public static TypeVehicle toEnum(String tipo) {
        if( tipo == null ) {
            return null;
        }

        for(TypeVehicle x : TypeVehicle.values()) {
            if(tipo.equals(x.getTipo())) {
                return x;
            }
        }
        throw new IllegalArgumentException( "Id invalido " + tipo );
    }
}
