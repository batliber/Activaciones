var __ROL_ADMINISTRADOR = 1;

var grid = null;
		
$(document).ready(function() {
	$("#divButtonAsignar").hide();
	$("#divButtonSubirArchivo").hide();
	$("#divButtonAgregarMid").hide();
	$("#divButtonExportarAExcel").hide();
	
	SeguridadDWR.getActiveUserData(
		{
			callback: function(data) {
				for (var i=0; i<data.usuarioRolEmpresas.length; i++) {
					if (data.usuarioRolEmpresas[i].rol.id == __ROL_ADMINISTRADOR){
						$("#divButtonAsignar").show();
						$("#divButtonSubirArchivo").show();
						$("#divButtonAgregarMid").show();
						$("#divButtonExportarAExcel").show();
						
						grid = new Grid(
							document.getElementById("divTableActivaciones"),
							{
								tdMid: { campo: "mid", descripcion: "MID", abreviacion: "MID", tipo: __TIPO_CAMPO_NUMERICO },
								tdEmpresa: { campo: "empresa.nombre", clave: "empresa.id", descripcion: "Empresa", abreviacion: "Empresa", tipo: __TIPO_CAMPO_RELACION, dataSource: { funcion: listEmpresas, clave: "id", valor: "nombre" }, ancho: 80 },
								tdChip: { campo: "chip", abreviacion: "chip", descripcion: "Chip", tipo: __TIPO_CAMPO_STRING },
								tdFechaActivacion: { campo: "fechaActivacion", abreviacion: "F. Activación", descripcion: "Fecha de activación", tipo: __TIPO_CAMPO_FECHA },
								tdFechaImportacion: { campo: "fechaImportacion", abreviacion: "F. Importación", descripcion: "Fecha de importación", tipo: __TIPO_CAMPO_FECHA },
								tdEstadoActivacion: { campo: "estadoActivacion.nombre", clave: "estadoActivacion.id", descripcion: "Estado", abreviacion: "Estado", tipo: __TIPO_CAMPO_RELACION, dataSource: { funcion: listEstadoActivaciones, clave: "id", valor: "nombre" }, ancho: 80 },
								tdTipoActivacion: { campo: "tipoActivacion.descripcion", clave: "tipoActivacion.id", descripcion: "Tipo", abreviacion: "Tipo", tipo: __TIPO_CAMPO_RELACION, dataSource: { funcion: listTipoActivaciones, clave: "id", valor: "descripcion" }, ancho: 80 }
							}, 
							reloadData,
							trActivacionOnClick
						);
						
						grid.rebuild();
						
						$("#divButtonTitleSingleSize").attr("id", "divButtonTitleFourfoldSize");
						break;
					}
				}
				
				if (grid == null) {
					grid = new Grid(
						document.getElementById("divTableActivaciones"),
						{
							tdMid: { campo: "mid", descripcion: "MID", abreviacion: "MID", tipo: __TIPO_CAMPO_NUMERICO },
						}, 
						reloadData,
						trActivacionOnClick
					);
					
					grid.rebuild();
				}
			}, async: false
		}
	);
	
	reloadData();

	$("#divIFrameActivacion").draggable();
	$("#divIFrameSeleccionVendedor").draggable();
	$("#divIFrameImportacionArchivo").draggable();
});

function listEmpresas() {
	var result = [];
	
	EmpresaDWR.list(
		{
			callback: function(data) {
				if (data != null) {
					result = data;
				}
			}, async: false
		}
	);
	
	return result;
}

function listEstadoActivaciones() {
	var result = [];
	
	EstadoActivacionDWR.list(
		{
			callback: function(data) {
				if (data != null) {
					result = data;
				}
			}, async: false
		}
	);
	
	return result;
}

function listTipoActivaciones() {
	var result = [];
	
	TipoActivacionDWR.list(
		{
			callback: function(data) {
				if (data != null) {
					result = data;
				}
			}, async: false
		}
	);
	
	return result;
}

