package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__players);

        final EditText playerOne = findViewById(R.id.playerOneName);
        final EditText playerTwo = findViewById(R.id.playerTwoName);
        final Button StartGame = findViewById(R.id.startGameButton);

        StartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getPlayer1 = playerOne.getText().toString();
                final String getPlayer2 = playerTwo.getText().toString();

                if(getPlayer1.isEmpty() || getPlayer2.isEmpty())
                    Toast.makeText(Add_Players.this, "Enter the Player's name", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent=new Intent(Add_Players.this, MainActivity.class);
                    intent.putExtra("player1",getPlayer1);
                    intent.putExtra("player2",getPlayer2);
                    startActivity(intent);
                }
            }
        });
    }
}