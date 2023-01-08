package com.b4.apollo.contact.service;

import com.b4.apollo.contact.model.dao.ContactMapper;
import com.b4.apollo.contact.model.dto.ContactDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private ContactMapper contactMapper;


    public List<ContactDTO> findAllContent() {
        return contactMapper.findAllContent();
    }

    public boolean sendContent(ContactDTO contactDTO) throws Exception{
        int result = contactMapper.sendContent(contactDTO);
        if(result <= 0) {
            throw new Exception("문의 보내기 실패");
        }
        return result>0 ? true:false;
    }


}
