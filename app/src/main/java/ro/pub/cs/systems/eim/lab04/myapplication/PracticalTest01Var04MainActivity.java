package ro.pub.cs.systems.eim.lab04.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    CheckBox check1;
    CheckBox check2;

    EditText text1;
    EditText text2;

    TextView nonEditable;

    Button display;
    Button nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        text1 = (EditText)findViewById(R.id.editTextTextPersonName);
        text2 = (EditText)findViewById(R.id.group);

        check1 = (CheckBox) findViewById(R.id.checkBox);
        check2 = (CheckBox) findViewById(R.id.checkBox2);

        nonEditable = (TextView) findViewById(R.id.textView2) ;


        StringBuilder sb = new StringBuilder();
        if(check1.isChecked()){
            sb.append(text1.getText());
            sb.append(" ");
        }
        if(check2.isChecked()){
            sb.append(text2.getText());
        }

        nonEditable.setText(sb.toString());

        display = (Button) findViewById(R.id.button2);
        display.setOnClickListener(buttonClickListener);

        nav = (Button) findViewById(R.id.button);
        nav.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("first")) {
               text1.setText(savedInstanceState.getString("first"));
            } else {
                text1.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("right")) {
                text2.setText(savedInstanceState.getString("right"));
            } else {
                text2.setText(String.valueOf(0));
            }
        } else {
           text1.setText(String.valueOf(0));
            text2.setText(String.valueOf(0));
        }

    }


    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            System.out.println("aa" + view.getId());
            switch(view.getId()) {
                case R.id.button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    intent.putExtra("text1", text1.getText().toString());
                    intent.putExtra("text2", text2.getText().toString());
                    startActivity(intent);
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    if (check1.isChecked()) {
                        System.out.println("-" + text1.getText() + "-");
                        if (text1.getText() == null || text1.getText().toString().equals("")) {
                            System.out.println("aici");
                            Toast.makeText(PracticalTest01Var04MainActivity.this, "Eroare 1", Toast.LENGTH_SHORT).show();
                        }
                        sb.append(text1.getText());
                        sb.append(" ");
                    }
                    if (check2.isChecked()) {
                        if (text2.getText() == null || text2.getText().toString().equals("")) {
                            Toast.makeText(PracticalTest01Var04MainActivity.this, "Eroare 2", Toast.LENGTH_SHORT).show();
                        }
                        sb.append(text2.getText());
                    }

                    nonEditable.setText(sb.toString());
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("first", text1.getText().toString());
        savedInstanceState.putString("second", text2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("first")) {
            text1.setText(savedInstanceState.getString("first"));
        } else {
            text1.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("second")) {
            text2.setText(savedInstanceState.getString("second"));
        } else {
            text2.setText(String.valueOf(0));
        }
    }
}