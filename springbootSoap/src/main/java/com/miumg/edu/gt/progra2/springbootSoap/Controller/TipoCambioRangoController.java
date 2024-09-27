package com.miumg.edu.gt.progra2.springbootSoap.Controller;

import com.miumg.edu.gt.progra2.springbootSoap.Service.TipoCambioRangoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipoCambioRangoController {

    private final TipoCambioRangoService tipoCambioRangoService;

    public TipoCambioRangoController(TipoCambioRangoService tipoCambioRangoService) {
        this.tipoCambioRangoService = tipoCambioRangoService;
    }

    @GetMapping("/api/tipoCambioRango")
    public String obtenerTipoCambioRango(
            @RequestParam String fechainit,
            @RequestParam String fechafin) {
        return tipoCambioRangoService.obtenerTipocambioRango(fechainit, fechafin);
    }
}


