package com.epam.esm.core.controller;

import com.epam.esm.entity.Tag;
import com.epam.esm.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tag> getTag(@PathVariable("id") Long id) {
        return new ResponseEntity(tagService.find(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Tag>> getTags() {
        return new ResponseEntity(tagService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Boolean> createTag(@RequestBody Tag tag) {
        boolean result = tagService.add(tag);
        HttpStatus httpStatus = result ? HttpStatus.CREATED : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(result, httpStatus);
    }

    @RequestMapping(method = RequestMethod.PATCH, consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Tag> updateTag(@RequestBody Tag tag) {
        Tag updatedTag = tagService.update(tag);
        HttpStatus httpStatus = (updatedTag != null) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(updatedTag, httpStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Tag> deleteTag(@PathVariable("id") Long id) {
        boolean result = tagService.delete(id);
        HttpStatus httpStatus = result ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(result, httpStatus);
    }

    @RequestMapping(method = RequestMethod.POST, params = {"certificateId", "tagId"},
            consumes = "application/json")
    public @ResponseBody
    ResponseEntity<Boolean> addTagToCertificate(@RequestParam("certificateId") Long certificateId,
                                                @RequestParam("tagId") Long tagId) {
        boolean result = tagService.addTagToCertificate(certificateId, tagId);
        HttpStatus httpStatus = result ? HttpStatus.CREATED : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(result, httpStatus);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json",
            params = {"certificateId"})
    ResponseEntity<Boolean> addTagToCertificate(@RequestBody Tag tag,
                                                @RequestParam("certificateId") Long certificateId) {
        boolean result = tagService.addTagToCertificate(tag, certificateId);
        HttpStatus httpStatus = result ? HttpStatus.CREATED : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(result, httpStatus);
    }

    @RequestMapping(method = RequestMethod.DELETE, params = {"certificateId", "tagId"})
    public @ResponseBody
    ResponseEntity<Tag> deleteTagFromCertificate(@RequestParam("certificateId") Long certificateId,
                                                 @RequestParam("tagId") Long tagId) {
        boolean result = tagService.deleteTagFromCertificate(certificateId, tagId);
        HttpStatus httpStatus = result ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
        return new ResponseEntity(result, httpStatus);
    }

}
