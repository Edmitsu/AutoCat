package io.github.edmitsu.autocad.autocad.model.repository;

import io.github.edmitsu.autocad.autocad.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
}
