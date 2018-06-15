package room;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import room.addValues.addArbeiter;
import room.addValues.addprojekt;

public class Repository {

    private DaoTest mDao;

    private LiveData<List<addArbeiter>> allArbeiter;
    private LiveData<List<addprojekt>> allProjekte;

    Repository(Application App){
        RoomDB db = RoomDB.getDatabase(App);
        mDao = db.DaoDao();

        allArbeiter = mDao.getAllArbeiter();
        allProjekte = mDao.getAllProjekte();

    }

    LiveData<List<addArbeiter>> getAllArbeiter(){
        return allArbeiter;
    }

    LiveData<List<addprojekt>> getAllProjekte(){
        return allProjekte;
    }

    public void insertarbeiter(addArbeiter arbeiter){
        new insertAsyncTask(mDao).execute(arbeiter);
    }

     public void insertprojekt(addprojekt projekt){
        new insertAsyncTask(mDao).execute ((Runnable) projekt);
    }



    private static class insertAsyncTask extends AsyncTask<addArbeiter, Void, Void>{

        private DaoTest mAsyncTaskDao;

        insertAsyncTask(DaoTest dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final addArbeiter... addArbeiters) {
            mAsyncTaskDao.insertarbeiter(addArbeiters[0]);
            return null;
        }
    }

}

