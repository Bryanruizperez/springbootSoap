package com.miumg.edu.gt.progra2.springbootSoap.Service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;


@Service
public class TipoCambioRangoService {

    private static final Logger logger = LogManager.getLogger(TipoCambioRangoService.class);

    public String obtenerTipocambioRango(String fechainit, String fechafin) {

        logger.info("Obteniendo tipo de cambio para el rango: {} - {}", fechainit, fechafin);


        String endpoint = "https://banguat.gob.gt/variables/ws/TipoCambio.asmx";
        String action = "http://www.banguat.gob.gt/variables/ws/TipoCambioRango";
        String soapRequest =
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                        "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                        "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                        "<soap:Body>" +
                        "<TipoCambioRango xmlns=\"http://www.banguat.gob.gt/variables/ws/\">" +
                        "<fechainit>" + fechainit + "</fechainit>" +
                        "<fechafin>" + fechafin + "</fechafin>" +
                        "</TipoCambioRango>" +
                        "</soap:Body>" +
                        "</soap:Envelope>";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);
        headers.add("SOAPAction", action);
        HttpEntity<String> request = new HttpEntity<>(soapRequest, headers);

        try {
            String response = restTemplate.exchange(endpoint, HttpMethod.POST,request, String.class).getBody();
            JSONObject jsonResponse = XML.toJSONObject(response);
            logger.info("Respuesta recibida: {}", jsonResponse.toString(4));

            return jsonResponse.toString(4);
        } catch (Exception e) {
            logger.error("Error al obtener el tipo de cambio", e);
            return "Error al obtener el tipo de cambio: " + e.getMessage();
        }
    }
}