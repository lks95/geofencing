package orm;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * in this class is the run
 * and
 * create config files
 */

public class DatabaseConfig extends OrmLiteConfigUtil {

    private static final Class<?> [] classes = new Class[]{Werte.class};

    public static void main(String[]args) throws SQLException, IOException {

        //
        writeConfigFile("ormlite_config.txt", classes);
    }


}
