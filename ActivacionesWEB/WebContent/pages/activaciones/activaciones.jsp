<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Activaciones</title>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/engine.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/util.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/SeguridadDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/UsuarioRolEmpresaDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/EstadoActivacionDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/UsuarioDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/EmpresaDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/TipoActivacionDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/ActivacionDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/jquery-ui.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/util.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/global.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/menu.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/filtros_dinamicos.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/grid.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/pages/activaciones/activaciones.js"></script>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/menu.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/filtros_dinamicos.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/grid.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/pages/activaciones/activaciones.css"/>
</head>
<body>
	<div class="divMenuBar">
<%@ include file="/includes/menu.jsp" %>
	</div>
	<div class="divButtonBar">
		<div class="divButton"><input type="submit" id="inputActualizar" value="Actualizar" onclick="javascript:inputActualizarOnClick(event, this)"/></div>
		<div class="divButton" id="divButtonAsignar"><input type="submit" id="inputAsignar" value="Asignar" onclick="javascript:inputAsignarOnClick(event, this)"/></div>
		<div class="divButton" id="divButtonSubirArchivo"><input type="submit" id="inputSubirArchivo" value="Subir archivo" onclick="javascript:inputSubirArchivoOnClick(event, this)"/></div>
		<div class="divButton" id="divButtonExportarAExcel">
			<form method="post" id="formExportarAExcel" action="#"><input type="submit" id="inputExportarAExcel" value="Exporta a Excel" onclick="javascript:inputExportarAExcelOnClick(event, this)"/></form>
		</div>
		<div class="divButtonBarSeparator">&nbsp;</div>
	</div>
	<div class="divButtonTitleBar">
		<div id="divButtonTitleSingleSize" class="divButtonTitleBarTitle">Acciones</div>
		<div class="divButtonTitleBarSeparator">&nbsp;</div>
	</div>
	<div class="divMainWindow">
		<div id="divFiltros">
			<div class="divFormLabelExtended">Tama&ntilde;o de muestra:</div>
			<div id="divTamanoMuestra"><input type="text" id="inputTamanoMuestra" value="50" onchange="javascript:grid.filtroDinamico.tamanoMuestraOnChange(event)"/></div>
			<div class="divFormLabelExtended">Tama&ntilde;o subconjunto:</div>
			<div id="divTamanoSubconjunto"><input type="text" id="inputTamanoSubconjunto" value="500" onchange="javascript:grid.filtroDinamico.tamanoSubconjuntoOnChange(event)"/></div>
			<div id="divAgregarFiltroContainer">
				<div class="divFormLabelExtended">Agregar filtro:</div>
				<div id="divAgregarFiltro"><input type="submit" value="Agregar" id="inputAgregarFiltro" onclick="javascript:grid.filtroDinamico.agregarFiltro(event, this)"/></div>
				<div class="divFormLabelExtended">Limpiar filtros:</div>
				<div id="divLimpiarFiltros"><input type="submit" value="Limpiar" id="inputLimpiarFiltros" onclick="javascript:grid.filtroDinamico.limpiarFiltros(event, this)"/></div>
			</div>
		</div>
		<div id="divActivacion">
			<div id="divTableActivaciones">&nbsp;</div>
		</div>
	</div>
	<div id="divIFrameActivacion" style="display: none;">
		<div class="divTitleBar">
			<div class="divTitleBarText" style="float:left;">Activacion</div>
			<div id="divCloseIFrameActivacion" class="divTitleBarCloseButton" onclick="javascript:divCloseOnClick(event, this)">&nbsp;</div>
		</div>
		<iframe id="iFrameActivacion" frameborder="0" src="#"></iframe>
	</div>
	<div id="divIFrameSeleccionVendedor" style="display: none;">
		<div class="divTitleBar">
			<div class="divTitleBarText" style="float:left;">Vendedor</div>
			<div class="divTitleBarCloseButton" onclick="javascript:divCloseOnClick(event, this)">&nbsp;</div>
		</div>
		<div id="divSeleccionVendedor">
			<div class="divButtonBar">
				<div class="divButton"><input type="submit" value="Aceptar" onclick="javascript:inputAceptarOnClick(event)"/></div>
				<div class="divButton"><input type="submit" value="Cancelar" onclick="javascript:inputCancelarOnClick(event)"/></div>
				<div class="divButtonBarSeparator">&nbsp;</div>
			</div>
			<div class="divButtonTitleBar">
				<div id="divButtonTitleDoubleSize" class="divButtonTitleBarTitle">Acciones</div>
				<div class="divButtonTitleBarSeparator">&nbsp;</div>
			</div>
			<div class="divMainWindow">
				<div class="divFormLabelExtended">Vendedor:</div><div id="divVendedor"><select id="selectVendedor"></select></div>
				<div class="divFormLabelExtended">Observaciones:</div><div id="divObservaciones"><textarea id="textareaObservaciones"></textarea></div>
			</div>
		</div>
	</div>
	<div id="divIFrameImportacionArchivo" style="display: none;">
		<div class="divTitleBar">
			<div class="divTitleBarText" style="float:left;">Importaci&oacute;n archivo</div>
			<div class="divTitleBarCloseButton" onclick="javascript:divCloseOnClick(event, this)">&nbsp;</div>
		</div>
		<div id="divImportacionArchivo">
			<div class="divButtonBar">
				<div class="divButton"><input type="submit" value="Aceptar" onclick="javascript:inputAceptarSubirArchivoOnClick(event)"/></div>
				<div class="divButton"><input type="submit" value="Cancelar" onclick="javascript:inputCancelarOnClick(event)"/></div>
				<div class="divButtonBarSeparator">&nbsp;</div>
			</div>
			<div class="divButtonTitleBar">
				<div id="divButtonTitleDoubleSize" class="divButtonTitleBarTitle">Acciones</div>
				<div class="divButtonTitleBarSeparator">&nbsp;</div>
			</div>
			<div class="divMainWindow">
				<form id="formSubirArchivo" method="POST" action="/ActivacionesWEB/Upload" enctype="multipart/form-data">
					<input type="hidden" name="caller" value="/ActivacionesWEB/pages/activaciones/activaciones.jsp"/>
					<div class="divFormLabelExtended">Empresa:</div><div id="divEmpresa"><select id="selectEmpresa" name="selectEmpresa"></select></div>
					<div class="divFormLabelExtended">Tipo activaci&oacute;n:</div><div id="divTipoActivacion"><select id="selectTipoActivacion" name="selectTipoActivacion"></select></div>
					<div class="divFormLabelExtended">Archivo:</div><div id="divArchivo"><input type="file" id="inputArchivo" name="inputArchivo"/></div>
				</form>
			</div>
		</div>
	</div>
	<div id="divModalBackgroundChild">&nbsp;</div>
</body>
</html>