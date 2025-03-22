package io.github.edmitsu.autocad.autocad.controllers;

import io.github.edmitsu.autocad.autocad.model.dto.VehicleDTO;
import io.github.edmitsu.autocad.autocad.model.entity.Vehicle;
import io.github.edmitsu.autocad.autocad.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Mono<Vehicle>> postVehicle(@RequestBody VehicleDTO vehicleDTO) {
        URI uri = UriComponentsBuilder.fromUriString("/api/v1/vehicles").build().toUri();
        return ResponseEntity.created(uri).body(this.vehicleService.saveVehicle(vehicleDTO));
    }

    @GetMapping
    public ResponseEntity<Flux<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(this.vehicleService.listVehicle());
    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<Vehicle>> getVehicleById(@PathVariable String  id) {
        return ResponseEntity.ok(this.vehicleService.getVehicleById(id));
    }

    @PutMapping
    public ResponseEntity<Mono<Void>> updateVehicle(@PathVariable String id, @RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(this.vehicleService.updateVehicle(id, vehicleDTO));
    }

    @DeleteMapping
    public ResponseEntity<Mono<Void>> deleteVehicle(@PathVariable String id) {
        return ResponseEntity.ok(this.vehicleService.deleteVehicle(id));
    }

}
