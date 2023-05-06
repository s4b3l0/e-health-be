package co.za.ehealth.eg.auth.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public class GenericService<T extends JpaRepository, S> {
    final private T repository;

    public GenericService(T repository) {
        this.repository = repository;
    }

    public Object create(S item) {
        return repository.save(item);
    }

    public Optional<Object> getOne(Object id) {
        return this.repository.findById(id);
    }

    public Object update(Object id,S item) throws Exception {
        Object o = getOne(id);
        if (Objects.isNull(o)) {
            throw new Exception("Item not found");
        }
        return create(item);
    }

    public Object delete(Object id,S item) throws Exception {
        Object o = getOne(id);
        if (Objects.isNull(o)) {
            throw new Exception("Item not found");
        }
        return create(item);
    }

    public Page<S> getByPage(int pageNo, int itemsPerPage) {
        return repository.findAll(PageRequest.of(pageNo, itemsPerPage));
    }

}