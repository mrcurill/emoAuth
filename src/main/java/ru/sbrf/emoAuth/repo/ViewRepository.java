package ru.sbrf.emoAuth.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbrf.emoAuth.entity.View;

import java.util.List;

@Repository
public interface ViewRepository extends CrudRepository<View, Long> {
    List<View> findByName(String name);
}
