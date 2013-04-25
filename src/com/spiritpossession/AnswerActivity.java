package com.spiritpossession;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AnswerActivity extends Activity {

	private AdView adView;
	private LinearLayout lytMain;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer);
               
        lytMain = (LinearLayout) findViewById(R.id.lytMain);
        adView = new AdView(this, AdSize.BANNER, "a151786603974bf");
        lytMain.addView(adView);
        adView.bringToFront();
        adView.loadAd(new AdRequest());
        
       final TextView answer = (TextView)findViewById(R.id.answer);
        Bundle bundle = getIntent().getExtras();
       answer.setText(bundle.getString("answer"));
       String aux = bundle.getString("flagAnswer");
       if(aux.compareTo("false") == 0){
    	   RelativeLayout rLayout = (RelativeLayout)findViewById(R.id.rLayout);
    	   rLayout.setBackgroundResource(R.drawable.neg);
    	   String[] arrStr = new String[3];
    	   arrStr[0] = getString(R.string.arr0);
    	   arrStr[1] = getString(R.string.arr1);
    	   arrStr[2] = getString(R.string.arr2);
    	   int rand = (int) Math.floor(Math.random()*(0-2+1)+2);
    	   answer.setText(arrStr[rand]);
       }
       
       Button Back = (Button) findViewById(R.id.Back);
        Back.setOnClickListener(
        		new OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				Intent inten = new Intent(AnswerActivity.this, QuestionActivity.class);
       				 	startActivity(inten);
        		            
        			}
        		}
        		);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}