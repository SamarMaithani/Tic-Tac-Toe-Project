package com.example.tic_tac_toe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialogBox extends Dialog {
    private final String message;
    private final MainActivity mainActivity;

    public WinDialogBox(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message=message;
        this.mainActivity=mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dilog_layout);

        final TextView messageTxt = findViewById(R.id.messagetxt);
        final Button playAgainButton = findViewById(R.id.playagainbutton);
        final Button QuitButton = findViewById(R.id.QuitButton);

        messageTxt.setText(message);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.RestartGame();
                dismiss();
            }
        });
        QuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.QuitGame();
                dismiss();
            }
        });
    }
}
