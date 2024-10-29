# Simple Hospital Management Server

## Objective
A Spring Boot application exposing RESTful APIs to manage patients and doctors in a hospital setting.

## Models

### Doctor
- **id** (Long)
- **name** (String)
- **maxPatients** (int)
- **currentPatients** (int)
- **experience** (double)

### Patient
- **id** (Long)
- **name** (String)
- **illnessExperienceRequirement** (double)
- **isCured** (Boolean, initially false)
- **doctors** (ArrayList<Long>)

## API Endpoints

### Doctor Endpoints
- **GET** `/doctors/{doctorId}`: Get a specific doctor.
- **GET** `/doctors`: Get all doctors.
- **POST** `/doctors`: Add a new doctor.
- **DELETE** `/doctors/{doctorId}`: Delete a doctor.

### Patient Endpoints
- **GET** `/patients/{patientId}`: Get a specific patient.
- **GET** `/patients`: Get all patients.
- **POST** `/patients`: Add a new patient.
- **DELETE** `/patients/{patientId}`: Delete a patient.

### Assignment & Release
- **POST** `/assign/{doctorId}`: Assign a doctor to a patient.
- **PUT** `/release/{patientId}`: Mark a patient as cured.

### Welcome Message
- **GET** `/`: Return a welcome message.
