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
@RequestMapping(path = "accounts")
public class AccountController {
    @Autowired
    Set<AccountInfo> accountSet;

    @Resource(name = "requestPool")
    LinkedList<RequestData> requestPool;

    @GetMapping
    List<AccountInfo> listAccount(@RequestParam(name = "server", defaultValue = "") String server,
                                  @RequestParam(name = "size", defaultValue = "20") int size,
                                  @RequestParam(name = "page", defaultValue = "1") int page) {
        int index = size * (page - 1);
        return accountSet.stream().filter(accountInfo -> server.isEmpty() ? true : accountInfo.getServer().equals(server))
                .skip(index).limit(size).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void doAddAccount(@RequestBody AccountInfo account) {
        accountSet.add(account);
    }

    @DeleteMapping
    ResponseEntity doDeleteAccount(@RequestBody AccountInfo account) {
        synchronized (requestPool) {
            requestPool.removeIf(item -> item.getAccount().equals(account.getUsername()) && item.getServer().equals(account.getServer()));
        }
        return accountSet.removeIf(account::equals) ? ResponseEntity.ok().build() : ResponseEntity.unprocessableEntity().build();
    }
}
