package calcu.data;

import calcu.calcu.peopleSegment;
import javafx.scene.Node;

public class Employee{
    private String name, note, insuranceType;
    private peopleSegment profile;
    private double hourly, hours, monthly; // regular salary
    private double multiplier, ohours, totalSalary; // overtime
    private double incomeTax, totalTax; // tax
    private double insurance, phil, pgb; // government deductions
    private double netSalary; // total
    public Employee(String name) {
        this.name = name;
    }

    /** GETTERS AND SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getHourlyRate() {
        return hourly;
    }

    public void setHourlyRate(double hourly) {
        this.hourly = hourly;
    }

    public double getMonthlySalary() {
        return monthly;
    }

    public void setMonthlySalary(double monthly) {
        this.monthly = monthly;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getOvertimeHours() {
        return ohours;
    }

    public void setOvertimeHours(double ohours) {
        this.ohours = ohours;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public peopleSegment getProfile() {
        return profile;
    }

    public void setProfile(peopleSegment profile) {
        this.profile = profile;
    }
    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType){
        this.insuranceType = insuranceType;
    }

    public double getPgb() {
        return pgb;
    }

    public void setPgb(double pgb) {
        this.pgb = pgb;
    }

    public double getPhil() {
        return phil;
    }

    public void setPhil(double phil) {
        this.phil = phil;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
}
