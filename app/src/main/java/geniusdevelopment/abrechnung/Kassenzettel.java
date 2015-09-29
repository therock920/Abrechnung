package geniusdevelopment.abrechnung;

public class Kassenzettel {
    private String _creator;
    private String _date;
    private String _vendor;
    private double sum;
    public Kassenzettel(String newcreator, String newdate, String newvendor, double newsum)
    {
        this._creator = newcreator;
        this._date = newdate;
        this._vendor = newvendor;
        this.sum = newsum;
    }
    public String getCreator(){
        return this._creator;
    }
    public String getDate(){
        return this._date;
    }
    public String getVendor(){
        return this._vendor;
    }
    public double getSum()
    {
        return this.sum;
    }
    public void setCreator(String newcreator){
        this._creator = newcreator;
    }
    public void setDate(String newdate){
        this._date = newdate;
    }
    public void setVendor(String newvendor){
        this._vendor = newvendor;
    }
    public void setSum(double newsum){
        this.sum = newsum;
    }
}
