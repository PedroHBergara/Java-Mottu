package br.com.fiap.challengemottu.dto;

import java.util.List;

public record FilialResponse(
        Long id,
        String nome,
        String pais,
        String logradouro,
        List<Long> patioIds
) {}

