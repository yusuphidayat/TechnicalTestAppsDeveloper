package com.yusuphw.infobola;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NamaNegara extends Activity {
	TextView InputCountryName;
	public static TextView ShowCountryName;
	Button SearchCountryName;
	Button Back2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nama_negara);
		
		InputCountryName = (TextView) findViewById(R.id.editNamaNegara);
		ShowCountryName = (TextView) findViewById(R.id.ViewNamaNegara);
		SearchCountryName = (Button)findViewById(R.id.btnCariNamaNegara);
		Back2 = (Button)findViewById(R.id.btnKembaliMenu2);
		
		SearchCountryName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (InputCountryName.getText().toString().equals("")) {
					ShowCountryName.setText("Mohon berikan input\n\nGunakan underscore sebagai pengganti spasi");
				} else {
					ShowCountryName.setText("Mencari...");
					
					GetSetURL.findNamaNegara = InputCountryName.getText().toString();
					GetSetURL.urlNamaNegara = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=" + GetSetURL.findNamaNegara;
					
					fetchNegaraData process2 = new fetchNegaraData();
					process2.execute();
				}
			}
		});
		
		Back2.setOnClickListener(new View.OnClickListener() {
			
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
		getMenuInflater().inflate(R.menu.nama_negara, menu);
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
