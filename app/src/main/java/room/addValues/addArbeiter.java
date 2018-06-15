package room.addValues;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "mytablearbeiter")
public class addArbeiter {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "arbeiter")

    public String arbeiterid;
    public String name;

    public addArbeiter(@NonNull String name) {
        this.name = name;
    }

    public String getarbeiterid() {
        return arbeiterid;
    }

    public void setArbeiterid(String arbeiterid) {
        this.arbeiterid = arbeiterid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @NonNull
    public String getArbeiterid() {
        return arbeiterid;
    }


}


