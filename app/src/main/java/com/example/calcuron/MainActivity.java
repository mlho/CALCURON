package com.example.calcuron;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.calcuron.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private double value1 = Double.NaN;
    private double value2;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.textView.getText().length() > 0){
                    binding.textView.setText(binding.textView.getText().subSequence(0, binding.textView.getText().length() - 1));
                }
            }
        });

        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText("");
                operator = ' ';
            }
        });

        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + ".");
            }
        });

        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "0");
            }
        });

        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "1");
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "2");
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "3");
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "4");
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "5");
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "6");
            }
        });

        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "7");
            }
        });

        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "8");
            }
        });

        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textView.setText(binding.textView.getText() + "9");
            }
        });

//        ### OPERATORS ###

        binding.buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = '+';
                value1 = Double.parseDouble(binding.textView.getText().toString());
                binding.textView.setText(binding.textView.getText() + "+");
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = '-';
                value1 = Double.parseDouble(binding.textView.getText().toString());
                binding.textView.setText(binding.textView.getText() + "-");
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = '*';
                value1 = Double.parseDouble(binding.textView.getText().toString());
                binding.textView.setText(binding.textView.getText() + "*");
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = '/';
                value1 = Double.parseDouble(binding.textView.getText().toString());
                binding.textView.setText(binding.textView.getText() + "/");
            }
        });

        binding.buttonSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = 's';
                value1 = Double.parseDouble(binding.textView.getText().toString());
                binding.textView.setText("√" + binding.textView.getText());
            }
        });

        binding.buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operator = '%';
                value1 = Double.parseDouble(binding.textView.getText().toString());
                calculate();
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    private void calculate(){
        double solution = Double.MAX_VALUE;
        String text = binding.textView.getText().toString();
        if(text.indexOf(operator) > 0){
            value2 = Double.parseDouble(text.substring(text.indexOf(operator) + 1));
        }

        switch(operator){
            case '+':
                solution = value1 + value2;
                break;
            case '-':
                solution = value1 - value2;
                break;
            case '*':
                solution = value1 * value2;
                break;
            case '/':
                solution = value1 / value2;
                break;
            case 's':
                solution = Math.pow(value1, 0.5);
                break;
            case '%':
                solution = value1 / 100;
                break;
            default:
                return;
        }

        binding.textView.setText(Double.toString(solution));
    }
}
