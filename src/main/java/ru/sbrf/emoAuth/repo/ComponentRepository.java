package ru.sbrf.emoAuth.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.emoAuth.entity.Component;

import java.util.List;

@Repository
public interface ComponentRepository extends CrudRepository<Component, Long> {
    List<Component> findByName(String name);
}
