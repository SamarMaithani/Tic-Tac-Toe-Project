package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList=new ArrayList<>();
    private int[]boxPositions={0,0,0,0,0,0,0,0,0};
    private int PlayerTurn = 1;
    private int totalselectedboxes=1;
    String getPlayer1Name, getPlayer2Name;
    private TextView playerName;
    private ImageView playerMark;
    private ImageView space1, space2, space3, space4, space5, space6, space7, space8, space9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerName = findViewById(R.id.PlayerName);
        playerMark = findViewById(R.id.PlayerMark);

        space1 = findViewById(R.id.space1);
        space2 = findViewById(R.id.space2);
        space3 = findViewById(R.id.space3);
        space4 = findViewById(R.id.space4);
        space5 = findViewById(R.id.space5);
        space6 = findViewById(R.id.space6);
        space7 = findViewById(R.id.space7);
        space8 = findViewById(R.id.space8);
        space9 = findViewById(R.id.space9);

        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        combinationsList.add(new int[]{0, 3, 6});
        combinationsList.add(new int[]{1, 4, 7});
        combinationsList.add(new int[]{2, 5, 8});
        combinationsList.add(new int[]{0, 4, 8});
        combinationsList.add(new int[]{2, 4, 6});

        getPlayer1Name = getIntent().getStringExtra("player1");
        getPlayer2Name = getIntent().getStringExtra("player2");
        if(PlayerTurn==1)
        {
            playerName.setText(getPlayer1Name);
            playerMark.setImageResource(R.drawable.x);
        }
        else
        {
            playerName.setText(getPlayer2Name);
            playerMark.setImageResource(R.drawable.o);
        }

        space1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(0))
                {
                    performAction((ImageView)v,0);
                }

            }
        });
        space2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(1))
                {
                    performAction((ImageView)v,1);
                }
            }
        });
        space3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(2))
                {
                    performAction((ImageView)v,2);
                }

            }
        });
        space4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(3))
                {
                    performAction((ImageView)v,3);
                }

            }
        });
        space5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(4))
                {
                    performAction((ImageView)v,4);
                }

            }
        });
        space6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(5))
                {
                    performAction((ImageView)v,5);
                }

            }
        });
        space7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(6))
                {
                    performAction((ImageView)v,6);
                }

            }
        });
        space8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(7))
                {
                    performAction((ImageView)v,7);
                }

            }
        });
        space9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBoxSelectable(8))
                {
                    performAction((ImageView)v,8);
                }

            }
        });
    }

    private void performAction(ImageView imageView, int SelectedPosition)
    {
        boxPositions[SelectedPosition]=PlayerTurn;
        if(PlayerTurn==1)
        {
            imageView.setImageResource(R.drawable.x);
            if(CheckWin())
            {
                WinDialogBox winDilog = new WinDialogBox(MainActivity.this, playerName.getText().toString()+" Wins!!",MainActivity.this);
                winDilog.setCancelable(false);
                winDilog.show();
            }
            else if(totalselectedboxes==9)
            {
                WinDialogBox winDilog = new WinDialogBox(MainActivity.this, " DRAW!!",MainActivity.this);
                winDilog.setCancelable(false);
                winDilog.show();
            }
            else
            {
                changeTurn(2);
                totalselectedboxes++;
            }
        }
        else
        {
            imageView.setImageResource(R.drawable.o);
            if(CheckWin())
            {
                WinDialogBox winDilog = new WinDialogBox(MainActivity.this, playerName.getText().toString()+" Wins!!",MainActivity.this);
                winDilog.setCancelable(false);
                winDilog.show();
            }
            else if(totalselectedboxes==9)
            {
                WinDialogBox winDilog = new WinDialogBox(MainActivity.this, " DRAW!!",MainActivity.this);
                winDilog.setCancelable(false);
                winDilog.show();
            }
            else
            {
                changeTurn(1);
                totalselectedboxes++;
            }
        }
    }

    private void changeTurn(int currentPlayer)
    {
        PlayerTurn=currentPlayer;
        if(PlayerTurn==1)
        {
            playerName.setText(getPlayer1Name);
            playerMark.setImageResource(R.drawable.x);
        }
        else
        {
            playerName.setText(getPlayer2Name);
            playerMark.setImageResource(R.drawable.o);
        }
    }

    private boolean CheckWin()
    {
        boolean response = false;
        for(int i=0; i< combinationsList.size();i++)
        {
            final int combinaton[]= combinationsList.get(i);
            if(boxPositions[combinaton[0]]==PlayerTurn && boxPositions[combinaton[1]]==PlayerTurn
             && boxPositions[combinaton[2]]==PlayerTurn)
                response=true;
        }
        return response;
    }

    private boolean isBoxSelectable(int boxPosition)
    {
        boolean response=false;
        if(boxPositions[boxPosition]==0)
            response=true;
        return response;
    }

    public void RestartGame()
    {
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        totalselectedboxes=1;
        space1.setImageResource(0);
        space2.setImageResource(0);
        space3.setImageResource(0);
        space4.setImageResource(0);
        space5.setImageResource(0);
        space6.setImageResource(0);
        space7.setImageResource(0);
        space8.setImageResource(0);
        space9.setImageResource(0);
    }
    public void QuitGame()
    {
        Intent intent = new Intent(MainActivity.this, Add_Players.class);
        startActivity(intent);
    }
}
