package com.yusuphw.infobola;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PertandinganLiga extends Activity {
	TextView InputLeagueName;
	public static TextView ShowLeagueName;
	Button SearchLeagueName;
	Button Back3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pertandingan_liga);
		
		InputLeagueName = (TextView) findViewById(R.id.editNamaLiga);
		ShowLeagueName = (TextView) findViewById(R.id.ViewNamaLiga);
		SearchLeagueName = (Button) findViewById(R.id.btnCariNamaLiga);
		Back3 = (Button) findViewById(R.id.btnKembaliMenu3);
		
		SearchLeagueName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (InputLeagueName.getText().toString().equals("")) {
					ShowLeagueName.setText("Mohon berikan input\n\nGunakan underscore sebagai pengganti spasi");
				} else {
					ShowLeagueName.setText("Mencari...");
					
					GetSetURL.findNamaLiga = InputLeagueName.getText().toString();
					GetSetURL.urlNamaLiga = "https://www.thesportsdb.com/api/v1/json/1/searchfilename.php?e=" + GetSetURL.findNamaLiga;
					
					fetchLigaData process3 = new fetchLigaData();
					process3.execute();
				}
			}
		});
		
		Back3.setOnClickListener(new View.OnClickListener() {
			
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
		getMenuInflater().inflate(R.menu.pertandingan_liga, menu);
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
