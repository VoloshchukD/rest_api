package com.epam.esm.rest_api.controller;

import com.epam.esm.rest_api.entity.GiftCertificate;
import com.epam.esm.rest_api.service.GiftCertificateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/gift-certificates")
public class GiftCertificateController {

    private GiftCertificateService giftCertificateService;

    public GiftCertificateController(GiftCertificateService giftCertificateService) {
        this.giftCertificateService = giftCertificateService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<GiftCertificate> getGiftCertificate(@PathVariable("id") Long id) {
        return new ResponseEntity(giftCertificateService.find(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<GiftCertificate>> getGiftCertificates() {
        return new ResponseEntity(giftCertificateService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Boolean> createGiftCertificate(
            @RequestBody GiftCertificate certificate) {
        boolean result = giftCertificateService.add(certificate);
        HttpStatus httpStatus = result ? HttpStatus.CREATED : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(result, httpStatus);
    }

    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json")
    public @ResponseBody
    ResponseEntity<GiftCertificate> updateGiftCertificate(
            @RequestBody GiftCertificate giftCertificate) {
        GiftCertificate updatedGiftCertificate = giftCertificateService.update(giftCertificate);
        HttpStatus httpStatus = (updatedGiftCertificate != null)
                ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(giftCertificate, httpStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<GiftCertificate> deleteGiftCertificate(
            @PathVariable("id") Long id) {
        boolean result = giftCertificateService.delete(id);
        HttpStatus httpStatus = result ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(result, httpStatus);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"tagName"})
    public ResponseEntity<GiftCertificate> findGiftCertificateByTagName(@RequestParam("tagName") String tagName) {
        return new ResponseEntity(giftCertificateService.findByTagName(tagName), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "description"})
    public ResponseEntity<List<GiftCertificate>> findByNameAndDescription(@RequestParam("name") String name,
                                                                    @RequestParam("description") String description) {
        return new ResponseEntity(giftCertificateService.findByNameAndDescription(name, description), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"sortingParameter", "descending"})
    public ResponseEntity<List<GiftCertificate>> findSorted(@RequestParam("sortingParameter") String sortingParameter,
                                                      @RequestParam("descending") boolean descending) {
        return new ResponseEntity(giftCertificateService.findSorted(sortingParameter, descending), HttpStatus.OK);
    }

}

