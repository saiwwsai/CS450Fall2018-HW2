package edu.stlawu.montyhall;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    ImageButton door1 = null;
    ImageButton door2 = null;
    ImageButton door3 = null;
    // create array of doors; randomInt n is the index where the door has a car
    ImageButton[] doors = {door1, door2, door3};
    int goat = -1;

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View gameView = inflater.inflate(R.layout.fragment_game, container, false);

        // maybe cannot call inside onClick under onCreateView
        firstClick(gameView);

        return gameView;
    }


    // schedule the runable to call doorOpen
    public void firstClick(View gameView){

        // Image Button activities - doors
        door1 = gameView.findViewById(R.id.door1);
        door2 = gameView.findViewById(R.id.door2);
        door3 = gameView.findViewById(R.id.door3);

        // generate random index for car door
        Random carRandom = new Random();
        int car = carRandom.nextInt(3); // doors[car] is the door with car todo
        // generate goat door
        Random goatRandom = new Random();
        int tmp = goatRandom.nextInt(3);
        // sift goat doors out, ready to open
        while (tmp != car){
            goat = tmp; // doors[goat]: is the door we will show to the user, a goat door
        }

        // set onClickListener
        door1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // change image to chosen door
                door1.setImageLevel(1);
                // show goat
                showGoat(doors[goat]);
            }
        });

        door2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // change image to chosen door
                door2.setImageLevel(1);
                // show goat
                showGoat(doors[goat]);
            }
        });

        door3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // change image to chosen door
                door3.setImageLevel(1);
                // show goat
                showGoat(doors[goat]);
            }
        });
    }


    public void showGoat(final ImageButton door){

        // Toast indicating another door is open //todo not sure
        Toast.makeText(getActivity(), "Another Door Opens!", Toast.LENGTH_LONG).show();

        // show goat door
        door.setImageLevel(3);

        // enable the image button
     //   door.setEnabled(false);

        // popup: want to switch?
    /*    AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.door_switch_title); //"Switch to Another Door"
        builder.setMessage(R.string.door_switch_text); //"Do you want to switch door"
        builder.setPositiveButton(R.string.yes,
                new DialogInterface.OnClickListener() {  //"YES"
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //return;
                    }
                });
        builder.setNegativeButton(R.string.no,
                new DialogInterface.OnClickListener() {  //No
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //return;
                    }
                });
        builder.show(); */

    }

}