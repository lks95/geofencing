package room;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.adesso.lklein.geofencing.R;

public class AddValuesActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText editText;
    private EditText edittext2;


    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.eingabe_projekt_arbeiter);

        editText = findViewById(R.id.projekt_eingabe);
        edittext2 = findViewById(R.id.mitarbeiter_eingabe);

        final Button button = findViewById(R.id.sendbutton);
        //funktion der eingabe
        button.setOnClickListener(v -> {
            Intent intent = new Intent();

            if (TextUtils.isEmpty(editText.getText()) && TextUtils.isEmpty(edittext2.getText())) {
                setResult(RESULT_CANCELED, intent);
            } else {
                String s = editText.getText().toString();
                intent.putExtra(EXTRA_REPLY, s);
                setResult(RESULT_OK, intent);
            }
            finish();
        });

    }


}
