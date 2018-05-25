package room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import room.addValues.addArbeiter;
import room.addValues.addprojekt;

public class Model extends AndroidViewModel{

    private Repository r;
    private LiveData<List<addArbeiter>> mAllArbeiter;
    private LiveData<List<addprojekt>> mAllProjekte;

    public Model(Application application) {
        super(application);
        r = new Repository(application);
      /*  mAllArbeiter = r.getAllArbeiter();
        mAllProjekte = r.getAllProjekte();*/
    }

    LiveData<List<addArbeiter>> getAllArbeiter(){
        return mAllArbeiter;
    }

    LiveData<List<addprojekt>> getAllProjekte(){
        return mAllProjekte;
    }

    public void insertA(addArbeiter addArbeiter){
        r.insertarbeiter(addArbeiter);
    }

    public void insertP(addprojekt addprojekt){
        r.insertprojekt(addprojekt);
    }
}
