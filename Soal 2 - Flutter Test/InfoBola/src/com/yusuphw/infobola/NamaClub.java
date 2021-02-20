package com.yusuphw.infobola;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NamaClub extends Activity {
	TextView InputClubName;
	public static TextView ShowClubName;
	Button SearchClubName;
	Button Back1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nama_club);
		
		InputClubName = (TextView) findViewById(R.id.editNamaClub);
		ShowClubName = (TextView) findViewById(R.id.ViewNamaClub);
		SearchClubName = (Button) findViewById(R.id.btnCariNamaClub);
		Back1  = (Button) findViewById(R.id.btnKembaliMenu1);
		
		SearchClubName.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Set URL for club name
				//GetSetURL getset = new GetSetURL();
				//getset.seturlNamaClub(InputClubName.getText().toString());
				if (InputClubName.getText().toString().equals("")) {
					ShowClubName.setText("Mohon berikan input\n\nGunakan underscore sebagai pengganti spasi");
				} else {
					ShowClubName.setText("Mencari...");
					
					GetSetURL.findNamaClub = InputClubName.getText().toString();
					GetSetURL.urlNamaClub = "https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=" + GetSetURL.findNamaClub;
					
					//Create fetch data object and execute the url
					fetchClubData process1 = new fetchClubData();
					process1.execute();
				}
			}
		});
		
		Back1.setOnClickListener(new View.OnClickListener() {
			
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
		getMenuInflater().inflate(R.menu.nama_club, menu);
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
