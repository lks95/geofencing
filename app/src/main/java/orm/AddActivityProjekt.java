package orm;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.adesso.lklein.geofencing.R;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

public class AddActivityProjekt extends Activity implements OnClickListener {


    private OrmHelper2 databaseHelper = null;

    private EditText projekt_name_edit, address_edit;
    private Button reset_btn, submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addactivityprojekt);

        projekt_name_edit = (EditText) findViewById(R.id.projekt_name);
        address_edit = (EditText) findViewById(R.id.address_et);
        reset_btn = (Button) findViewById(R.id.reset_btn);
        submit_btn = (Button) findViewById(R.id.submit_btn);

        reset_btn.setOnClickListener(this);
        submit_btn.setOnClickListener(this);
    }

    public OrmHelper2 getHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this,OrmHelper2.class);
        }
        return databaseHelper;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

    @Override
    public void onClick(View v) {

        if(v == submit_btn)
        {

            if(projekt_name_edit.getText().toString().trim().length() > 0 &&
                    address_edit.getText().toString().trim().length() > 0)
            {

                final ProjektDetails projektDetails = new ProjektDetails();

                projektDetails.projektname = projekt_name_edit.getText().toString();
                projektDetails.address = address_edit.getText().toString();

                try {
                    // This is how, a reference of DAO object can be done
                    final Dao<ProjektDetails, Integer> techerDao = getHelper().getProjektDao();

                    //This is the way to insert data into a database table
                    techerDao.create(projektDetails);
                    reset();
                    showDialog();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            else
            {
                showMessageDialog("All fields are mandatory!");
            }
        }
        else if(v == reset_btn)
        {
            reset();
        }
    }

    private void showMessageDialog(final String message)
    {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    // Clear the entered text
    private void reset()
    {
        projekt_name_edit.setText("");
        address_edit.setText("");
    }

    private void showDialog()
    {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        alertDialogBuilder.setMessage("Project added successfully !!");
        alertDialogBuilder.setPositiveButton("Add More",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //finish();
                    }
                });


        alertDialogBuilder.setNegativeButton("View Records",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Overview not created yet
                        Intent negativeActivity = new Intent(getApplicationContext(), ViewOrmData.class);
                        startActivity(negativeActivity);
                        finish();
                    }
                });


        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}