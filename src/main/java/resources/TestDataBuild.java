package resources;

import datapojo.AddPlace;

public class TestDataBuild {

	public AddPlace addPlacePayLoad(String Username, String Password, double lat, double lng) {
		AddPlace p = new AddPlace();
		p.setExternal_id(Username);
		p.setName(Password);
		p.setLat(lat);
		p.setLng(lng);

		return p;
	}

}
