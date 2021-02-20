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

public class fetchClubData extends AsyncTask<Void, Void, Void> {
	//String findURL = "";
	String data = "";
	String dataParse = "";
	String singleParse = "";
	//Background data process
		
	@Override
	protected Void doInBackground(Void... arg0) {
		// TODO Auto-generated method stub
		//Generate URL
		//GetSetURL getset = new GetSetURL();
		//findURL = getset.geturlNamaClub();
		try {
			//URL url = new URL("https://www.thesportsdb.com/api/v1/json/1/searchteams.php?t=" + findURL);
			URL url = new URL(GetSetURL.urlNamaClub);
			//Connection
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = httpURLConnection.getInputStream();
			//Read Data
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			//Store JSON to line variable
			String line = "";
			while (line != null) {
				line = bufferedReader.readLine();
				data = data + line;
			}
			
			//JSON Array and JSON Object
			/*JSONArray JA = new JSONArray(data);
			for (int i = 0; i < JA.length(); i++) {
				JSONObject JO = (JSONObject) JA.get(i);
				singleParse = 	JO.getString("strTeam") + "\n" +
								JO.getString("strLeague") + "\n";
				
				dataParse = dataParse + singleParse + "\n";
			}*/
			
			//Create JSON Object
			JSONObject jsonObject = new JSONObject(data);
			if (jsonObject.isNull("teams")) {
				dataParse = "Club tidak ditemukan\n\n" +
							"Mohon gunakan Bahasa Inggris sebagai input nama club\n\n" +
							"Gunakan underscore sebagai pengganti spasi";
			} else {
				//Create JSON Array and get the object inside it
				JSONArray jsonArray = jsonObject.getJSONArray("teams");
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject object = jsonArray.getJSONObject(i);
					singleParse = 	object.getString("strTeam") + " (" +
									object.getString("intFormedYear") + ")\nLiga : " +
									object.getString("strLeague") + "\n";
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
	
	//Change UI with this method
	@Override
	protected void onPostExecute(Void aVoid) {
		super.onPostExecute(aVoid);
		//NamaClub.ShowClubName.setText(data);
		NamaClub.ShowClubName.setText(dataParse);
	}

}
