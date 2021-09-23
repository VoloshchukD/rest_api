package com.epam.esm.rest_api.controller;

import com.epam.esm.rest_api.entity.GiftCertificate;
import com.epam.esm.rest_api.service.GiftCertificateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/gift-certificates")
public class GiftCertificateController {

    private GiftCertificateService giftCertificateService;

    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GiftCertificate> getGiftCertificate(@PathVariable("id") Long id) {
        return new ResponseEntity(giftCertificateService.find(id), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Boolean> createGiftCertificate(
            @RequestBody GiftCertificate certificate) {
        boolean result = giftCertificateService.add(certificate);
        HttpStatus httpStatus = HttpStatus.NOT_MODIFIED;
        if (result) {
            httpStatus = HttpStatus.CREATED;
        }
        return new ResponseEntity(result, httpStatus);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public @ResponseBody
    ResponseEntity<GiftCertificate> updateGiftCertificate(
            @RequestBody GiftCertificate certificate) {
        GiftCertificate giftCertificate = giftCertificateService.update(certificate);
        HttpStatus httpStatus = HttpStatus.NOT_MODIFIED;
        if (giftCertificate != null) {
            httpStatus = HttpStatus.OK;
        }
        return new ResponseEntity(giftCertificate, httpStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<GiftCertificate> deleteGiftCertificate(
            @PathVariable("id") Long id) {
        boolean result = giftCertificateService.remove(id);
        HttpStatus httpStatus = HttpStatus.NOT_MODIFIED;
        if (result) {
            httpStatus = HttpStatus.CREATED;
        }
        return new ResponseEntity(result, httpStatus);
    }

}

