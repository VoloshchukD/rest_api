package com.epam.esm.rest_api.service;

import com.epam.esm.rest_api.dao.TagDao;
import com.epam.esm.rest_api.dao.impl.TagDaoImpl;
import com.epam.esm.rest_api.entity.Tag;
import com.epam.esm.rest_api.service.impl.TagServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class TagServiceTest {

    private TagService tagService;

    private TagDao tagDao;

    private static Tag tag;

    @BeforeAll
    public static void initializeTag() {
        tag = new Tag();
        tag.setId(1L);
        tag.setName("test-certificate");
    }

    @BeforeEach
    public void setUpMocks() {
        tagDao = Mockito.mock(TagDaoImpl.class);
        tagService = new TagServiceImpl(tagDao);
    }

    @Test
    public void testAddTag() {
        Mockito.when(tagDao.add(tag)).thenReturn(true);
        Assertions.assertTrue(tagService.add(tag));
    }

    @Test
    public void testFindTag() {
        Mockito.when(tagDao.find(tag.getId())).thenReturn(tag);
        Assertions.assertEquals(tag, tagService.find(tag.getId()));
    }

    @Test
    public void testFindAllTags() {
        Mockito.when(tagDao.findAll()).thenReturn(Collections.singletonList(tag));
        Assertions.assertNotNull(tagService.findAll());
    }

    @Test
    public void testUpdateTag() {
        String updatedString = "updated";
        tag.setName(updatedString);
        Mockito.when(tagDao.update(tag)).thenReturn(tag);
        Assertions.assertEquals(tag, tagService.update(tag));
    }

    @Test
    public void testDeleteTag() {
        Mockito.when(tagDao.delete(tag.getId())).thenReturn(true);
        Assertions.assertTrue(tagService.delete(tag.getId()));
    }

}
