package sample;

public class VitalData {
    String bp;
    double bmi;
    double feet;
    double inch;
    String pulse;
    String RestingRate;
    String OralTemp;
    double lbs;
    double oz;
    String note;
    String date;

public VitalData(){
        bp = "";
        bmi = 0;
        feet = 0;
        inch = 0;
        pulse = "";
        RestingRate = "";
        OralTemp = "";
        lbs = 0;
        oz = 0;
        note = "";
        date = "";
    }

    public double getBmi() {
        return bmi;
    }

    public double getFeet() {
        return feet;
    }

    public double getInch() {
        return inch;
    }

    public double getLbs() {
        return lbs;
    }

    public double getOz() {
        return oz;
    }

    public String getBp() {
        return bp;
    }

    public String getDate() {
        return date;
    }

    public String getNote() {
        return note;
    }

    public String getOralTemp() {
        return OralTemp;
    }

    public String getRestingRate() {
        return RestingRate;
    }

    public String getPulse() {
        return pulse;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFeet(double feet) {
        this.feet = feet;
    }

    public void setInch(double inch) {
        this.inch = inch;
    }

    public void setLbs(double lbs) {
        this.lbs = lbs;
    }

    public void setOralTemp(String oralTemp) {
        OralTemp = oralTemp;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setOz(double oz) {
        this.oz = oz;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public void setRestingRate(String restingRate) {
        RestingRate = restingRate;
    }
}
