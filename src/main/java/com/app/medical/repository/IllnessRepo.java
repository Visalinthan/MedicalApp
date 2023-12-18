package com.app.medical.repository;

import com.app.medical.model.Ilness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepo extends JpaRepository<Ilness, Long> {
}
