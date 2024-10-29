# Simple Hospital Management Server

## Objective
This is a Spring Boot application that exposes RESTful APIs for managing patients and doctors in a hospital setting. It allows for the addition, retrieval, assignment, and deletion of doctors and patients.

## Models

### Doctor
- **id** (Long): Unique identifier for the doctor.
- **name** (String): Name of the doctor.
- **maxPatients** (int): Maximum number of patients the doctor can handle.
- **currentPatients** (int): Current number of patients assigned to the doctor.
- **experience** (double): Years of experience the doctor has.

### Patient
- **id** (Long): Unique identifier for the patient.
- **name** (String): Name of the patient.
- **illnessExperienceRequirement** (double): Minimum experience required from a doctor to treat this patient.
- **isCured** (Boolean): Indicates if the patient has been cured (initially set to false).
- **doctors** (ArrayList<Long>): List of doctor IDs assigned to the patient.

## API Endpoints

### Doctor Endpoints
- **GET** `/doctors/{doctorId}`: Retrieve information for a specific doctor.
- **GET** `/doctors`: Retrieve information for all doctors.
- **POST** `/doctors`: Add a new doctor.
- **DELETE** `/doctors/{doctorId}`: Delete a specific doctor.

### Patient Endpoints
- **GET** `/patients/{patientId}`: Retrieve information for a specific patient.
- **GET** `/patients`: Retrieve information for all patients.
- **POST** `/patients`: Add a new patient.
- **DELETE** `/patients/{patientId}`: Delete a specific patient.

### Assignment Endpoint
- **POST** `/assign/{doctorId}`: Assign a doctor to a patient if the doctor's experience meets or exceeds the patient's illness experience requirement and the doctor is not fully booked.  
  *Request Body:*
  ```json
  {
    "patientId": Long
  }
