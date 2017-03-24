/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.converter.general;

import j2o.software.kraken.db.facade.general.TipoIdentificacionFacade;
import j2o.software.kraken.db.model.general.TipoIdentificacion;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jdmp
 */
@FacesConverter("tipoIdentificacionConverter")
public class TipoIdentificacionConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null && value.trim().length() > 0) {
            try {
                TipoIdentificacionFacade objetoFacade = fc.getCurrentInstance().getApplication().evaluateExpressionGet(fc, "#{tipoIdentificacion}", TipoIdentificacionFacade.class);

                TipoIdentificacion objeto = objetoFacade.find(Long.parseLong(value));
                System.err.println("objeto"+objeto.getAbreviatura());
                return objeto;
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid rol."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return String.valueOf(((TipoIdentificacion) object).getId());
        } else {
            return null;
        }
    }
}
