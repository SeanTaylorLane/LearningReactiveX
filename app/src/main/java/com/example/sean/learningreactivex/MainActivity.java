package com.example.sean.learningreactivex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get all the UI elements
        Button myButton = (Button) findViewById(R.id.myButton);
        TextView myTextView = (TextView) findViewById(R.id.myTextView);
        EditText myEditText = (EditText) findViewById(R.id.myEditText);

        // Create an observable from the EditText and subscribe a lambda observable to it
        RxTextView.textChanges(myEditText).subscribe(cs -> {
            myTextView.setText(cs);
        });

        // I created an observable from the button instead of setting an onclick listener
        RxView.clicks(myButton).subscribe(thisisvoidhaha -> {
            Toast.makeText(MainActivity.this, myTextView.getText(), Toast.LENGTH_SHORT).show();
        });

    }
}
