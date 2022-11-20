package com.example.roomdbinjava;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdbinjava.db.AppDatabase;
import com.example.roomdbinjava.db.UserDB;

import java.util.List;

public class MainActivity extends AppCompatActivity {

        private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button addNewUserButton = findViewById(R.id.addNewUserButton);
        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,AddNewUserActivity.class));
            }
        });
        initRecycleView();
        loadUserList();
    }

    private void initRecycleView(){
        RecyclerView recycleView = findViewById(R.id.recyclerView);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        //a rekordok vertikálisan jelennek meg egymástól elválasztva
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recycleView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recycleView.setAdapter(userListAdapter);
    }

    private void loadUserList(){
        AppDatabase db= AppDatabase.getDbInstance(this.getApplicationContext());
        List<UserDB> userLIst = db.userDao().getAllUsers();
        userListAdapter.setUserList(userLIst);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==100){
            loadUserList();
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}