package com.yusuphw.infobola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class fetchLigaData extends AsyncTask<Void, Void, Void> {
	// TODO Auto-generated method stub
	String data = "";
	String singleParse = "";
	String dataParse = "";

	@Override
	protected Void doInBackground(Void... arg0) {
		try {
			URL url = new URL(GetSetURL.urlNamaLiga);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = httpURLConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line = "";
			while (line != null) {
				line = bufferedReader.readLine();
				data = data + line;
			}
			
			JSONObject jsonObject = new JSONObject(data);
			if (jsonObject.isNull("event")) {
				dataParse = "Liga tidak ditemukan\n\n" +
							"Mohon gunakan Bahasa Inggris sebagai input nama liga\n\n" +
							"Gunakan underscore sebagai pengganti spasi";
			} else {
				JSONArray jsonArray = jsonObject.getJSONArray("event");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = jsonArray.getJSONObject(i);
					singleParse = 	object.getString("strEvent") + "\nScore\t: " +
									object.getString("intHomeScore") + " - " +
									object.getString("intAwayScore") + "\nDate\t\t: " +
									object.getString("dateEvent") + "\nTime\t: " +
									object.getString("strTime") + " WIB" + "\n";
					dataParse = dataParse + singleParse + "\n";
				}
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Void aVoid) {
		super.onPostExecute(aVoid);
		//NamaClub.ShowClubName.setText(data);
		PertandinganLiga.ShowLeagueName.setText(dataParse); //dataparse
	}

}
