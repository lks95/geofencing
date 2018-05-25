package room;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Toast;

import com.adesso.lklein.geofencing.R;

import java.util.List;

import room.addValues.addArbeiter;
import room.addValues.addprojekt;

//fuer hauptlayout von roomlist
public class RoomMain extends AppCompatActivity {

    private Model model;
    public static final int NEW_ENTRY_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //set xmlfile
        setContentView(R.layout.roomlistview);

        //set xmlfile
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        RecyclerView view = findViewById(R.id.recyclerview);
        final ListAdapter adapter = new ListAdapter(this);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));

        model = ViewModelProviders.of(this).get(Model.class);

        model.getAllArbeiter().observe(this, new Observer<List<addArbeiter>>() {
            @Override
            public void onChanged(List<addArbeiter> addArbeiters) {
                adapter.setArbeiters(addArbeiters);
            }
        });

        model.getAllProjekte().observe(this, new Observer<List<addprojekt>>() {
            @Override
            public void onChanged(List<addprojekt> addprojekt) {
                adapter.setProjekte(addprojekt);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoomMain.this, addArbeiter.class);
                startActivityForResult(intent, NEW_ENTRY_REQUEST_CODE);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.viewormdata){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onActivitiyResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);


        //goon here

        if(requestCode == NEW_ENTRY_REQUEST_CODE && resultCode == RESULT_OK){
            //getStringExtra + getIntExtra ?
            addArbeiter aa = new addArbeiter(data.getStringExtra(AddValuesActivity.EXTRA_REPLY));
        //    addArbeiter aa = new addArbeiter(data.getIntExtra(AddValuesActivity.EXTRA_REPLY) data.getStringExtra(AddValuesActivity.EXTRA_REPLY));
          addprojekt ap = new addprojekt(data.getStringExtra(AddValuesActivity.EXTRA_REPLY));
            model.insertA(aa);
            model.insertP(ap);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Couldnt save because nothing was typed in",
                    Toast.LENGTH_LONG).show();

        }
    }

}

