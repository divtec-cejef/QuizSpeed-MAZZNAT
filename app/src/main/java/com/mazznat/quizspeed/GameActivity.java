package com.mazznat.quizspeed;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableImageSourceView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView TV_nomJoueur1;
    private TextView TV_nomJoueur2;
    private Button BT_menu;
    private Button BT_rejouer;
    private TextView TV_Question1;
    private TextView TV_Question2;
    private ArrayList<String> ListeQuestion = new ArrayList<>();
    private Button BT_Joueur1;
    private Button BT_Joueur2;

    private void getId(){
        TV_nomJoueur1 = findViewById(R.id.nomJoueur1);
        TV_nomJoueur2 = findViewById(R.id.nomJoueur2);
        BT_menu = findViewById(R.id.buttonMenu);
        BT_rejouer = findViewById(R.id.buttonRejouer);
        TV_Question1 = findViewById(R.id.gagnantJoueur1);
        TV_Question2 = findViewById(R.id.gagnantJoueur2);
        BT_Joueur1 = findViewById(R.id.buttonJoueur1);
        BT_Joueur2 = findViewById(R.id.buttonJoueur2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getId();

        Intent GameActivity = getIntent();
        String Joueur1 = GameActivity.getStringExtra("Joueur1");
        String Joueur2 = GameActivity.getStringExtra("Joueur2");


        ListeQuestion.add("Pytagore est-il grecque ?");
        ListeQuestion.add("Y-a-t'il de l'oxygène dans l'espace ?");




        TV_nomJoueur1.setText(Joueur1);
        TV_nomJoueur2.setText(Joueur2);

        BT_menu.setVisibility(View.INVISIBLE);
        BT_rejouer.setVisibility(View.INVISIBLE);

        BT_Joueur1.setOnClickListener(new View.OnClickListener()

        {

            @Override
            public void onClick(View view) {
                Random rnd = new Random();


            }
        });
    }



}