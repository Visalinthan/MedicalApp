package com.app.medical.repository;

import com.app.medical.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepo extends JpaRepository<Salle, Long> {
}
