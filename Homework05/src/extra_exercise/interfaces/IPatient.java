package extra_exercise.interfaces;

import extra_exercise.utils.Enums;

public interface IPatient {
    public Enums.PetType getPatientType();
    public String getDiseases();
    public Enums.Seriosity getSeriosityOfCase();
}
