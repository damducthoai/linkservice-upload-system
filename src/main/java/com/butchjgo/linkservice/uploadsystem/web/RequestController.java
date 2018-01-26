package com.butchjgo.linkservice.uploadsystem.web;

import com.butchjgo.linkservice.uploadsystem.entity.AccountInfo;
import com.butchjgo.linkservice.uploadsystem.entity.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "requests")
public class RequestController {

    @Resource(name = "requestPool")
    LinkedList<RequestData> requestPool;

    @Autowired
    Set<AccountInfo> accountSet;

    @GetMapping
    List<RequestData> showListRequest(@RequestParam(name = "size", defaultValue = "20") int size, @RequestParam(name = "page", defaultValue = "1") int page) {
        int index = (page - 1) * size;
        return requestPool.stream().skip(index).limit(size).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void newRequest(@RequestBody RequestData req) {
        synchronized (requestPool) {
            requestPool.addFirst(req);
        }
    }

    @DeleteMapping
    ResponseEntity deleteRequest(@RequestBody RequestData req) {
        boolean success = requestPool.removeIf(req::equals);
        return success ? ResponseEntity.ok().build() : ResponseEntity.unprocessableEntity().build();
    }
}
