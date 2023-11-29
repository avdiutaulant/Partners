package com.example.partners.services;

import com.example.partners.entities.Partner;

import java.util.List;

public interface PartnerService {

    List<Partner>findAllPartners();

    Partner findPartnerById(Long id);

    Partner savePartner(Partner partner);

    Partner updatePartner(Partner partner);

    void deletePartner(Long id);

}
