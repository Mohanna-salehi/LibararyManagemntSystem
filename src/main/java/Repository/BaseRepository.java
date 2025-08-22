package Repository;

import model.BaseEntity;
import model.ItemStatus;
import model.Publisher;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<ID, TYPE extends BaseEntity<ID>> {

    public TYPE saveOrUpdate(TYPE type);

    boolean deleteById(ID id);

    Optional<TYPE> findById(ID id);

    List<TYPE> findAll(ID id);


}
