package com.example.pr45;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Установка слушателя нажатия для кнопки
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            try {
                // Пример кода, который может вызвать исключение
                int number = Integer.parseInt("Это кнопка"); // Это вызовет NumberFormatException
            } catch (NumberFormatException e) {
                Log.e(TAG, "Кнопка нажата: " + e.getMessage());
            }
        });

        // Установка слушателя для обработки отступов
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "запуск: Действие начато");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "при возобновлении: Активность возобновлена");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Приложение на паузе");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "на паузе: Действие, основанное на");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "при уничтожении: Активность уничтожена");
    }
}
