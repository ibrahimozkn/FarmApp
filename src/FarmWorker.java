import java.time.LocalDate;

public class FarmWorker extends Employee{

    private String previousFarmName;
    private int workExperience;

    public FarmWorker(int empId, String gender, LocalDate dateOfBirth){
        this.setEmpID(empId);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
    }

    public FarmWorker(int empId, String gender, LocalDate dateOfBirth, String previousFarmName, int workExperience){
        this.setEmpID(empId);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.previousFarmName = previousFarmName;
        this.workExperience = workExperience;
    }

    public String getPreviousFarmName() {
        return previousFarmName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setPreviousFarmName(String previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    //TODO: Do Compare Functions
    @Override
    public int compareTo(Employee employee) {
        if(employee.getSalary() == this.getSalary()){
            return 0;
        }else if(employee.getSalary() > this.getSalary()){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public double getSalary() {
        return Payment.grossSalary + (Payment.grossSalary * 0.02 * workExperience);
    }
}
