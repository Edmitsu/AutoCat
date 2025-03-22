package io.github.edmitsu.autocad.autocad.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SellStatus {

    DISPONIVEL("01", "DISPONIVEL"),
    VENDIDO("02", "VENDIDO"),
    RESERVADO("03", "RESERVADO");

    private String codigo;
    private String status;

    public static SellStatus toEnum(String status) {
        if( status == null ) {
            return null;
        }

        for(SellStatus x : SellStatus.values()) {
            if(status.equals(x.getStatus())) {
                return x;
            }
        }
        throw new IllegalArgumentException( "Id invalido " + status );
    }
}
