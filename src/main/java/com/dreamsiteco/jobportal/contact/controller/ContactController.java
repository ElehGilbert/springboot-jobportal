package com.dreamsiteco.jobportal.contact.controller;

import com.dreamsiteco.jobportal.contact.service.IContactService;
import com.dreamsiteco.jobportal.dto.ContactRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController
{

    private final IContactService contactService;

    @PostMapping(version = "1.0")
    public ResponseEntity<String> saveContactMsg(@RequestBody ContactRequestDto contactRequestDto){

       boolean isSaved= contactService.saveContactMsg(contactRequestDto);

       if(isSaved){
           return ResponseEntity.status(HttpStatus.CREATED)
                   .body("Contact saved Successfully");
       } else {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Contact saved Failed");

       }

    }


}
