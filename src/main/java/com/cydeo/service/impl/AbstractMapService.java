package com.cydeo.service.impl;

import com.cydeo.service.ICrudService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T, S> {

    protected Map<S, T> map = new HashMap<>();

    T save(S id, T object) {
        map.put(id, object);
        return map.get(id);
    }

    T findById(S id) {
        return map.get(id);
    }

    void deleteById(S id) {
        map.remove(id);
    }

    List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    T update(S id, T object) {
        map.put(id, object);
        return map.get(id);
    }


}
