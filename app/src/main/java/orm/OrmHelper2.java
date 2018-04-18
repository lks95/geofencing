package orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.adesso.lklein.geofencing.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class OrmHelper2 extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "datenbankx";
    private static final int DATABASE_VERSION  = 1;


/**
 *  mark class as a data acess object (Dao) to
 *  define databse interactions
 *
 *  accessing data
 */

    private Dao<ProjektDetails, Integer> ProjektDao = null;
    private Dao<DatumAnfangEndeDetails, Integer> DatumDao = null;



    public OrmHelper2(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        //create tables
        try{
            TableUtils.createTable(connectionSource, ProjektDetails.class);
            TableUtils.createTable(connectionSource, DatumAnfangEndeDetails.class);

        } catch (SQLException e){
            Log.e(OrmHelper2.class.getName(), "Unable to create Database");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int old, int new1) {

        try{
            TableUtils.dropTable(connectionSource, ProjektDetails.class, true);
            TableUtils.dropTable(connectionSource, DatumAnfangEndeDetails.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch(SQLException e){
            Log.e(OrmHelper2.class.getName(), "Unable to upgrade Database from Version " +old + " to " + new1, e);
        }

    }

    //per getdao: insert (addData bei SQLite), delete, read, update

    public Dao<ProjektDetails, Integer> getProjektDao() throws SQLException {

        if (ProjektDao == null){
            ProjektDao = getDao(ProjektDetails.class);
        }
        return ProjektDao;
    }

    public Dao<DatumAnfangEndeDetails, Integer> getDatumDao() throws SQLException {

        if(DatumDao == null){
            DatumDao = getDao(DatumAnfangEndeDetails.class);
        }
        return DatumDao;
    }
}
