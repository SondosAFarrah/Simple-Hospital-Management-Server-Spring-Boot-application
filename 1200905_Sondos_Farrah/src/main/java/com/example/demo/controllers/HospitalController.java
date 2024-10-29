package com.example.demo.controllers;

import com.example.demo.models.Doctor;
import com.example.demo.models.Patient;

import com.example.demo.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
public class HospitalController {
    @Autowired
    HospitalService Hservice;
    @RequestMapping("/doctors")
    public ArrayList<Doctor> getAllDoctors() {
        return Hservice.getDoctorList();
    }
    @RequestMapping("/patients")
    public ArrayList<Patient> getAllPatients() {
        return Hservice.getPatientList();
    }
    @RequestMapping("/patients/{patientId}")
    public ResponseEntity<Object> getPatientById(@PathVariable Long patientId) {
        Patient patient = Hservice.getPatientById(patientId);
        if (patient != null) {
            return ResponseEntity.ok().body(patient);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Patient not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @RequestMapping("/doctors/{doctorId}")
    public ResponseEntity<Object> getDoctorById(@PathVariable Long doctorId) {
        Doctor doctor = Hservice.getDoctorById(doctorId);
        if (doctor != null) {
            return ResponseEntity.ok().body(doctor);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("error", "Doctor not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @RequestMapping(method= RequestMethod.POST, value="/patients")
    public boolean addPatient(@RequestBody Patient patient) {
        return Hservice.addPatientToPatientList(patient);
    }
    @RequestMapping(method= RequestMethod.POST, value="/doctors")
    public boolean addDoctor(@RequestBody Doctor doctor) {
        return Hservice.addDoctorToDoctorList(doctor);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/doctors/{doctorId}")
    public boolean deleteDoctor(@PathVariable  Long doctorId) {
        return Hservice.deleteDoctorToDoctorList(doctorId);
    }
    @RequestMapping(method=RequestMethod.DELETE,value="/patients/{patientId}")
    public boolean deletePatient(@PathVariable  Long patientId) {
        return Hservice.deletePatientToPatientList(patientId);
    }
    @RequestMapping(method= RequestMethod.POST, value="/assign/{doctorId}")
    public boolean assignDoctor(@RequestBody Long patientId ,@PathVariable Long doctorId) {

        return Hservice.assignDoctorToPatient(doctorId,patientId);
    }
    @RequestMapping(method=RequestMethod.PUT,value="/release/{patientId}")
    public boolean release(@PathVariable  Long patientId) {
        return Hservice.releasePatient(patientId);
    }

    //@GetMapping("/")
    @RequestMapping("/")
    public String welcome() {
        return "Welcome, I’m Sondos Farrah";
    }
}
