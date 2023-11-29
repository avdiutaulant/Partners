package com.example.partners.mappers;

import com.example.partners.dtos.PartnerDto;
import com.example.partners.entities.Partner;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Component;

@Component
public class PartnerMapper {

    public Partner toEntity(PartnerDto dto){
        Partner partner = new Partner();
        partner.setId(dto.getId());
        partner.setCompanyName(dto.getCompanyName());
        partner.setCompanyAddress(dto.getCompanyAddress());
        partner.setCompanyPhone(dto.getCompanyPhone());
        partner.setCompanyEmail(dto.getCompanyEmail());
        partner.setCompanyWebsite(dto.getCompanyWebsite());
        partner.setCompanyDescription(dto.getCompanyDescription());


        return partner;
    }

    public PartnerDto toDto(Partner partner){
        PartnerDto dto = new PartnerDto();
        dto.setId(partner.getId());
        dto.setCompanyName(partner.getCompanyName());
        dto.setCompanyAddress(partner.getCompanyAddress());
        dto.setCompanyPhone(partner.getCompanyPhone());
        dto.setCompanyEmail(partner.getCompanyEmail());
        dto.setCompanyWebsite(partner.getCompanyWebsite());
        dto.setCompanyDescription(partner.getCompanyDescription());

        return dto;
    }
}
