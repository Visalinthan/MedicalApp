-- Insertion de données pour la table `medical_services`
INSERT INTO `medical_services` (`name`) VALUES
('Consultation générale'),
('Radiologie'),
('Chirurgie'),
('Cardiologie'),
('Ophtalmologie'),
('Pédiatrie'),
    ('Gynécologie'),
('Laboratoire d''analyses médicales'),
('Orthopédie'),
('Psychiatrie');

-- Insertion de données pour la table `equipment`
INSERT INTO `equipment` (`busy`, `name`, `type`) VALUES
(0, 'Équipement 1', 'Type 1'),
(1, 'Équipement 2', 'Type 2'),
(0, 'Équipement 3', 'Type 1'),
(1, 'Équipement 4', 'Type 3');

-- Insertion de données pour la table `medecin`
INSERT INTO `medecin` (`address`, `birthdate`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `role`, `cin`, `rate`) VALUES
('Adresse 1', '1990-01-01', 'medecin1@email.com', 'Médecin', 'Homme', 'Nom 1', 'password1', '123456789', 'Médecin Généraliste', 'CIN123456', 4.5),
('Adresse 2', '1985-03-15', 'medecin2@email.com', 'Docteur', 'Femme', 'Nom 2', 'password2', '987654321', 'Cardiologue', 'CIN654321', 4.8),
('Adresse 3', '1982-07-20', 'medecin3@email.com', 'Dr', 'Homme', 'Nom 3', 'password3', '456789123', 'Chirurgien', 'CIN789456', 4.2);

-- Insertion de données pour la table `patient`
INSERT INTO `patient` (`address`, `birthdate`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `role`) VALUES
('Adresse Patient 1', '1988-05-10', 'patient1@email.com', 'Patient', 'Femme', 'Nom Patient 1', 'password_patient1', '111222333', 'Patient'),
('Adresse Patient 2', '1995-12-22', 'patient2@email.com', 'Patient', 'Homme', 'Nom Patient 2', 'password_patient2', '444555666', 'Patient'),
('Adresse Patient 3', '1980-09-05', 'patient3@email.com', 'Patient', 'Femme', 'Nom Patient 3', 'password_patient3', '777888999', 'Patient');

-- Insertion de données pour la table `appointement`
INSERT INTO `appointement` (`date`, `description`, `hour`, `typofillness`, `medecin_id`, `patient_id`) VALUES
('2023-03-01', 'Consultation de routine', '10:00', 'Grippe', 1, 1),
('2023-03-02', 'Radiographie du genou', '14:30', 'Problème orthopédique', 3, 2),
('2023-03-03', 'Consultation cardiaque', '11:15', 'Palpitations', 2, 3);

-- Insertion de données pour la table `medecin_specialities`
INSERT INTO `medecin_medical_services` (`medecin_id`, `medical_services_id`) VALUES
(1, 1),
(2, 4),
(3, 3);

-- Insertion de données pour la table `medical_file`
INSERT INTO `medical_file` (`patient_id`) VALUES
(1),
(2),
(3);

-- Insertion de données pour la table `medical_services_equipments`
INSERT INTO `medical_services_equipments` (`medical_services_id`, `equipments_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4);
