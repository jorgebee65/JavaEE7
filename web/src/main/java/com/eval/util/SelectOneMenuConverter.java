package com.eval.util;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.eval.bo.UserBO;
import com.eval.dao.UserDAOImpl;

/**
 * The Class SelectOneMenuConverter.
 */
@FacesConverter("selectOneMenuConverter")
public class SelectOneMenuConverter implements Converter {
	
	private UserDAOImpl dao;
	private List<UserBO> lstUsers;

	public SelectOneMenuConverter() {
		super();
		dao = new UserDAOImpl();
		lstUsers = dao.obtenerTodos();
	}

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value == null || value.trim().equals("")) {
			return null;
		}
		try {
			int id = Integer.parseInt(value);
			for (UserBO t : lstUsers) {
				if (t.getId() == id) {
					return t;
				}
			}
		} catch (NumberFormatException exception) {
			throw new ConverterException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid UserBO"));
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((UserBO) value).getId());
		}
	}

}