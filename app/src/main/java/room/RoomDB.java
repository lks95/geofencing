package room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import room.addValues.addArbeiter;
import room.addValues.addprojekt;


@Database(entities = {addArbeiter.class, addprojekt.class, /*addGeofence.class*/}, version = 1)//addprojekt missing statement
public abstract class RoomDB extends RoomDatabase {

    public abstract DaoTest DaoDao();


    private static RoomDB INSTANCE;

    public static RoomDB getDatabase(final Context context){

        if(INSTANCE == null){
            synchronized (RoomDB.class){

                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDB.class, "mytable")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDataBaseCallback = new RoomDatabase.Callback() {


        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);



            //bei restart daten behalten folgende linie auskommentieren
            new PopulateDbAsync(INSTANCE).execute();
        }


    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{

        private final DaoTest DaoK;

        PopulateDbAsync(RoomDB db){
            DaoK = db.DaoDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            DaoK.deleteAll();

            addArbeiter aa = new addArbeiter( "Hanse");
            DaoK.insertarbeiter(aa);

            aa = new addArbeiter( "Peterle");
            DaoK.insertarbeiter(aa);

            addprojekt ap = new addprojekt("android");
            DaoK.insertprojekt(ap);

            return null;

        }
    }

}
