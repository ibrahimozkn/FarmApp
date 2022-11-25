public class FarmWorker extends Employee{

    private int previousFarmName;
    private int workExperience;

    public int getPreviousFarmName() {
        return previousFarmName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setPreviousFarmName(int previousFarmName) {
        this.previousFarmName = previousFarmName;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    //TODO: Do Compare Functions
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public double getSalary() {
        return Payment.grossSalary + (Payment.grossSalary * 0.02 * workExperience);
    }
}
