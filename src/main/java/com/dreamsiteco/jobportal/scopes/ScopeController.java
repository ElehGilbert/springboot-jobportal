package com.dreamsiteco.jobportal.scopes;


import lombok.RequiredArgsConstructor;
import org.springdoc.core.service.SecurityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scope")
@RequiredArgsConstructor
public class ScopeController {

    private final RequestScopeBean requestScopeBean;

    private final SessionScopeBean sessionScopeBean;
    private  final ApplicationScopeBean applicationScopeBean;

    @GetMapping("/request")
    public ResponseEntity<String> testRequestScope() {
        requestScopeBean.setUsername("Gilbert");
        return ResponseEntity.ok().body(requestScopeBean.getUsername());
    }


    @GetMapping("/session")
    public ResponseEntity<String> testSessionScope() {
        sessionScopeBean.setUsername("Gilbert");
        return ResponseEntity.ok().body(sessionScopeBean.getUsername());
    }


    @GetMapping("/test")
    public ResponseEntity<Integer> testScope() {

        return ResponseEntity.ok().body(applicationScopeBean.getVisitorCount());
    }



    @GetMapping("/application")
    public ResponseEntity<Integer> testApplicationScope() {
        applicationScopeBean.incrementVisitorCount();
        return ResponseEntity.ok().body(applicationScopeBean.getVisitorCount());
    }
}
