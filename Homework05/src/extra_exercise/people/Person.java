package extra_exercise.people;

import extra_exercise.MyDate;
import extra_exercise.utils.Enums;

import java.util.Random;

public abstract class Person {
    protected final String personId;
    protected final Enums.Gender gender;
    protected final MyDate dateOfBirth;
    protected String lastName, firstName, fullName, contact;

    public Person(MyDate dateOfBirth, Enums.Gender gender, String firstName, String lastName, String contact) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.firstName = firstName;
        this.contact = contact;
        this.personId = generatePersonId();
        this.fullName = firstName + " " + lastName;
    }

    private String generatePersonId(){
      StringBuilder personId =  new StringBuilder();
      if(this.gender.equals(Enums.Gender.MALE)){
          personId.append("1");
      }
      else{
          personId.append("2");
      }

      personId.append(String.format("%02d", this.dateOfBirth.getYear() % 100));
      personId.append(String.format("%02d", this.dateOfBirth.getMonth()));
      personId.append(String.format("%02d", this.dateOfBirth.getDay()));
      personId.append(new Random().nextInt(1000000) + 100000);

      return personId.toString();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", fullName='" + fullName + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
