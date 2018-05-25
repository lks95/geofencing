package room.addValues;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "mytablearbeiter")
public class addArbeiter {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "arbeiter")
 //   private int id;
    private String name;


    public addArbeiter(String name){
        this.name = name;
    }

/*    public addArbeiter(@NonNull int id, String name) {
        this.id = id;
        this.name = name;
    }*/

   /* public int getProjektId() {
        return this.id;
    }*/

    @NonNull
    public String getName() {
        return name;
    }
}

