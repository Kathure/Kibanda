package com.kathure.kibanda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {


    private static final String SHOWCASE_ID = "kibanda example";

    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonOne = (Button) findViewById(R.id.button);
        mButtonOne.setOnClickListener(this);

        mButtonTwo = (Button) findViewById(R.id.button2);
        mButtonTwo.setOnClickListener(this);

        mButtonThree = (Button) findViewById(R.id.button3);
        mButtonThree.setOnClickListener(this);

        presentShowcaseSequence();
    }

    private void presentShowcaseSequence() {
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(100); // ten second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, SHOWCASE_ID);
        sequence.setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener() {
            @Override
            public void onShow(MaterialShowcaseView itemView, int position) {
                Toast.makeText(itemView.getContext(), "Item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        sequence.addSequenceItem(mButtonOne, "This is button one", "GOT IT");

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setTarget(mButtonTwo)
                        .setDismissText("GOT IT")
                        .setContentText("This is button two")
                        .withRectangleShape(true)
                        .setContentTextColor(getResources().getColor(R.color.green))
                        .setMaskColour(getResources().getColor(R.color.purple))
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setTarget(mButtonThree)
                        .setDismissText("GOT IT")
                        .setContentText("This is button three")
                        .withRectangleShape()
                        .setContentTextColor(getResources().getColor(R.color.darkpurple))
                        .setMaskColour(getResources().getColor(R.color.orange))
                        .build()
        );

        sequence.start();

    }



    @Override
    public void onClick(View v) {

    }
}
