package com.example.gestion_flotte_avion_ws.controller;

import com.example.gestion_flotte_avion_ws.models.Tokens;
import com.example.gestion_flotte_avion_ws.service.TokensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("\tokens")
public class TokensController {
    @Autowired
    TokensService tokensService;

    @GetMapping("/tokens")
    private List<Tokens> getAllTokens() {
        return tokensService.getAllTokens();
    }

    @GetMapping("/tokens/{tokensid}")
    private Tokens getTokens(@PathVariable("modeleid") int tokensid) {
        return tokensService.getTokensById(tokensid);
    }

    @DeleteMapping("/tokens/{tokensid}")
    private void deleteBook(@PathVariable("tokensid") int tokensid) {
        tokensService.delete(tokensid);
    }

    @PostMapping("/tokens")
    private int saveBook(@RequestBody Tokens tokens) {
        tokensService.saveOrUpdate(tokens);
        return tokens.getIdToken();
    }

    //creating put mapping that updates the avion detail
    @PutMapping("/tokens")
    private Tokens update(@RequestBody Tokens tokens) {
        tokensService.saveOrUpdate(tokens);
        return tokens;
    }
}
