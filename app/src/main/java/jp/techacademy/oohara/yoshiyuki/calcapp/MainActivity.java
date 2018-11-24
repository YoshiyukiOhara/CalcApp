package jp.techacademy.oohara.yoshiyuki.calcapp;

import android.util.Log;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        editText1 = (EditText) findViewById(R.id.editText1);

        editText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        // editTextに入力された値をString型に変換
        String str1 = editText1.getText().toString();
        String str2 = editText2.getText().toString();

        // 例外処理があった時にアラートを表示
        try {
            Intent intent = new Intent(this, SecondActivity.class);

            // strをdouble型に変換
            double value1 = Double.parseDouble(str1);
            double value2 = Double.parseDouble(str2);

            // 各ボタンをタップした時の処理
            double result = 0;
            if (v.getId() == R.id.button1) {
                result = value1 + value2;
            } else if (v.getId() == R.id.button2) {
                result = value1 - value2;
            } else if (v.getId() == R.id.button3) {
                result = value1 * value2;
            } else if (v.getId() == R.id.button4) {
                if (value2 == 0){
                    showAlertDialog("0での割り算はできません","他の数値を入力してください");
                    return;
                }
                result = value1 / value2;
            }

            intent.putExtra("VALUE", result);
            startActivity(intent);

        } catch (NumberFormatException e) {
            showAlertDialog("数値が入力されていません","何か数値を入力してください");
        }
    }

    private void showAlertDialog(String title, String message) {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);

        // OKボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("UI_PARTS", "OKボタン");
                    }
                });

        // AlertDialogを作成して表示する
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
