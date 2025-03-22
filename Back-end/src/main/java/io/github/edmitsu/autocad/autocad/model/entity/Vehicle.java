package io.github.edmitsu.autocad.autocad.model.entity;

import io.github.edmitsu.autocad.autocad.model.dto.VehicleDTO;
import io.github.edmitsu.autocad.autocad.model.enums.SellStatus;
import io.github.edmitsu.autocad.autocad.model.enums.TypeVehicle;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String nome;
    private String color;
    private String model;
    private String brand;
    private String category;
    private String year;
    private String mileage;
    private String newOrUsed;
    private Double price;
    private SellStatus sellStatus;
    private TypeVehicle typeVehicle;
    private String description;
    private boolean favorite;
    private boolean ativo;

    public Vehicle(VehicleDTO vehicleDTO) {
        this.nome = vehicleDTO.getNome();
        this.color = vehicleDTO.getColor();
        this.model = vehicleDTO.getModel();
        this.brand = vehicleDTO.getBrand();
        this.category = vehicleDTO.getCategory();
        this.year = vehicleDTO.getYear();
        this.mileage = vehicleDTO.getMileage();
        this.newOrUsed = vehicleDTO.getNewOrUsed();
        this.price = vehicleDTO.getPrice();
        this.sellStatus = SellStatus.valueOf(vehicleDTO.getSellStatus());
        this.typeVehicle = TypeVehicle.valueOf(vehicleDTO.getTypeVehicle());
        this.description = vehicleDTO.getDescription();
        this.favorite = vehicleDTO.isFavorite();
        this.ativo = vehicleDTO.isAtivo();
    }
}
