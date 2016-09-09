package com.example.android.groupradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Initialize Radio Group and attach click handler */
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.clearCheck();

        /* Attach CheckedChangeListener to radio group */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                if(null!=rb && checkedId > -1){
                    Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void onClear(View v) {
        /* Clears all selected radio buttons to default */
        radioGroup.clearCheck();
    }

    public void onSubmit(View view) {
        if(radioGroup.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
            Toast.makeText(MainActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(MainActivity.this, "Select at least 1", Toast.LENGTH_SHORT).show();
    }
}
