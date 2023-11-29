package com.example.partners.controllers;

import com.example.partners.dtos.PartnerDto;
import com.example.partners.mappers.PartnerMapper;
import com.example.partners.services.PartnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class PartnerController {

    private final PartnerService partnerService;

    private final PartnerMapper partnerMapper;

    public PartnerController(PartnerService partnerService, PartnerMapper partnerMapper) {
        this.partnerService = partnerService;
        this.partnerMapper = partnerMapper;
    }

    @GetMapping("/partners/")
    public ResponseEntity<List<PartnerDto>> getPartners(){
        return ResponseEntity.ok(partnerService.findAllPartners()
                .stream()
                .map(partnerMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/partners/{id}")
    public ResponseEntity<PartnerDto> findPartnerById(Long id){
        return ResponseEntity.ok(partnerMapper.toDto(partnerService.findPartnerById(id)));
    }

    @PostMapping("/partners/")
    public ResponseEntity<PartnerDto> createPartner(@RequestBody PartnerDto partnerDto){
        return ResponseEntity.ok(partnerMapper.toDto(partnerService.savePartner(partnerMapper.toEntity(partnerDto))));
    }

    @PutMapping("/partners/{id}")
    public ResponseEntity<PartnerDto> updatePartner(@PathVariable Long id, @RequestBody PartnerDto partnerDto){
        return ResponseEntity.ok(partnerMapper.toDto(partnerService.updatePartner(partnerMapper.toEntity(partnerDto))));
    }

    @DeleteMapping("/partners/{id}")
    public ResponseEntity<Void> deletePartner(@PathVariable Long id){
        partnerService.deletePartner(id);
        return ResponseEntity.noContent().build();
    }

}
