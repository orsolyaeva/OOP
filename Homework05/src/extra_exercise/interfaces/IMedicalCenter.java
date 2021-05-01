package extra_exercise.interfaces;

import extra_exercise.utils.Enums;

import java.util.ArrayList;

public interface IMedicalCenter {
    public abstract void hireDoctor(IDoctor doctor);
    public abstract void fireDoctor(IDoctor doctor);
    public abstract IDoctor assignPatientToADoctor(IPatient patient);
    public abstract ArrayList<IDoctor> getDoctorsByPatientType(Enums.PetType petType);
    public abstract int getNumberOfFreeAppointmentsByPatient(IPatient patient);
    public abstract boolean getAvailabilityByDoctor(IDoctor doctor);

    public int getNumberOfPatient();
    public int getNumberOfDoctors();
    public String getMedCenterInformation();

}
