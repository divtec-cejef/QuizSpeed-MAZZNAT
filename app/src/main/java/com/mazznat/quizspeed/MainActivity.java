package com.mazznat.quizspeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mazznat.quizspeed.Models.Question;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText ET_Joueur1;
    private EditText ET_Joueur2;
    private TextView TV_Joueur1;
    private TextView TV_Joueur2;
    private Button BT_Ajouter;
    private Button BT_Commencer;

    /**
     * Prend les ID des objet utilisé.
     */
    private void getId(){
        TV_Joueur1 = findViewById(R.id.main_TextView1);
        TV_Joueur2 = findViewById(R.id.main_TextView2);
        ET_Joueur1 = findViewById(R.id.main_joueur1_edittext);
        ET_Joueur2 = findViewById(R.id.main_joueur2_edittext);
        BT_Ajouter = findViewById(R.id.main_boutonAjouter);
        BT_Commencer = findViewById(R.id.main_boutonCommencer);
    }

    /**
     * Rend invisble les joueur
     */
    private void putInvisible(){
        TV_Joueur1.setVisibility(View.INVISIBLE);
        ET_Joueur1.setVisibility(View.INVISIBLE);
        ET_Joueur2.setVisibility(View.INVISIBLE);
        TV_Joueur2.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mainMenu = findViewById(R.id.main_menu);
        setSupportActionBar(mainMenu);

        getId();
        putInvisible();

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_parametres:
                Intent settingsActivity = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsActivity);
                break;
            case R.id.menu_question:
                Intent questionActivity = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(questionActivity);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    @Override
    protected  void onStart(){
        super.onStart();
        BT_Ajouter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                TV_Joueur1.setVisibility(View.VISIBLE);
                ET_Joueur1.setVisibility(View.VISIBLE);
            }

        });

        BT_Commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ET_Joueur1.setVisibility(View.VISIBLE);
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                gameActivity.putExtra("Joueur1", ET_Joueur1.getText().toString());
                gameActivity.putExtra("Joueur2", ET_Joueur2.getText().toString());
                startActivity(gameActivity);
            }
        });

        ET_Joueur1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ET_Joueur1.getText().toString().isEmpty() || ET_Joueur2.getText().toString().isEmpty()){
                    ET_Joueur2.setVisibility(View.VISIBLE);
                    TV_Joueur2.setVisibility(View.VISIBLE);

                    BT_Commencer.setEnabled(false);
                }else{
                    BT_Commencer.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        ET_Joueur2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ET_Joueur1.getText().toString().isEmpty() || ET_Joueur2.getText().toString().isEmpty()){
                    BT_Commencer.setEnabled(false);
                }else{
                    BT_Commencer.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }
}