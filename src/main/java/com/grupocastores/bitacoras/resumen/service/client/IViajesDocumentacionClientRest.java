package com.grupocastores.bitacoras.resumen.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grupocastores.commons.inhouse.CiudadesEstadoRequest;
import com.grupocastores.commons.inhouse.GuMesAnio;
import com.grupocastores.commons.inhouse.GuiaViajeCustom;
import com.grupocastores.commons.inhouse.TablaTalonesOficina;
import com.grupocastores.commons.inhouse.TalonCustomResponse;

@FeignClient("castores-service-viajes")
public interface IViajesDocumentacionClientRest {
    
    @GetMapping("documentacion/getTalonesTrGuia/{noGuia}/{idoficinadocumenta}")
    public ResponseEntity<List<TalonCustomResponse>> getTalonesTrGuia(
            @PathVariable("noGuia") String noGuia,
            @PathVariable("idoficinadocumenta") String idOficinaDocumenta
            );
    
    @GetMapping("documentacion/getGuiasViaje/{idViaje}/{idOficinaDocumenta}")
    public ResponseEntity<List<GuiaViajeCustom>> getGuiasViaje(
            @PathVariable("idViaje") int idViaje,
            @PathVariable("idOficinaDocumenta") String idOficinaDocumenta
        );
    
    @GetMapping("documentacion/getTablaTalon/{claTalon}/{idOficinaDocumenta}")
    public ResponseEntity<TablaTalonesOficina> getTablaTalon(
            @PathVariable("claTalon") String claTalon, 
            @PathVariable("idOficinaDocumenta") String idOficinaDocumenta);
    
    @GetMapping("documentacion/getGuMesAnio/{noGuia}/{tabla}/{idOficinaDocumenta}")
    public ResponseEntity<GuMesAnio> getGuMesAnio(
            @PathVariable("noGuia") String noGuia,
            @PathVariable("tabla") String tabla, 
            @PathVariable String idOficinaDocumenta);
    
    @GetMapping("documentacion/findCiudadAndEstado/{idCiudad}")
    public ResponseEntity<CiudadesEstadoRequest> findCiudadAndEstado(@PathVariable("idCiudad") int idCiudad);
}
