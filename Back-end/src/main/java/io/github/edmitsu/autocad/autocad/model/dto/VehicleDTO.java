package io.github.edmitsu.autocad.autocad.model.dto;

import io.github.edmitsu.autocad.autocad.model.enums.SellStatus;
import io.github.edmitsu.autocad.autocad.model.enums.TypeVehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {
    private String nome;
    private String color;
    private String model;
    private String brand;
    private String category;
    private String year;
    private String mileage;
    private String newOrUsed;
    private Double price;
    private String sellStatus;
    private String typeVehicle;
    private String description;
    private boolean favorite;
    private boolean ativo;
}
