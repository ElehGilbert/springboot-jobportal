package com.dreamsiteco.jobportal.contact.controller;

import com.dreamsiteco.jobportal.contact.service.IContactService;
import com.dreamsiteco.jobportal.dto.ContactRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController
{

    private final IContactService contactService;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody @Valid ContactRequestDto contactRequestDto){


        boolean isSaved= contactService.saveContactMsg(contactRequestDto);

       if(isSaved){
           return ResponseEntity.status(HttpStatus.CREATED)
                   .body("Contact saved Successfully");
       } else {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Contact saved Failed");

       }






//        throw new RuntimeException("Not Implemented");    //  Did this just to test my GlobalExceptionHandler exception Service
    }



    @GetMapping
    public  ResponseEntity<String> fetchOpenContacts(@RequestParam
                                                         @Validated
                                                         @NotBlank(message = "status cannot be empty")
                                                    @Size(min = 1, max = 10,message = "Status must be of minimum legnth 1 and max 10")
                                                         String status){

        return ResponseEntity.ok("There are the contacts with the given status = "+ status);
    }


}
