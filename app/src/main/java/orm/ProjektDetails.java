package orm;

import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

public class ProjektDetails implements Serializable {

    @DatabaseField(generatedId = true, columnName = "projekt_details")
    public int projektID;

    @DatabaseField(columnName = "projekt_name")
    public String projektname;

    public ProjektDetails(){

    }

    public ProjektDetails(int projektID, String projektname){
        this.projektID = projektID;
        this.projektname = projektname;
    }
}
