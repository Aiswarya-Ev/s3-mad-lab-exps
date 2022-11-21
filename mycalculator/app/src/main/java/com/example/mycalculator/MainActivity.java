package com.example.mycalculator;

import static com.example.mycalculator.R.id.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(edittext);
        display.setShowSoftInputOnFocus(false);
    }
    private void updatestr(String strToadd)
    {
        String oldstr =display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftstr =oldstr.substring(0 ,cursorPos);
        String rightstr =oldstr.substring(cursorPos);
        display.setText(String.format("%s%s%s",leftstr,strToadd,rightstr));
        display.setSelection(cursorPos+1);
    }
    public void zero_btn(View view){
    updatestr("0");f=1;
    }
    public void cancel_btn(View view){
        int cursorPos =display.getSelectionStart();
        int textlen = display.getText().length();
        if(cursorPos!=0 && textlen!=0){
            SpannableStringBuilder selection=(SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public int evaluate (String exp)
    {
        Stack<Integer> operands = new Stack<>();  //Operand stack
        Stack<Character> operations = new Stack<>();  //Operator stack
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isDigit(c))   //check if it is number
            {
                //Entry is Digit, and it could be greater than a one-digit number
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < exp.length()) {
                        c = exp.charAt(i);
                    } else {
                        break;
                    }
                }
                i--;
                operands.push(num);
            } else if (c == '(') {
                operations.push(c);   //push character to operators stack
            }
            //Closed brace, evaluate the entire brace
            else if (c == ')') {
                while (operations.peek() != '(') {
                    int output = performOperation(operands, operations);
                    operands.push(output);   //push result back to stack
                }
                operations.pop();
            }

            // current character is operator
            else if (isOperator(c)) {
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) {
                    int output = performOperation(operands, operations);
                    operands.push(output);   //push result back to stack
                }
                operations.push(c);   //push the current operator to stack
            }
        }

        while (!operations.isEmpty()) {
            int output = performOperation(operands, operations);
            operands.push(output);   //push final result back to stack
        }
        return operands.pop();
    }

    static int precedence ( char c)
    {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public int performOperation (Stack < Integer > operands, Stack < Character > operations)
    {
        int a = operands.pop();
        int b = operands.pop();
        char operation = operations.pop();
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a != 0)
                    return b / a;
        }
        return 0;
    }

    public boolean isOperator ( char c)
    {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }
    public void clear_btn(View view){
        display.setText("");
    }
    public void para_btn(View view){
        if(f==0) {
            updatestr("(");
            f = 0;
        }
    }

    public void close_btn(View view){
        if(f==1) {
            updatestr(")");
            f = 1;
        }
    }
    public void div_btn(View view){
    if(f==1) {
        updatestr("/");
        f = 0;
    }
    }
    public void mul_btn(View view){
    if(f==1){
        updatestr("*");
        f=0;}
    }
    public void sum_btn(View view){
        if(f==1){
        updatestr("+");
        f=0;}
    }
    public void sub_btn(View view){
        if(f==1) {
            updatestr("-");
            f = 0;
        }
    }
    public void equal_btn(View view){
        if(f==1){
     String exp=display.getText().toString();
     int output=evaluate(exp);
     display.setText(""+output);
     int cursorPos=display.getSelectionStart();
     display.setSelection(cursorPos+display.length());
     f=1;}
        else
        {
            Toast.makeText(getApplicationContext(),"enter number",Toast.LENGTH_LONG).show();
        }
    }

    public void sign_btn(View view){
        updatestr("00");
        f=1;
    }
    public void one_btn(View view){
        updatestr("1");
        f=1;
    }
    public void two_btn(View view){
        updatestr("2");
        f=1;
    }
    public void three_btn(View view){
        updatestr("3");f=1;
    }
    public void four_btn(View view){
        updatestr("4");f=1;
    }
    public void five_btn(View view){
        updatestr("5");f=1;
    }
    public void six_btn(View view){
        updatestr("6");f=1;
    }
    public void seven_btn(View view){
        updatestr("7");f=1;
    }
    public void eight_btn(View view){
        updatestr("8");f=1;
    }
    public void nine_btn(View view){
        updatestr("9");f=1;
    }

}