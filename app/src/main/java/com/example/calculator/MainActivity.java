package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
private  Calculator calculator;
private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numberId =new int[]{
                R.id.zero,R.id.one,R.id.two,R.id.three,R.id.four,R.id.five,
                R.id.six,R.id.seven,R.id.eight,R.id.nine
        };

        int[] actionId =new int[]{
                R.id.plus,R.id.minus,R.id.multiply,R.id.division,R.id.equals

        };
         //ініциалізація текстового поля
        text=findViewById(R.id.text);
        //ініциалізація калькулятора
        calculator=new Calculator();
        //создаем обработчик для кнопок нажатия и при срабатівании передаем индентификатор кнопки

        View.OnClickListener numberButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumberPress(view.getId());
                //обновляем текст полученій из калькулятора
                text.setText(calculator.getText());
            }
        };

        View.OnClickListener actionButton =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPress(view.getId());
                //обновляем текст полученій из калькулятора
                text.setText(calculator.getText());
            }
        };
        //проходим по масиву, находим по id кнопку и устанавливаем обработчик
        for (int i = 0; i < numberId.length; i++) {
            findViewById(numberId[i]).setOnClickListener(numberButton);
        }

        for (int i = 0; i < actionId.length; i++) {
            findViewById(actionId[i]).setOnClickListener(actionButton);
        }

        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });

    }

}