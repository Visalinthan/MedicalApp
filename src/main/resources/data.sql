-- Insert data into the `role` table
INSERT INTO `role` (`name`)
VALUES
('ROLE_USER'),
('ROLE_MEDICAL'),
('ROLE_ADMIN');

-- Insert data into the `user` table
INSERT INTO `user` (`address`, `birthdate`, `cin`, `email`, `first_name`, `gender`, `last_name`, `password`, `phone`, `role`, `username`)
VALUES
('123 Main St', '1990-01-01', '123456789', 'patient1@example.com', 'John', 'Male', 'Doe', 'password', '1234567890', 'ROLE_USER', 'john_doe_1'),
('456 Oak St', '1985-02-15', '987654321', 'medecin1@example.com', 'Dr. Sarah', 'Female', 'Smith', 'password', '9876543210', 'ROLE_MEDICAL', 'sarah_smith_1'),
('789 Maple St', '1970-05-20', '654321987', 'admin1@example.com', 'Admin', 'Male', 'User', 'password', '6543210987', 'ROLE_ADMIN', 'admin_user_1'),
('321 Elm St', '1988-08-08', '987654322', 'patient2@example.com', 'Jane', 'Female', 'Smith', 'password', '9876543220', 'ROLE_USER', 'jane_smith_2'),
('654 Pine St', '1975-03-25', '654321988', 'medecin2@example.com', 'Dr. James', 'Male', 'Brown', 'password', '6543219880', 'ROLE_MEDICAL', 'james_brown_2'),
('987 Cedar St', '1992-11-12', '123456790', 'admin2@example.com', 'Admin', 'Female', 'Manager', 'password', '1234567901', 'ROLE_ADMIN', 'admin_user_2'),
('555 Birch St', '1980-06-18', '123456791', 'patient3@example.com', 'Emily', 'Female', 'Johnson', 'password', '1234567910', 'ROLE_USER', 'emily_johnson_3'),
('888 Redwood St', '1995-04-04', '987654323', 'medecin3@example.com', 'Dr. Michael', 'Male', 'White', 'password', '9876543230', 'ROLE_MEDICAL', 'michael_white_3'),
('111 Oakwood St', '1973-09-30', '654321989', 'admin3@example.com', 'Admin', 'Male', 'Director', 'password', '6543219890', 'ROLE_ADMIN', 'admin_user_3'),
('999 Maplewood St', '1987-07-15', '123456792', 'patient4@example.com', 'Sophia', 'Female', 'Davis', 'password', '1234567920', 'ROLE_USER', 'sophia_davis_4'),
('222 Cedarwood St', '1993-12-22', '987654324', 'medecin4@example.com', 'Dr. Olivia', 'Female', 'Moore', 'password', '9876543240', 'ROLE_MEDICAL', 'olivia_moore_4'),
('333 Redwoodwood St', '1978-05-09', '654321990', 'admin4@example.com', 'Admin', 'Male', 'Supervisor', 'password', '6543219901', 'ROLE_ADMIN', 'admin_user_4'),
('444 Pine St', '1998-02-28', '123456793', 'patient5@example.com', 'William', 'Male', 'Wilson', 'password', '1234567930', 'ROLE_USER', 'william_wilson_5'),
('555 Elm St', '1981-10-14', '987654325', 'medecin5@example.com', 'Dr. Sophia', 'Female', 'Taylor', 'password', '9876543250', 'ROLE_MEDICAL', 'sophia_taylor_5'),
('666 Birch St', '1976-07-07', '654321991', 'admin5@example.com', 'Admin', 'Male', 'Manager', 'password', '6543219910', 'ROLE_ADMIN', 'admin_user_5');

-- Insert data into the `patient` table
INSERT INTO `patient` (`user_id`)
VALUES
(1),
(4),
(7),
(10),
(13);

-- Insert data into the `specialities` table
INSERT INTO `specialities` (`name`)
VALUES
('Cardiology'),
('Dermatology'),
('Orthopedics'),
('Neurology'),
('Pediatrics');


-- Insert data into the `medecin` table
INSERT INTO `medecin` (`rate`, `user_id`, `specialite_id`)
VALUES
(4.8, 2, 1),
(4.5, 5, 2),
(4.2, 8, 3),
(4.9, 11, 1),
(4.3, 14, 2);



-- Insert data into the `medical_file` table
INSERT INTO `medical_file` (`description`, `patient_id`)
VALUES
('Regular checkup', 1),
('Chronic condition management', 4),
('Orthopedic consultation', 7),
('Pediatric checkup', 10),
('Neurological assessment', 13),
('General health check', 1),
('Skin condition diagnosis', 4),
('Orthopedic follow-up', 7),
('Pediatric vaccination', 10),
('Neurological therapy', 13);

-- Insert data into the `ilness` table
INSERT INTO `ilness` (`name`, `type`)
VALUES
('Headache', 'General'),
('Diabetes', 'Chronic'),
('Fracture', 'Orthopedic'),
('Fever', 'General'),
('Eczema', 'Dermatological'),
('Migraine', 'Neurological'),
('Asthma', 'General'),
('Psoriasis', 'Dermatological'),
('Sprain', 'Orthopedic'),
('Cough', 'General');

-- Insert data into the `medical_file_typofillness` table
INSERT INTO `medical_file_typofillness` (`medical_file_id`, `typofillness_id`)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- Insert data into the `salle` table
INSERT INTO `salle` (`busy`, `type`)
VALUES
(0, 'Consultation room'),
(1, 'Operating room'),
(0, 'Diagnostic room'),
(1, 'Pediatric room'),
(0, 'Neurology room');

-- Insert data into the `equipment` table
INSERT INTO `equipment` (`busy`, `name`, `type`)
VALUES
(0, 'Stethoscope', 'Medical'),
(1, 'X-ray machine', 'Diagnostic'),
(0, 'Blood pressure monitor', 'Medical'),
(1, 'Vaccination kit', 'Pediatric'),
(0, 'Neurological examination tools', 'Medical');

-- Insert data into the `salle_equipments` table
INSERT INTO `salle_equipments` (`salle_id`, `equipments_id`)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 1);

-- Insert data into the `appointement` table
INSERT INTO `appointement` (`date`, `description`, `hour`, `type`, `medecin_id`, `medical_file_id`,`salle_id`, `patient_id` )
VALUES
('2023-01-01', 'Checkup', '10:00 AM', 'General', 2, 1, 1, 1),
('2023-01-02', 'Consultation', '02:30 PM', 'Specialized', 5, 2, 2, 4),
('2023-01-03', 'Follow-up', '11:45 AM', 'General', 8, 3, 3, 7),
('2023-01-04', 'Vaccination', '01:15 PM', 'Pediatric', 11, 4, 4, 10),
('2023-01-05', 'Neurological assessment', '03:30 PM', 'Specialized', 14, 5, 5, 13),
('2023-01-06', 'Regular checkup', '09:00 AM', 'General', 2, 6, 1, 1),
('2023-01-07', 'Skin condition diagnosis', '11:00 AM', 'Dermatology', 5, 7, 2, 4),
('2023-01-08', 'Orthopedic follow-up', '01:30 PM', 'Orthopedic', 11, 8, 3, 7),
('2023-01-09', 'Pediatric vaccination', '10:45 AM', 'Pediatric', 8, 9, 4, 10),
('2023-01-10', 'Neurological therapy', '03:00 PM', 'Specialized', 14, 10, 5, 13);
