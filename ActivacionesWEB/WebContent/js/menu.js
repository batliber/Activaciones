function divLogoutOnClick() {
	SeguridadDWR.logout(
		{
			callback: function(data) {
				window.location = "/ActivacionesWEB/";
			}, async: false
		}
	);
}