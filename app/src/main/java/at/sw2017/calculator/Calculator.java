package at.sw2017.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends Activity implements View.OnClickListener {

    private ArrayList <Button> buttonArrayList = new ArrayList<>();
    private TextView numberView;
    private Button button_clear, button_equal, button_add, button_sub, button_mult, button_div;
    public enum CalculatorState {
        ADD, SUB, MUL, DIV, INIT, NUM
    }

    private int first_num;
    private CalculatorState state;

    public void setUpNumberButtonlistener(){
        int id;
        button_clear = (Button)findViewById(R.id.btn_c);
        button_clear.setOnClickListener(this);
        button_equal = (Button)findViewById(R.id.btn_equal);
        button_equal.setOnClickListener(this);
        button_add = (Button)findViewById(R.id.btn_plus);
        button_add.setOnClickListener(this);
        button_sub = (Button)findViewById(R.id.btn_min);
        button_sub.setOnClickListener(this);
        button_mult = (Button)findViewById(R.id.btn_mult);
        button_mult.setOnClickListener(this);
        button_div = (Button)findViewById(R.id.btn_div);
        button_div.setOnClickListener(this);
        numberView = (TextView) findViewById(R.id.textView);

        for (int i = 0; i <= 9; i++){
            String buttonName = "btn_" + i;
            id = getResources().getIdentifier(buttonName, "id", R.class.getPackage().getName());
            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);
            buttonArrayList.add(button);
        }
    }

    private void clearTextView(){
        numberView.setText("");
        first_num = 0;
        state = CalculatorState.INIT;
    }

    private void clearNumbers(){
        String temp_string = numberView.getText().toString();
        if(!temp_string.equals("")){
            first_num = Integer.valueOf(temp_string);
        }
        numberView.setText("");
    }

    private void calculate(){
        int second_number = 0;
        int result;

        String temp_string = numberView.getText().toString();
        if(!temp_string.equals("")){
            second_number = Integer.valueOf(temp_string);
        }

        switch(state){
            case ADD:
                result = Calculations.doAdd(first_num, second_number);
                break;
            case SUB:
                result = Calculations.doSub(first_num, second_number);
                break;
            case MUL:
                result = Calculations.doMult(first_num, second_number);
                break;
            case DIV:
                result = Calculations.doDiv(first_num, second_number);
                break;
            default:
                result = second_number;
        }
        numberView.setText(Integer.toString(result));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        setUpNumberButtonlistener();
    }

    @Override
    public void onClick(View v) {
        Button clickedButton = (Button) v;

        switch(clickedButton.getId()){
            case R.id.btn_plus:
                clearNumbers();
                state = CalculatorState.ADD;
                break;
            case R.id.btn_min:
                clearNumbers();
                state = CalculatorState.SUB;
                break;
            case R.id.btn_mult:
                clearNumbers();
                state = CalculatorState.MUL;
                break;
            case R.id.btn_div:
                clearNumbers();
                state = CalculatorState.DIV;
                break;
            case R.id.btn_equal:
                calculate();
                break;
            case R.id.btn_c:
                clearTextView();
                break;
            default:
                String recent_number = numberView.getText().toString();
                if(state == CalculatorState.INIT){
                    recent_number = "";
                    state = CalculatorState.NUM;
                }
                recent_number += clickedButton.getText().toString();
                numberView.setText(recent_number);
        }
    }
}
