package room.addValues;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "mytableprojekt")
public class addprojekt {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="id")
  /*  private int id;*/
    private String projekt;


    public addprojekt(String projekt){
        this.projekt = projekt;
    }

   /* public addprojekt(@NonNull int id, String projekt){
         this.id = id;
         this.projekt = projekt;
    }*/

  /*  public int getProjektId(){
        return this.id;
    }*/

    @NonNull
    public String getProjekt() {
        return projekt;
    }
}
