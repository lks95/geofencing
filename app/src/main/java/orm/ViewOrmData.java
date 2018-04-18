package orm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.adesso.lklein.geofencing.R;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class ViewOrmData extends Activity {

    private static final String TAG = "ViewOrmData";
    private ListView listView;
    private int rownumber = -1;
    private Dao<ProjektDetails, Integer> projektdao;
    private List<ProjektDetails> projektliste;

    private OrmHelper2 ormhelper = null;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        listView = (ListView) findViewById(R.id.projekt);

        try {
            projektdao = getHelper().getProjektDao();
            projektliste = projektdao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private OrmHelper2 getHelper() {
        if (ormhelper == null) {
            ormhelper = OpenHelperManager.getHelper(this, OrmHelper2.class);
        }
        return ormhelper;
    }

    private void emptyDatabase() {
        if(projektliste.size() == 0){
            final TextView tv = new TextView(this);
            tv.setTextSize(10);
            tv.setText("No Data found!");
        }

    }


}