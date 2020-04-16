package com.evleeena.petclinic.services.map;

import com.evleeena.petclinic.model.BaseEntity;
import org.springframework.util.CollectionUtils;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T object) {
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }

        if (object.getId() == null) {
            object.setId(getNextId());
        }

        map.put(object.getId(), object);
        return object;
    }

    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextId() {
        return CollectionUtils.isEmpty(map) ? 1L : Collections.max(map.keySet()) + 1;
    }
}

