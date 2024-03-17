package com.example.a4islemunihmak;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnDecimal, btnClear;
    private TextView textResult, textAnswer;
    private String firstNumber = "";
    private String operator = "";
    private boolean isOperatorSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textResult = findViewById(R.id.textResult);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnEquals = findViewById(R.id.btnEquals);
        btnDecimal = findViewById(R.id.btnDecimal);

        btnClear = findViewById(R.id.btnClear);
        btn0.setOnClickListener(onClickListener);
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        btnDecimal.setOnClickListener(onClickListener);

        btnAdd.setOnClickListener(onOperatorClickListener);
        btnSubtract.setOnClickListener(onOperatorClickListener);
        btnMultiply.setOnClickListener(onOperatorClickListener);
        btnDivide.setOnClickListener(onOperatorClickListener);
        btnEquals.setOnClickListener(onEqualsClickListener);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            String buttonText = button.getText().toString();
            editText.append(buttonText);
        }
    };

    private View.OnClickListener onOperatorClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            operator = button.getText().toString();
            if (!editText.getText().toString().isEmpty()) {
                firstNumber = editText.getText().toString();
                editText.setText("");
                isOperatorSelected = true;
            }
        }
    };

    private View.OnClickListener onEqualsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isOperatorSelected && !editText.getText().toString().isEmpty()) {
                double result = 0;
                double secondNumber = Double.parseDouble(editText.getText().toString());

                switch (operator) {
                    case "+":
                        result = Double.parseDouble(firstNumber) + secondNumber;
                        break;
                    case "-":
                        result = Double.parseDouble(firstNumber) - secondNumber;
                        break;
                    case "*":
                        result = Double.parseDouble(firstNumber) * secondNumber;
                        break;
                    case "/":
                        result = Double.parseDouble(firstNumber) / secondNumber;
                        break;
                }

                textResult.setText("Result: " + result);
                firstNumber = "";
                operator = "";
                isOperatorSelected = false;
            }
        }
    };

    private void clearAll() {
        editText.setText("");
        textResult.setText("");
        textAnswer.setText("");
        firstNumber = "";
        operator = "";
        isOperatorSelected = false;
    }
}

