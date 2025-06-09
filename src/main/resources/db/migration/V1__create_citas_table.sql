CREATE  TABLE Cita(
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      fecha DATE NOT NULL,
                      paciente VARCHAR(125) NOT NULL,
                      doctor_id BIGINT NOT NULL,
                      estado VARCHAR(75) NOT NULL,
                      notas VARCHAR(70) NOT NULL,
                      hora DATETIME NOT NULL

)