package uy.com.amensg.activaciones.servlets;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import uy.com.amensg.activaciones.bean.ActivacionBean;
import uy.com.amensg.activaciones.bean.ControlBean;
import uy.com.amensg.activaciones.bean.IActivacionBean;
import uy.com.amensg.activaciones.bean.IControlBean;
import uy.com.amensg.activaciones.util.Configuration;

@MultipartConfig(
	fileSizeThreshold=1024*1024*10,	// 10 MB
	maxFileSize=1024*1024*50,		// 50 MB
	maxRequestSize=1024*1024*100	// 100 MB
)
public class UploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1408929564540370839L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String caller = request.getParameter("caller");
		
		try {
			if (caller.contains("mobile")) {
				
			} else if (caller.contains("activacion")) {
				Long empresaId = new Long(request.getParameter("selectEmpresa").toString());
				Long tipoActivacionId = new Long(request.getParameter("selectTipoActivacion").toString());
				
				String fileName = null;
				for (Part part : request.getParts()) {
					String contentDisposition = part.getHeader("content-disposition");
					
					String[] tokens = contentDisposition.split(";");
			        for (String token : tokens) {
			        	if (token.trim().startsWith("filename")) {
		            		fileName = token.substring(token.indexOf("=") + 2, token.length()-1);
		            		break;
		            	}
			        }
			        
			        if (fileName != null) {
			        	part.write(Configuration.getInstance().getProperty("importacion.carpeta") + fileName);
			        	break;
			        }
				}
				
				IActivacionBean iActivacionBean = lookupActivacionBean();
				
				String result = iActivacionBean.preprocesarArchivoEmpresa(
					fileName,
					empresaId
				);
				
				request.setAttribute("message", result);
				request.setAttribute("fileName", fileName);
				request.setAttribute("empresaId", empresaId);
				request.setAttribute("tipoActivacionId", tipoActivacionId);
				
				String json = "{"
					+ "\"message\": \"" + result + "\","
					+ "\"fileName\": \"" + fileName + "\","
					+ "\"empresaId\": \"" + empresaId + "\","
					+ "\"tipoActivacionId\": \"" + tipoActivacionId + "\""
					+ "}";
				
				response.addHeader("Content-Type", "application/json");
				response.getWriter().write(json);
				response.getWriter().close();
			} else if (caller.contains("control")) {
				Long empresaId = new Long(request.getParameter("selectEmpresa").toString());
				Long tipoControlId = new Long(request.getParameter("selectTipoControl").toString());
				
				String fileName = null;
				for (Part part : request.getParts()) {
					String contentDisposition = part.getHeader("content-disposition");
					
					String[] tokens = contentDisposition.split(";");
			        for (String token : tokens) {
			        	if (token.trim().startsWith("filename")) {
		            		fileName = token.substring(token.indexOf("=") + 2, token.length()-1);
		            		break;
		            	}
			        }
			        
			        if (fileName != null) {
			        	part.write(Configuration.getInstance().getProperty("importacion.carpeta") + fileName);
			        	break;
			        }
				}
				
				IControlBean iControlBean = lookupControlBean();
				
				String result = iControlBean.preprocesarArchivoEmpresa(
					fileName,
					empresaId
				);
				
				request.setAttribute("message", result);
				request.setAttribute("fileName", fileName);
				request.setAttribute("empresaId", empresaId);
				request.setAttribute("tipoControlId", tipoControlId);
				
				String json = "{"
					+ "\"message\": \"" + result + "\","
					+ "\"fileName\": \"" + fileName + "\","
					+ "\"empresaId\": \"" + empresaId + "\","
					+ "\"tipoControlId\": \"" + tipoControlId + "\""
					+ "}";
				
				response.addHeader("Content-Type", "application/json");
				response.getWriter().write(json);
				response.getWriter().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			String json = "{"
				+ "\"message\": \"No se ha podido completar la operación.\""
				+ "}";
			
			response.addHeader("Content-Type", "application/json");
			response.getWriter().write(json);
			response.getWriter().close();
		}
	}
	
	private IActivacionBean lookupActivacionBean() throws NamingException {
		String EARName = "Activaciones";
		String beanName = ActivacionBean.class.getSimpleName();
		String remoteInterfaceName = IActivacionBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IActivacionBean) context.lookup(lookupName);
	}
	
	private IControlBean lookupControlBean() throws NamingException {
		String EARName = "Activaciones";
		String beanName = ControlBean.class.getSimpleName();
		String remoteInterfaceName = IControlBean.class.getName();
		String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
		Context context = new InitialContext();
		
		return (IControlBean) context.lookup(lookupName);
	}
}