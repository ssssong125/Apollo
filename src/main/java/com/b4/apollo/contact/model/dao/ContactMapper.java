package com.b4.apollo.contact.model.dao;

import com.b4.apollo.contact.model.dto.ContactDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContactMapper {

    int sendContent(ContactDTO contactDTO);

    List<ContactDTO> findAllContent();
}
