package room.addValues;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "mytableprojekt")
public class addprojekt {

    @NonNull
    @ColumnInfo(name="id")
    @PrimaryKey

    public String id;
    public String projekt;

    public addprojekt(@NonNull String projekt){
        this.projekt = projekt;
    }

    public String getid(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getProjekt(){
        return projekt;
    }

    public void setProjekt(String projekt){
        this.projekt = projekt;
    }
}
