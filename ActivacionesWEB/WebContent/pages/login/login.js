$(document).ready(function() {
	if (window.parent != window) {
		window.top.location = window.location;
	} else {
		$("#inputUsuario").focus();
	}
});

function inputAccederOnClick(event, element) {
	SeguridadDWR.login(
		$("#inputUsuario").val(),
		$("#inputContrasena").val(),
		{
			callback: function(data) {
				if (data != null && data.menus != null && data.menus.length > 0) {
					window.location = data.menus[0].url;
				} else {
					window.location = "/ActivacionesWEB";
				}
			}, 
			errorHandler: function(data) {
				$("#divError").text(data);
			}, async: false
		}
	);
}

function inputUsuarioOnKeyDown(event, element) {
	if (event.keyCode == 13) {
		inputAccederOnClick(event, element);
	}
}

function inputContrasenaOnKeyDown(event, element) {
	if (event.keyCode == 13) {
		inputAccederOnClick(event, element);
	}
}