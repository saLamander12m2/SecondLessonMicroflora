package com.msaggik.secondlessonmicroflora;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // поля
    private TextView output;
    private Button button;
    private int count = 0;
    private int preCount = 0;



    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Старт активности", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Активность доступна для взаимодействия", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Активность не доступна для взаимодействия", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Активность остановлена и пропала с экрана", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Активность уничтожена", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Активность создана", Toast.LENGTH_SHORT).show();


        output = findViewById(R.id.output);
        button = findViewById(R.id.button);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0);
            output.setText("" + count);
        }
            button.setOnClickListener(view -> output.setText("" + countFibonacci()));

    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    private int countFibonacci() {
        if (count == 0 && preCount == 0) {
            count = 1; preCount = 0;
        } else {
            int pre = count;
            count = count + preCount;
            preCount = pre;
        }
        return count;
    }
}