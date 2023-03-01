package com.example.orderservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class MapperUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapperUtil.class);

    public static <E, D> D toDto(E entity, D dto, String... ignores) {
        if (entity == null) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto, ignores);

        return dto;
    }

    /**
     * Use copy DTO to Entity when create or update
     *
     * @param dto
     * @param entity
     * @param ignores
     * @param <E>
     * @param <D>
     * @return
     */
    public static <E,D> E toEntity(D dto, E entity, String... ignores) {
        if (dto == null) {
            return null;
        }
        if (ignores == null || ignores.length == 0) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
}
