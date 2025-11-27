package com.vitormoraes.agendadortarefas.business.mapper;

import com.vitormoraes.agendadortarefas.business.dto.TarefasDTO;
import com.vitormoraes.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface TarefasConverter {
    TarefasEntity paraTarefasEntity(TarefasDTO dto);
    TarefasDTO paraTarefasDTO(TarefasEntity entity);
}
