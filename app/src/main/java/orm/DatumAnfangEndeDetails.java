package orm;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;
import java.util.Date;

public class DatumAnfangEndeDetails implements Serializable {

    public static final String DATUM = "Datum";
    public static final String PROJEKTID = "Projekt";

    //primary key auto generated as integer
    @DatabaseField(generatedId = true, columnName = DATUM)
    public int datumid;

    @DatabaseField(columnName = "Datum")
    public String Datum;

    @DatabaseField(columnName = "Anfang")
    public int Anfang;

    @DatabaseField(columnName = "Ende")
    public int Ende;

    //foreign key
    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true)
    public ProjektDetails projektDetails;

    //Date test
    @DatabaseField(columnName = "added_date")
    public Date addedDate;

    //default constructor
    public DatumAnfangEndeDetails(){
    }

    public DatumAnfangEndeDetails(String Datum, int Anfang, int Ende, ProjektDetails projektDetails){
        this.Datum = Datum;
        this.Anfang = Anfang;
        this.Ende = Ende;
        this.projektDetails = projektDetails;
    }


}
