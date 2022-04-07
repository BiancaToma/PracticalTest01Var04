package ro.pub.cs.systems.eim.lab04.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {


    private TextView text1;
    private TextView text2;
    private Button okButton, cancelButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_button:
                    setResult(RESULT_OK, null);
                    Toast.makeText(PracticalTest01Var04SecondaryActivity.this, "Ok", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    Toast.makeText(PracticalTest01Var04SecondaryActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.number_of_clicks_text_view);
        Intent intent1 = getIntent();
        if (intent1 != null && intent1.getExtras().containsKey("text1")) {
            String text1_s = intent1.getStringExtra("text1");
            text1.setText(text1_s);
            String text2_s = intent1.getStringExtra("text2");
            System.out.println("aaa" + text2_s);
            text2.setText(text2_s);
        }


        okButton = (Button)findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}