package org.example.ex2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebServiceController {

    @GetMapping("/web-services")
    public List<String> getWebServices() {
        return List.of(
                "SOAP (Simple Object Access Protocol)",
                "REST (Representational State Transfer)",
                "XML-RPC (XML Remote Procedure Call)",
                "JSON-RPC (JSON Remote Procedure Call)",
                "GraphQL"
        );
    }
}