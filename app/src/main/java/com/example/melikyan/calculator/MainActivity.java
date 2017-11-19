package com.example.melikyan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void one(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"1");
    }

    public void zero(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"0");
    }

    public void two(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"2");
    }

    public void three(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"3");
    }

    public void four(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"4");
    }

    public void five(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"5");
    }

    public void eight(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"8");
    }

    public void seven(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"7");
    }

    public void erase(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(null);
        TextView out=findViewById(R.id.textView);
        out.setText(null);

    }

    public void nine(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"9");
    }

    public void six(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"6");
    }

    public void plus(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"+");
    }

    public void minus(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"-");
    }

    public void multiply(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"*");
    }

    public void dis(View view) {
        EditText num=findViewById(R.id.Input);
        num.setText(num.getText().toString()+"/");
    }

    public void solve(View view) {
        EditText num=findViewById(R.id.Input);
        String expression=num.getText().toString();
        String[] numbers=new String[100];
        int r=0;
        int count=0;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='*'){
                count++;
                numbers[count]="*";
                r=i+1;
                count++;
                continue;
            }
            else if(expression.charAt(i)=='+'){
                count++;
                numbers[count]="+";
                r=i+1;
                count++;
                continue;
            }
            else if(expression.charAt(i)=='-'){
                count++;
                numbers[count]="-";
                r=i+1;
                count++;
                continue;
            }
            else if(expression.charAt(i)=='/'){
                count++;
                numbers[count]="/";
                r=i+1;
                count++;
                continue;
            }else numbers[count]=expression.substring(r,i+1);

        }

        for(int i=0;i<=count;i++){
            String mul="*";
            String dis=getString(R.string.disa);
            if(numbers[i].equals(mul)){
                numbers[i-1]=Integer.parseInt(numbers[i-1])*Integer.parseInt(numbers[i+1])+"";
                for(int r1=i;r1<=count;r1++)
                    numbers[r1]=numbers[r1+2];
                count-=2;
            }
            if(numbers[i].equals(dis)){
                numbers[i-1]=new BigDecimal(Double.parseDouble(numbers[i-1])/Double.parseDouble(numbers[i+1])).setScale(3, RoundingMode.UP).doubleValue()+"";
                for(int r1=i;r1<=count;r1++)
                    numbers[r1]=numbers[r1+2];
                count-=2;
            }
        }
        double x=Double.parseDouble(numbers[0]);
        for(int i=1;i<=count;i++){
            if(numbers[i].equals("+"))
                x+=Double.parseDouble(numbers[i+1]);
            if(numbers[i].equals("-"))
                x-=Double.parseDouble(numbers[i+1]);
        }
        TextView out=findViewById(R.id.textView);
        out.setText(x+"");

    }
}
