/*
package orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.adesso.lklein.geofencing.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class OrmHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME = "datenbankx";
    private static final int DATABASE_VERSION  = 1;

    */
/**
     *  mark class as a data acess object (Dao) to
     *  define databse interactions
     *
     *  accessing data
     *//*

    private Dao<Werte, Integer> werteDao = null;
    private RuntimeExceptionDao<Werte, Integer> runtimedao = null;

    public OrmHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Werte.class);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int j) {
        try{
            TableUtils.dropTable(connectionSource, Werte.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Werte, Integer> getDao() throws SQLException {

        if (werteDao == null){
            werteDao = getDao(Werte.class);
        }
        return werteDao;
    }

    public RuntimeExceptionDao<Werte, Integer> getExeptionDao() {

        if(runtimedao == null){
            runtimedao = getRuntimeExceptionDao(Werte.class);
        }
        return runtimedao;
    }
}
*/
