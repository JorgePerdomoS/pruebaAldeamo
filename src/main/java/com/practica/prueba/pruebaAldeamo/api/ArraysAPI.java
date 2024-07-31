package com.practica.prueba.pruebaAldeamo.api;

import com.practica.prueba.pruebaAldeamo.business.ArraysService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${com.api.mainUrl}")
@RequiredArgsConstructor
@Slf4j
public class ArraysAPI {

    private final ArraysService arraysService;

    @GetMapping("/array/{id}")
    public ResponseEntity<List<Integer>> getArrayResponse(@RequestParam Integer iteration, @PathVariable Integer id) {
        List<Integer> body = arraysService.getResponseArray(id, iteration);
        log.info("Ejecutando getArrayResponse.");
        return ResponseEntity.ok(body);
    }
}
