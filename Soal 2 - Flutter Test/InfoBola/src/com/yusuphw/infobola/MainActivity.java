package com.yusuphw.infobola;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	Button MenuNamaClub;
	Button MenuNamaNegara;
	Button MenuNamaLiga;
	Button Exit;
	Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MenuNamaClub = (Button) findViewById(R.id.btnNamaClub);
        MenuNamaNegara = (Button) findViewById(R.id.btnNamaNegara);
        MenuNamaLiga = (Button) findViewById(R.id.btnNamaLiga);
        Exit = (Button)findViewById(R.id.btnKeluar);
        
        MenuNamaClub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent = new Intent(MainActivity.this, NamaClub.class);
				startActivity(intent);
			}
		});
        
        MenuNamaNegara.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent = new Intent(MainActivity.this, NamaNegara.class);
				startActivity(intent);
			}
		});
        
        MenuNamaLiga.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				intent = new Intent(MainActivity.this, PertandinganLiga.class);
				startActivity(intent);
				
			}
		});
        
        Exit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
    }
        
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
