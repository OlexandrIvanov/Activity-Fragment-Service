package com.example.saa.task4;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class LoginActivity extends AppCompatActivity implements  OnClickListener {

     AutoCompleteTextView mLoginView;
    private EditText mPasswordView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button:
                if (mPasswordView.getText().toString().equals("1111")){
                    if ( mLoginView.getText().length()>0){
                        Intent intent = new Intent(this,MainActivity.class);
                        intent.putExtra("login", mLoginView.getText().toString());
                        startActivity(intent);
                    }
                }else {Toast.makeText(this, "The password is incorrect", Toast.LENGTH_LONG).show();}

                if (mLoginView.getText().length()== 0 ){
                    Toast.makeText(this, "Please, enter the login", Toast.LENGTH_LONG).show();
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPasswordView.setText("");
    }
}

