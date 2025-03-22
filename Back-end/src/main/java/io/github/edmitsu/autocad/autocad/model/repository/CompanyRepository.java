package io.github.edmitsu.autocad.autocad.model.repository;

import io.github.edmitsu.autocad.autocad.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
