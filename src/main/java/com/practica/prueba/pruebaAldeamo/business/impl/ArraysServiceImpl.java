package com.practica.prueba.pruebaAldeamo.business.impl;

import com.practica.prueba.pruebaAldeamo.business.ArraysService;
import com.practica.prueba.pruebaAldeamo.entity.ArraysEntity;
import com.practica.prueba.pruebaAldeamo.persistent.ArraysRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArraysServiceImpl implements ArraysService {

    private final ArraysRepository arraysRepository;

    @Override
    public List<Integer> getResponseArray(long id, int iterations) {

        ArraysEntity dataInDB = arraysRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Array not found with id %d", id)));

        log.info("Obteniendo datos y creando arreglo.");
        List<Integer> A = java.util.Arrays.stream(dataInDB.getInputArray().split(","))
                .map(Integer::parseInt)
                .toList();

        List<Integer> response = new ArrayList<>();
        log.info("Creacion de arreglo de numeros primos");
        List<Integer> primes = getPrimes(iterations);

        for (int i = 0; i < iterations; i++) {
            List<Integer> B = new ArrayList<>();
            List<Integer> Ai = new ArrayList<>();
            int prime = primes.get(i);

            for (int num : A) {
                if (num % prime == 0) {
                    B.add(num);
                } else {
                    Ai.add(num);
                }
            }

            Collections.reverse(B);
            log.info("Agregando datos al arreglo respuesta.");
            response.addAll(B);
            A = Ai;
        }

        response.addAll(A);

        return response;
    }

    /**
     * getPrimes
     *
     * @param iterations, number of iterations for create an array with prime numbers
     * @return array with prime numbers
     */
    private List<Integer> getPrimes(Integer iterations) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> P = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int i = 0; i < iterations; i++) {
            P.add(primes.get(i));
        }

        return P;
    }

    /**
     *
     * @param number, number to validate if it is prime or not
     * @return true if the number is prime, false if it is not.
     */
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
