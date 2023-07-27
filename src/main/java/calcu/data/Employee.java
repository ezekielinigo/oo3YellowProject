package calcu.data;

import javafx.scene.Node;

public class Employee{
    private String name;
    private Node profile;
    private double hours, hourly, monthly; // regular salary
    private double ohours, multiplier, omonthly; // overtime
    private double tax; // tax
    private double sss, phh, pgb; // government deduction
    private double stotal, dtotal, total; // total
    public Employee(String name, double wageHour, double wageMonth, double hours, double ohours, double multiplier) {
        this.name = name;
        this.hourly = wageHour;
        this.monthly = wageMonth;
        this.hours = hours;
        this.ohours = ohours;
        this.multiplier = multiplier;
    }

    /** GETTERS AND SETTERS */
    public void setProfile(Node profile){
        this.profile = profile;
    }
    public Node getProfile(){
        return this.profile;
    }
    public String getName() {
        return name;
    }
    public void setName(String newname){
        this.name = newname;
    }
    public double getHours() {
        return hours;
    }
    public double getHourly() {
        return hourly;
    }
    public void setHourly(double wageHour) {
        this.hourly = wageHour;
        updateMonthly();
        updateDeductions();
        updateTotals();
    }
    public double getMonthly() {
        return monthly;
    }
    public void setMonthly(double wageMonth) {
        this.monthly = wageMonth;
        updateHourly();
        updateDeductions();
        updateTotals();
    }
    public double getOhours(){
        return ohours;
    }
    public void setOhours(double othours){
        this.ohours = othours;
        updateOMonthly();
        updateTotals();
    }
    public double getOmonthly(){
        return omonthly;
    }
    public double getMultiplier(){
        return multiplier;
    }
    public void setMultiplier(double newmultiplier){
        this.multiplier = newmultiplier;
        updateOMonthly();
        updateTotals();
    }
    public double getTax() {
        return tax;
    }
    public double getSss() {
        return sss;
    }
    public double getPhh() {
        return phh;
    }
    public double getPgb() {
        return pgb;
    }
    public double getStotal() {
        return stotal;
    }
    public double getDtotal() {
        return dtotal;
    }
    public double getTotal() {
        return total;
    }

    /** AUTOMATICALLY UPDATE VALUES */
    private void updateMonthly() {
        this.monthly = hourly * hours;
    }
    private void updateHourly() {
        this.hourly = monthly / hours;
    }
    private void updateOMonthly() {
        this.omonthly = hourly * ohours * multiplier;
    }
    private void updateDeductions() {
        this.tax = 0.2 * monthly;
        this.sss = 0.1 * monthly;
        this.phh = 0.05 * monthly;
        this.pgb = 0.03 * monthly;
        // ARBITRARY NUMBERS KAILANGAN PA BAGUHIN
    }
    private void updateTotals() {
        this.stotal = monthly + omonthly;
        this.dtotal = tax + sss + phh + pgb;
        this.total = stotal - dtotal;
    }
}
