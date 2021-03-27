package extra_exercise;

import extra_exercise.interfaces.IDoctor;
import extra_exercise.interfaces.IMedicalCenter;
import extra_exercise.interfaces.IPatient;
import extra_exercise.people.Veterinarian;
import extra_exercise.utils.Enums;

import java.util.ArrayList;

public class Veterinary implements IMedicalCenter {
    private String name, contact, address;
    private int veterinaryId;
    private final ArrayList<IDoctor> doctors = new ArrayList<>();
    public static int numOfVeterinaries = 0;

    public Veterinary(String address, String contact, String name) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        numOfVeterinaries += 1;
        this.veterinaryId = numOfVeterinaries;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public int getVeterinaryId() {
        return veterinaryId;
    }

    public ArrayList<IDoctor> getDoctors(){
        ArrayList<IDoctor> doctors1 = this.doctors;
        return doctors1;
    }

    @Override
    public void hireDoctor(IDoctor doctor) {
        this.doctors.add(doctor);
    }

    @Override
    public void fireDoctor(IDoctor doctor) {
        doctors.removeIf(doctor1 -> doctor1.equals(doctor));
    }

    @Override
    public IDoctor assignPatientToADoctor(IPatient patient) {
        ArrayList<IDoctor> doctorsByPatientType = getDoctorsByPatientType(patient.getPatientType());
        for(IDoctor doctor: doctorsByPatientType){
            if(doctor.isAvailable()){
                doctor.addNewPatient(patient);
                return doctor;
            }
        }
        System.out.println("\nWe're sorry but unfortunately there are no opportunities to treat your pet.");
        return null;
    }

    @Override
    public ArrayList<IDoctor> getDoctorsByPatientType(Enums.PetType petType) {
        ArrayList<IDoctor> doctorsByPatientType = new ArrayList<>();
        for(IDoctor doctor:doctors) {
            if(doctor instanceof Veterinarian){
                if(((Veterinarian) doctor).getSpeciality().equals(petType)){
                    doctorsByPatientType.add(doctor);
                }
            }
        }
        return doctorsByPatientType;
    }

    @Override
    public int getNumberOfFreeAppointmentsByPatient(IPatient patient) {
        int numberAppointments = 0;
        System.out.println("\nVeterinary " + this.name + ":");
        ArrayList<IDoctor> doctorsByPatientType = getDoctorsByPatientType(patient.getPatientType());
        for(IDoctor doctor:doctorsByPatientType){
            if(doctor.isAvailable()){
                System.out.println(doctor);
                numberAppointments += Veterinarian.MAX_PATIENTS_PER_DAY - doctor.getNumberCurrentPatients();
            }
        }

        if(numberAppointments == 0){
            System.out.println("\tWe are terribly sorry but right now we can not offer any free appointment for your pet!");
        }
        return numberAppointments;
    }

    @Override
    public boolean getAvailabilityByDoctor(IDoctor doctor) {
        return doctor.isAvailable();
    }

    @Override
    public int getNumberOfPatient() {
        int numPatients = 0;
        for(IDoctor doctor:doctors){
            numPatients += doctor.getNumberCurrentPatients();
        }
        return numPatients;
    }

    @Override
    public int getNumberOfDoctors() {
        return doctors.size();
    }

    @Override
    public String getMedCenterInformation(){
        StringBuilder veterinary = new StringBuilder();
        veterinary.append(this.name + " veterinary");
        veterinary.append("\n\t- Address: " + this.address);
        veterinary.append("\n\t- Contact: " + this.contact);
        veterinary.append("\n\t- Number of doctors: " + this.getNumberOfDoctors());
        veterinary.append("\n\t- Number of current patients: " + this.getNumberOfPatient() + "\n");
        return veterinary.toString();
    }

    @Override
    public String toString() {
        return getMedCenterInformation();
    }
}
