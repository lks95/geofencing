package orm;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * in this class is the run
 * and
 * create config files
 */

public class DatabaseConfig extends OrmLiteConfigUtil {

    private static final Class<?> [] classes = new Class[]{
            AddActivityProjekt.class, DatumAnfangEndeDetails.class};

    public static void main(String[]args) throws SQLException, IOException {

        //
        writeConfigFile(new File("C:/Users/lklein/geofencing/src/main/res/raw/ormlite_config.txt"));
    }


}
