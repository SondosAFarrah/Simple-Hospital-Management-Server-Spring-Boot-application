package com.example.demo.services;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;
import com.example.demo.models.Patient;
import com.example.demo.models.Doctor;
@Service
public class HospitalService {

    private ArrayList<Patient> patientList= new
            ArrayList<Patient>(Arrays.asList(
            new Patient(1L, "Ayham Hashesh", 10.5, false, new ArrayList<Long>(Arrays.asList(101L, 102L))),
            new Patient(2L, "Rajaie Imseeh", 8.0, true, new ArrayList<Long>(Arrays.asList(101L)))
    ));
    private ArrayList<Doctor> doctorList = new ArrayList<Doctor>(Arrays.asList(
            new Doctor(101L, "Dr. Sondos Farrah", 10, 0, 15.0),
            new Doctor(102L, "Dr. Ashraf System", 8, 0, 12.5)
    ));

    public ArrayList<Patient> getPatientList() {
        return this.patientList;
    }
    public ArrayList<Doctor> getDoctorList() {
        return this.doctorList;
    }
    public Patient getPatientById(Long id) {
        for (Patient patient : patientList) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public Doctor getDoctorById(Long id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }
    public boolean addPatientToPatientList (Patient patient) {
        return patientList.add(patient);
    }
    public boolean addDoctorToDoctorList (Doctor doctor ) {
        return doctorList.add(doctor);
    }

    public boolean deleteDoctorToDoctorList (Long id) {

        for (Doctor doctor : doctorList) {
            if (doctor.getId().equals(id) ) {

                doctorList.remove(doctor);
                return true;
            }
        }

        return false;
    }
    public boolean deletePatientToPatientList (Long id) {

        for (Patient patient : patientList) {
            if (patient.getId().equals(id) ) {
                patientList.remove(patient);
                return true;
            }
        }

        return false;
    }

    public boolean assignDoctorToPatient(Long doctorId, Long patientId) {
        Doctor doctor = getDoctorById(doctorId);
        Patient patient = getPatientById(patientId);

        if (doctor != null && patient != null) {
            double doctorExperience = doctor.getExperience();
            double illnessExperienceRequirement = patient.getIllnessExperienceRequirement();

            if (doctorExperience >= illnessExperienceRequirement && !doctor.isFullyBooked()) {
                doctor.setCurrentPatients(doctor.getCurrentPatients()+1);
                patient.getDoctors().add(doctorId);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean releasePatient(Long patientId) {
        Patient patient = getPatientById(patientId);

        if (patient != null) {
            patient.setIsCured(true);
            patient.getDoctors().clear();

            return true;
        } else {
            return false;
        }
    }



}
