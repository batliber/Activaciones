<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Usuarios</title>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/engine.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/util.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/SeguridadDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/dwr/interface/UsuarioDWR.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/jquery-ui.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/util.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/global.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/menu.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/filtros_dinamicos.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/js/grid.js"></script>
	<script type="text/javascript" src="/ActivacionesWEB/pages/usuarios/usuarios.js"></script>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/global.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/menu.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/filtros_dinamicos.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/css/grid.css"/>
	<link rel="stylesheet" type="text/css" href="/ActivacionesWEB/pages/usuarios/usuarios.css"/>
</head>
<body>
	<div class="divMenuBar">
<%@ include file="/includes/menu.jsp" %>	
	</div>
	<div class="divButtonBar">
		<div class="divButton"><input type="submit" value="Actualizar" onclick="javascript:inputActualizarOnClick(event)"/></div>
		<div class="divButton" id="divButtonNew"><input type="submit" value="Agregar" onclick="javascript:inputNewOnClick(event)"/></div>
		<div class="divButtonBarSeparator">&nbsp;</div>
	</div>
	<div class="divButtonTitleBar">
		<div id="divButtonTitleSingleSize" class="divButtonTitleBarTitle">Acciones</div>
		<div class="divButtonTitleBarSeparator">&nbsp;</div>
	</div>
	<div class="divMainWindow">
		<div id="divTableUsuarios">&nbsp;</div>
	</div>
	<div id="divIFrameUsuario" style="display: none;">
		<div class="divTitleBar">
			<div class="divTitleBarText" style="float:left;">Usuario</div>
			<div class="divTitleBarCloseButton" onclick="javascript:divCloseOnClick(event, this)">&nbsp;</div>
		</div>
		<iframe id="iFrameUsuario" frameborder="0" src="#"></iframe>
	</div>
	<div id="divModalBackground">&nbsp;</div>
</body>
</html>