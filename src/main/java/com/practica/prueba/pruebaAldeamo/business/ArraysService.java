package com.practica.prueba.pruebaAldeamo.business;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArraysService {

    /**
     * getResponseArray
     *
     * @param id , array id in database
     * @param iterations, numbers of iterations to execute
     * @return list with  expected response
     */
    List<Integer> getResponseArray(long id ,int iterations);

}
