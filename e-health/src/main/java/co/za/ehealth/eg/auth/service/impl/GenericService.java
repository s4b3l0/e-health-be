package co.za.ehealth.eg.auth.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GenericService<T extends JpaRepository, S, ID> {
    final private T repository;

    public GenericService(T repository) {
        this.repository = repository;
    }

    public S create(S item) throws NoSuchAlgorithmException {
        return (S) repository.save(item);
    }

    public S getOne(ID id) throws Exception {
        Optional<S> optional =  this.repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("Item not found");
        }
    }

    public S update(ID id,S item) throws Exception {
         return null;
    }

    public S delete(ID id, S item) throws Exception {
        S o = getOne(id);
        if (Objects.isNull(o)) {
            throw new Exception("Item not found");
        }
        repository.delete(o);
        return o;
    }

    public Page<S> getByPage(int pageNo, int itemsPerPage) {
        return repository.findAll(PageRequest.of(pageNo, itemsPerPage));
    }

    public List<Object> getAll() {
        return repository.findAll();
    }

}