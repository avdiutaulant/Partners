package com.example.partners.services;

import com.example.partners.entities.Partner;
import com.example.partners.repostiories.PartnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService{

    private final PartnerRepository partnerRepository;

    public PartnerServiceImpl(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public List<Partner> findAllPartners() {

        return partnerRepository.findAll();
    }

    @Override
    public Partner findPartnerById(Long id) {
        Partner partner = partnerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Partner not found with id " + id));
        return partner;
    }

    @Override
    public Partner savePartner(Partner partner) {
        partner.setCreatedAt(LocalDate.now());
        return partnerRepository.save(partner);
    }

    @Override
    public Partner updatePartner(Partner partner) {
        Partner oldPartner = partnerRepository.findById(partner.getId()).orElseThrow(()-> new EntityNotFoundException("Partner not found with id " + partner.getId()));
        oldPartner.setCompanyName(partner.getCompanyName());
        oldPartner.setCompanyAddress(partner.getCompanyAddress());
        oldPartner.setCompanyPhone(partner.getCompanyPhone());
        oldPartner.setCompanyEmail(partner.getCompanyEmail());
        oldPartner.setCompanyWebsite(partner.getCompanyWebsite());
        oldPartner.setCompanyDescription(partner.getCompanyDescription());
        return partnerRepository.save(oldPartner);
    }

    @Override
    public void deletePartner(Long id) {
         partnerRepository.deleteById(id);
    }
}
