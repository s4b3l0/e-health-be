package co.za.ehealth.eg.auth.controllers.impl;

import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class GenericController<T extends GenericService, S, ID> {
    final T service;

    public GenericController(T service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody S item) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(service.create(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<S> update(@RequestBody S item, @PathVariable ID id) throws Exception {
        return (ResponseEntity<S>) ResponseEntity.ok(service.update(id, item));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<S> delete(@RequestBody S item, @PathVariable ID id) throws Exception {
        return (ResponseEntity<S>) ResponseEntity.ok(service.delete(id, item));
    }

    @GetMapping("/{itemsPerPage}/{pageNo}")
    public ResponseEntity<Page<S>> get(@PathVariable() int itemsPerPage, @PathVariable() int pageNo) {
        return ResponseEntity.ok(service.getByPage(pageNo, itemsPerPage));
    }

    @GetMapping("/{id}")
    public S getOne(@PathVariable ID id) throws Exception {
        return (S) ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("")
    public ResponseEntity<List<S>> getAll() throws Exception {
        return ResponseEntity.ok(service.getAll());
    }


}