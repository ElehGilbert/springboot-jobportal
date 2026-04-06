package com.dreamsiteco.jobportal.contact.service.impl;

import com.dreamsiteco.jobportal.contact.service.IContactService;
import com.dreamsiteco.jobportal.dto.ContactRequestDto;
import com.dreamsiteco.jobportal.entity.Contact;
import com.dreamsiteco.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl  implements IContactService {

    private final ContactRepository contactRepository;

/// <summary></summary>
    @Override
    public boolean saveContactMsg(ContactRequestDto contactRequestDto) {
        boolean result = false;
       Contact contact= contactRepository.save(transformToEntity(contactRequestDto));
        if(contact!=null && contact.getId()!=null) {
           result = true;
        }

        return result;
    }







//Helper Region
//    Mapper logic to write my dto into my data object
    private Contact transformToEntity(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
//        contact.setName(contactRequestDto.name());// SAMETHING AS WE DID IN COMPANY SERVICE MANUALLY MAPPING STUFFS
        BeanUtils.copyProperties(contactRequestDto, contact);// THIS HELPS US AUTO MAP STUFFS ASLONG AS OUR NAMINGS FOR THE DTO AND ENTITY MATCH

        //Since this other values do not exist in the DTO i have to map them manually
        contact.setCreatedAt(Instant.now());
        contact.setCreatedBy("system");
//        contact.setUpdatedAt(Instant.now());
        contact.setStatus("NEW");


        return contact;
    }
}
