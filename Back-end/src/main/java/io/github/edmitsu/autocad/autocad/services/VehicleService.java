package io.github.edmitsu.autocad.autocad.services;

import io.github.edmitsu.autocad.autocad.model.dto.VehicleDTO;
import io.github.edmitsu.autocad.autocad.model.entity.Vehicle;
import io.github.edmitsu.autocad.autocad.model.enums.SellStatus;
import io.github.edmitsu.autocad.autocad.model.enums.TypeVehicle;
import io.github.edmitsu.autocad.autocad.model.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;


    public Mono<Vehicle> saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle(vehicleDTO);
        return Mono.just(this.vehicleRepository.save(vehicle));
    }

    public Flux<Vehicle> listVehicle() {
        return Flux.fromIterable(this.vehicleRepository.findAll());
    }

    public Mono<Vehicle> getVehicleById(String id) {
        return Mono.just(this.vehicleRepository.findById(UUID.fromString(id)).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado o veículo com o id: " + id)
        ));
    }

    public Mono<Void> updateVehicle(String id, VehicleDTO vehicleDTO) {
        this.vehicleRepository.findById(UUID.fromString(id)).map(vehicle -> {
            vehicle.setNome(vehicleDTO.getNome());
            vehicle.setColor(vehicleDTO.getColor());
            vehicle.setModel(vehicleDTO.getModel());
            vehicle.setBrand(vehicleDTO.getBrand());
            vehicle.setCategory(vehicleDTO.getCategory());
            vehicle.setYear(vehicleDTO.getYear());
            vehicle.setMileage(vehicleDTO.getMileage());
            vehicle.setNewOrUsed(vehicleDTO.getNewOrUsed());
            vehicle.setPrice(vehicleDTO.getPrice());
            vehicle.setSellStatus(SellStatus.toEnum(vehicleDTO.getSellStatus()));
            vehicle.setTypeVehicle(TypeVehicle.toEnum(vehicleDTO.getTypeVehicle()));
            vehicle.setDescription(vehicleDTO.getDescription());
            vehicle.setFavorite(vehicleDTO.isFavorite());
            vehicle.setAtivo(vehicleDTO.isAtivo());
            return this.vehicleRepository.save(vehicle);
        }).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado o veículo com o id: " + id);
        });
        return Mono.empty();
    }

    public Mono<Void> deleteVehicle(String id) {
        this.vehicleRepository.findById(UUID.fromString(id)).map( vehicle ->{
            this.vehicleRepository.delete(vehicle);
            return Mono.empty();
        }).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado o veículo com o id: " + id);
        });
        return Mono.empty();
    }
}
