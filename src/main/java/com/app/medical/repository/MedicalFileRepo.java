package com.app.medical.repository;




import com.app.medical.model.MedicalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Map;

@Repository
public interface MedicalFileRepo extends JpaRepository<MedicalFile, Long> {


}