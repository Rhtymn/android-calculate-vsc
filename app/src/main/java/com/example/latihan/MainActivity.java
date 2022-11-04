package com.example.latihan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResult;
    private EditText etWidth;
    private EditText etLength;
    private EditText etHeight;
    private Button btnCalculateVolume;
    private Button btnCalculateSurface;
    private Button btnCalculateCircumference;
    private String KEY_RESULT = "key_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);
        etWidth = findViewById(R.id.et_width);
        etLength = findViewById(R.id.et_length);
        etHeight = findViewById(R.id.et_height);
        btnCalculateVolume = findViewById(R.id.btn_calculate_volume);
        btnCalculateSurface = findViewById(R.id.btn_calculate_surface);
        btnCalculateCircumference = findViewById(R.id.btn_calculate_circumference);

        btnCalculateVolume.setOnClickListener(this);
        btnCalculateSurface.setOnClickListener(this);
        btnCalculateCircumference.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(KEY_RESULT);
            tvResult.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate_volume) {
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (inputLength.isEmpty()) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth) *
                        Double.parseDouble(inputHeight);

                tvResult.setText(String.format("Volume: %s", String.valueOf(volume)));
            }
        } else if (view.getId() == R.id.btn_calculate_surface) {
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (inputLength.isEmpty()) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                Double surface = 2 * (Double.parseDouble(inputHeight)*Double.parseDouble(inputWidth) +
                        Double.parseDouble(inputHeight)*Double.parseDouble(inputLength) +
                        Double.parseDouble(inputWidth)*Double.parseDouble(inputLength));

                tvResult.setText(String.format("Luas Permukaan: %s", String.valueOf(surface)));
            }
        } else if (view.getId() == R.id.btn_calculate_circumference) {
            String inputLength = etLength.getText().toString().trim();
            String inputWidth = etWidth.getText().toString().trim();
            String inputHeight = etHeight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (inputLength.isEmpty()) {
                isEmptyFields = true;
                etLength.setError("Field ini tidak boleh kosong");
            }
            if (inputWidth.isEmpty()) {
                isEmptyFields = true;
                etWidth.setError("Field ini tidak boleh kosong");
            }
            if (inputHeight.isEmpty()) {
                isEmptyFields = true;
                etHeight.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyFields) {
                Double circumference = 4 * (Double.parseDouble(inputHeight) + Double.parseDouble(inputWidth) + Double.parseDouble(inputLength));

                tvResult.setText(String.format("Keliling: %s", String.valueOf(circumference)));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        String calculationResult = tvResult.getText().toString();
        outState.putString(KEY_RESULT, calculationResult);
    }
}