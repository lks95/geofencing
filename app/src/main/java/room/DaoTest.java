package room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Dao;

import java.util.List;

import room.addValues.addArbeiter;
import room.addValues.addprojekt;

//interface for Dao
    @Dao
    public interface DaoTest {

        @Insert
        public void insertprojekt(addprojekt addprojekt);

        @Insert
        public void insertarbeiter(addArbeiter addArbeiter);

        /*@Insert
        public void insertGeofence();*/

        @Query("DELETE FROM mytableprojekt")
        public void deleteAll();


       @Query("SELECT * FROM mytablearbeiter")
        LiveData<List<addArbeiter>> getAllArbeiter();

        @Query("SELECT * FROM mytableprojekt")
        LiveData<List<addprojekt>> getAllProjekte();

    }


