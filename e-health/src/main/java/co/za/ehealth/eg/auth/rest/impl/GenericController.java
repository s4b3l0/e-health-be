package co.za.ehealth.eg.auth.rest.impl;

import co.za.ehealth.eg.auth.service.impl.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class GenericController<T extends GenericService, S> {
    final T service;

    public GenericController(T service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody S item) {
        return ResponseEntity.ok(service.create(item));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@RequestBody S item, @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.delete(id, item));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody S item, @PathVariable Long id) throws Exception {
        return ResponseEntity.ok(service.delete(id, item));
    }

    @GetMapping("/{itemsPerPage}/{pageNo}")
    public ResponseEntity<Page<S>> get(@PathVariable() int itemsPerPage, @PathVariable() int pageNo) {
        return ResponseEntity.ok(service.getByPage(pageNo, itemsPerPage));
    }

}