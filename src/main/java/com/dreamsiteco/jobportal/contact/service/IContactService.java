package com.dreamsiteco.jobportal.contact.service;

import com.dreamsiteco.jobportal.dto.ContactRequestDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface IContactService {

    boolean saveContactMsg(@RequestBody ContactRequestDto contactRequestDto);

}
