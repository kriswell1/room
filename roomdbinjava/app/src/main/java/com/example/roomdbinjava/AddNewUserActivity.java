package com.example.roomdbinjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roomdbinjava.db.AppDatabase;
import com.example.roomdbinjava.db.UserDB;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText firstNameInput= findViewById(R.id.firstNameInput);
        final EditText lastNameInput= findViewById(R.id.lastNameInput);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(firstNameInput.getText().toString(),lastNameInput.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName,String lastName){
        AppDatabase db= AppDatabase.getDbInstance(this.getApplicationContext());
        UserDB user= new UserDB();
        user.firstName=firstName;
        user.lastName=lastName;

        db.userDao().insertUserDB(user);

        finish();




    }
}