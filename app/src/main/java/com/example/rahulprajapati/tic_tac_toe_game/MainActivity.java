package com.example.rahulprajapati.tic_tac_toe_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    boolean getIsactive = true;
    int activeplayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int[][] winningpositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void chance(View view) {
        ImageView counter = (ImageView) view;

        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappedcounter]==2 && getIsactive) {

            gamestate[tappedcounter] = activeplayer;

            counter.setTranslationY(-1000f);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.circle);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.square);
                activeplayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(360).setDuration(1000);
            for (int[] winningPosition : winningpositions) {
                if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] &&
                        gamestate[winningPosition[1]] == gamestate[winningPosition[2]]
                        && gamestate[winningPosition[0]] != 2) {
                    getIsactive = false;
                    String winner1 = "Square";
                    if(gamestate[winningPosition[0]]==0){
                        winner1 = "Circle";
                    }
                    TextView winText = (TextView) findViewById(R.id.winner);
                    winText.setText(winner1 + " has won!");

                    LinearLayout linear = (LinearLayout) findViewById(R.id.linearlayout);
                    linear.setVisibility(View.VISIBLE);
                }
                else {
                    boolean gameIsover = true;
                    for(int counterstate : gamestate){
                        if(counterstate==2)
                            gameIsover = false;
                        if(gameIsover) {
                            TextView winText = (TextView) findViewById(R.id.winner);
                            winText.setText("Its a draw!");

                            LinearLayout linear = (LinearLayout) findViewById(R.id.linearlayout);
                            linear.setVisibility(View.VISIBLE);
                        }


                    }


                    }
                }
            }
        }



    public void playagain(View view) {
        getIsactive = true;
        LinearLayout linear = (LinearLayout) findViewById(R.id.linearlayout);
        linear.setVisibility(View.INVISIBLE);
        activeplayer = 0;
        for (int i =0; i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        GridLayout  gridLayout1 = (GridLayout) findViewById(R.id.gridlayout);
        for (int i=0; i<gamestate.length; i++)
        {
            ((ImageView) gridLayout1.getChildAt(i)).setImageResource(0);
        }

    }
}
