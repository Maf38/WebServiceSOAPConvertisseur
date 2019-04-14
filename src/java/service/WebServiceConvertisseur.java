/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import metier.Convertisseur;

/**
 *
 * @author mafal
 */
@WebService(serviceName = "WebServiceConvertisseur")
@Stateless()
public class WebServiceConvertisseur {

    
    private final Convertisseur conv = new Convertisseur();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "convertir")
   public String convertir(@WebParam(name = "source") String source,@WebParam(name = "cible") String cible,@WebParam(name = "montant") String montant)
    {
    return String.valueOf(conv.convertir(source, cible,Double.parseDouble(montant)));
    }

    @WebMethod(operationName = "getConversionTable")
    public List <String> getConversionTable() {
    //transformation de la Map renvoyée en List renvoyée par le service web
    List<String> monnaies = new ArrayList<String>();
    for (Iterator iter=conv.getConversionTable().keySet().iterator();
    iter.hasNext();)
    {
        monnaies.add((String)iter.next());
    }
    return monnaies;

    }
}
