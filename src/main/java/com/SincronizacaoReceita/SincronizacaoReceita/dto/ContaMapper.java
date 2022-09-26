package com.SincronizacaoReceita.SincronizacaoReceita.dto;

import com.SincronizacaoReceita.SincronizacaoReceita.model.Conta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContaMapper {

    ContaDTO convertContaToContaDto(Conta conta);
}
