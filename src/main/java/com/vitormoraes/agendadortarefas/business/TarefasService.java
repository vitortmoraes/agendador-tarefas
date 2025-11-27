package com.vitormoraes.agendadortarefas.business;

import com.vitormoraes.agendadortarefas.business.dto.TarefasDTO;
import com.vitormoraes.agendadortarefas.business.mapper.TarefasConverter;
import com.vitormoraes.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.vitormoraes.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.vitormoraes.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.vitormoraes.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.pendente);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasConverter.paraTarefasEntity(dto);


        return tarefasConverter.paraTarefasDTO(tarefasRepository.save(entity));
    }
}