function listProductos() {
	var result = [];
	
	ProductoDWR.list(
		{
			callback: function(data) {
				if (data != null) {
					result = data;
				}
			}, async: false
		}
	);
	
	return result;
}

function listDistribuidores() {
	var result = [];
	
	UsuarioRolEmpresaDWR.listDistribuidoresByContext(
		{
			callback: function(data) {
				if (data != null) {
					result = data;
				}
			}, async: false
		}
	);
	
	return result;
}

function reloadData() {
	grid.setStatus(grid.__STATUS_LOADING);
	
	ActivacionDWR.listContextAware(
		grid.filtroDinamico.calcularMetadataConsulta(),
		{
			callback: function(data) {
				grid.reload(data);
			}
		}
	);
	
	ActivacionDWR.countContextAware(
		grid.filtroDinamico.calcularMetadataConsulta(),
		{
			callback: function(data) {
				grid.setCount(data);
			}
		}
	);
}

function inputActualizarOnClick(event, element) {
	reloadData();
}

function trActivacionOnClick(eventObject) {
	var target = eventObject.currentTarget;
	var estadoId = $(target).children("[campo='tdEstado']").attr("clave");
	
	var formMode = __FORM_MODE_READ;
	if (estadoId == __ESTADO_LLAMAR
		|| estadoId == __ESTADO_RELLAMAR
		|| estadoId == __ESTADO_RECHAZADO
		|| estadoId == __ESTADO_VENDIDO
		|| estadoId == __ESTADO_REAGENDAR) {
		formMode = __FORM_MODE_VENTA;
	} else if (estadoId == __ESTADO_RECOORDINAR
		|| estadoId == __ESTADO_FALTA_DOCUMENTACION) {
		formMode = __FORM_MODE_RECOORDINACION;
	}
	
	document.getElementById("iFrameActivacion").src = "/ActivacionesWEB/pages/activaciones/activacion.jsp?m=" + formMode + "&aid=" + $(target).attr("id");
	showPopUp(document.getElementById("divIFrameActivacion"));
}

function divCloseOnClick(event, element) {
	closePopUp(event, element.parentNode.parentNode);
	
	$("#selectVendedor").val("0");
	$("#selectEmpresa").val("0");
	$("#textareaObservaciones").val("");
	$("#inputArchivo").val("");
	
	reloadData();
}

function closeDialog() {
	divCloseOnClick(null, document.getElementById("divCloseIFrameActivacion"));
}

function inputSubirArchivoOnClick(event, element) {
	$("#selectEmpresa > option").remove();
	$("#selectTipoActivacion > option").remove();
	
	$("#selectEmpresa").append("<option value='0'>Seleccione...</option>");
	$("#selectTipoActivacion").append("<option value='0'>Seleccione...</option>");
	
	UsuarioRolEmpresaDWR.listEmpresasByContext(
		{
			callback: function(data) {
				var html = "";
				
				for (var i=0; i<data.length; i++) {
					html += "<option value='" + data[i].id + "'>" + data[i].nombre + "</option>";
				}
				
				$("#selectEmpresa").append(html);
			}, async: false
		}
	);
	
	TipoActivacionDWR.list(
		{
			callback: function(data) {
				var html = "";
				
				for (var i=0; i<data.length; i++) {
					html += "<option value='" + data[i].id + "'>" + data[i].descripcion + "</option>";
				}
				
				$("#selectTipoActivacion").append(html);
			}, async: false
		}
	);
	
	showPopUp(document.getElementById("divIFrameImportacionArchivo"));
}

