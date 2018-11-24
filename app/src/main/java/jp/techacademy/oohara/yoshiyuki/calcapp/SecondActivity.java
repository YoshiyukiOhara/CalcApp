package jp.techacademy.oohara.yoshiyuki.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double result = intent.getDoubleExtra("VALUE", 0);

        // 末尾に「.0」があれば削除
        String str = String.valueOf(result);
        if (str.endsWith(".0")) {
            str  = str.substring(0, str.length() - 2);
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(str));
    }
}
