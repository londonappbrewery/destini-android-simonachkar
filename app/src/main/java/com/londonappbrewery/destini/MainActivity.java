package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static com.londonappbrewery.destini.R.string.T3_Story;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
        private TextView mStoryTextView;
        private Button mTopButton;
        private Button mBottomButton;
        private int mStoryIndex;

    // TODO: Create Story Bank:
        private Story[] mStoryBank = new Story[] {
            /* programmers like to count from 0, so if we chose T1_Ans1 we will be redirected to
            T3_Story aka index #2 */
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2, 2, 1),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2, 2, 3),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2, 5, 4),
            new Story(R.string.T4_End),
            new Story(R.string.T5_End),
            new Story(R.string.T6_End)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
            mStoryTextView = (TextView) findViewById(R.id.storyTextView);
            mTopButton = (Button) findViewById(R.id.buttonTop);
            mBottomButton = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
            mTopButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateStory(true);
                }
            });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
            mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(false);
            }
        });

    }

    private void updateStory(boolean isTop){
        if (isTop){
            mStoryIndex = mStoryBank[mStoryIndex].getNextIfFirstChoice();
        }
        else{
            mStoryIndex = mStoryBank[mStoryIndex].getNextIfSecondChoice();
        }



        if (mStoryBank[mStoryIndex].getNextIfFirstChoice() == -1){
            mStoryTextView.setText(mStoryBank[mStoryIndex].getStory());
            mBottomButton.setVisibility(View.GONE);
            mTopButton.setVisibility(View.GONE);
        }
        else {
            mStoryTextView.setText(mStoryBank[mStoryIndex].getStory());
            mTopButton.setText(mStoryBank[mStoryIndex].getFirstChoice());
            mBottomButton.setText(mStoryBank[mStoryIndex].getSecondChoice());
        }

    }

}
