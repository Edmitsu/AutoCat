package io.github.edmitsu.autocad.autocad.model.repository;

import io.github.edmitsu.autocad.autocad.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
}
