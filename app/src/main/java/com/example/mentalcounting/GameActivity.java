package com.example.mentalcounting;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mentalcounting.models.OperationModel;
import com.example.mentalcounting.models.exceptions.NoValueException;
import com.example.mentalcounting.models.exceptions.OperatorException;
import com.example.mentalcounting.services.OperationService;
import com.example.mentalcounting.services.VerifyUserResultService;

public class GameActivity extends AppCompatActivity {

    private TextView operationTV;
    private EditText answerET;
    private OperationModel operationModel;
    private TextView noValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Button mainButton = findViewById(R.id.main_button);

        mainButton.setOnClickListener(view -> openMainActivity());

        answerET = findViewById(R.id.answer);
        operationTV = findViewById(R.id.Operation);
        noValueTV = findViewById(R.id.noValue);

        OperationService operationService = new OperationService();
        operationModel = operationService.generateRandomOperation();

        String calcul = operationModel.getFirstCoefficient() + " " + operationModel.getOperator() + " " + operationModel.getSecondCoefficient();
        operationTV.setText(calcul);

        Button validateResult = findViewById(R.id.Validate);

        validateResult.setOnClickListener(view -> {
            try {
                Validate();
            } catch (OperatorException e) {
                e.printStackTrace();
            }
        });
    }
        private void Validate() throws OperatorException {
            int result = Integer.parseInt(answerET.getText().toString());
            verifyResult(result);
        }

    private void verifyResult(int result) throws OperatorException {
        VerifyUserResultService verifyUserResultService = new VerifyUserResultService();

        boolean verifyResult = verifyUserResultService.testComputeValue(operationModel, result);

        if(verifyResult){
            TextView operatorTextViewCorrect = findViewById(R.id.Sucess);
            operatorTextViewCorrect.setVisibility(View.VISIBLE);
            TextView operatorTextViewIncorrect = findViewById(R.id.Fail);
            operatorTextViewIncorrect.setVisibility(View.GONE);
            this.answerET.setVisibility(View.GONE);
        }else{
            TextView operatorTextViewIncorrect = findViewById(R.id.Fail);
            operatorTextViewIncorrect.setVisibility(View.VISIBLE);
        }
    }

    private void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_game_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.ScorePage:
                Intent intent = new Intent(this, ScoreActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}