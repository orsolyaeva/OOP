package extra_exercise.interfaces;

public interface IDoctor {
    public abstract void addNewPatient(IPatient patient);
    public abstract boolean treatPatient(IPatient patient);
    public boolean isAvailable();
    public int getNumberCurrentPatients();
}