function inputAsignarOnClick() {
	metadataConsulta = grid.filtroDinamico.calcularMetadataConsulta();
	metadataConsulta.tamanoSubconjunto = 
		Math.min(
			$("#inputTamanoSubconjunto").val(),
			$("#divCantidadRegistrosValue").text()
		);
	
	ContratoDWR.chequearAsignacion(
		metadataConsulta,
		{
			callback: function(data) {
				if (data || confirm("Atención: se modificarán registros que ya se encuentran asignados.")) {
					$("#selectVendedor > option").remove();
					
					$("#selectVendedor").append("<option value='0'>Seleccione...</option>");
					
					UsuarioRolEmpresaDWR.listVendedoresByContext(
						{
							callback: function(data) {
								var html = "";
								
								for (var i=0; i<data.length; i++) {
									html += "<option value='" + data[i].id + "'>" + data[i].nombre + "</option>";
								}
								
								$("#selectVendedor").append(html);
							}, async: false
						}
					);
					
					showPopUp(document.getElementById("divIFrameSeleccionVendedor"));
				}
			}, async: false
		}
	);
}

function inputCancelarOnClick(event, element) {
	closePopUp(event, document.getElementById("divIFrameSeleccionVendedor"));
	
	$("#selectVendedor").val("0");
	$("#textareaObservaciones").val("");
	
	reloadData();
}

function inputAceptarOnClick(event, element) {
	if ($("#selectVendedor").val() != "0") {
		var vendedor = {
			id: $("#selectVendedor").val()
		};
		
		metadataConsulta = grid.filtroDinamico.calcularMetadataConsulta();
		metadataConsulta.tamanoSubconjunto = 
			Math.min(
				$("#inputTamanoSubconjunto").val(),
				$("#divCantidadRegistrosValue").text()
			);
		
		if (confirm("Se asignarán " + metadataConsulta.tamanoSubconjunto + " registros.")) {
			ContratoDWR.asignarVentas(
				vendedor,
				metadataConsulta,
				{
					callback: function(data) {
						alert("Operación exitosa.");
						
						reloadData();
					}, async: false
				}
			);
		}
	} else {
		alert("Debe seleccionar un vendedor.");
	}
}

function inputAceptarSubirArchivoOnClick(event, element) {
	if ($("#selectEmpresa").val() == "0") {
		alert("Debe seleccionar una empresa.");
	} else if ($("#selectTipoActivacion").val == "0") {
		alert("Debe seleccionar un tipo de activación.");
	} else {
		var xmlHTTPRequest = new XMLHttpRequest();
		xmlHTTPRequest.open(
			"POST",
			"/ActivacionesWEB/Upload",
			false
		);
		
		var formData = new FormData(document.getElementById("formSubirArchivo"));
		
		xmlHTTPRequest.send(formData);
		
		if (xmlHTTPRequest.status == 200) {
			var response = JSON.parse(xmlHTTPRequest.responseText);
			
			if (confirm(response.message.replace(new RegExp("\\|", "g"), "\n"))) {
				ActivacionDWR.procesarArchivoEmpresa(
					response.fileName,
					response.empresaId,
					response.tipoActivacionId,
					{
						callback: function(data) {
							if (data != null) {
								alert(data.replace(new RegExp("\\|", "g"), "\n"));
							}
							
							reloadData();
						}, async: false
					}
				);
			}
		} else {
			alert(xmlHTTPRequest.responseText);
		}
	}
}

function inputAgregarMidOnClick(event, element) {
	document.getElementById("iFrameActivacion").src = "/ActivacionesWEB/pages/activaciones/activaciones.jsp?m=" + __FORM_MODE_NEW;
	showPopUp(document.getElementById("divIFrameActivacion"));
}

function inputExportarAExcelOnClick(event, element) {
	ActivacionDWR.exportarAExcel(
		grid.filtroDinamico.calcularMetadataConsulta(),
		{
			callback: function(data) {
				document.getElementById("formExportarAExcel").action = "/ActivacionesWEB/Download?fn=" + data;
				document.getElementById("formExportarAExcel").submit();
			}, async: false
		}
	);
}