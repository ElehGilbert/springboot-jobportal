package com.dreamsiteco.jobportal.scopes;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
@Getter @Setter
public class ApplicationScopeBean {

    private int visitorCount;

    public ApplicationScopeBean() {
        System.out.println("ApplicationScopeBean Created");
    }


    public  void incrementVisitorCount() {
        visitorCount++;
    }


}
