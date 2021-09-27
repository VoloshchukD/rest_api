package com.epam.esm.rest_api.dao;

import com.epam.esm.rest_api.configuration.TestDataSourceConfiguration;
import com.epam.esm.rest_api.entity.Tag;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class TagDaoTest {

    @Autowired
    private TagDao tagDao;

    private static Tag tag;

    @BeforeClass
    public static void initializeTag() {
        tag = new Tag();
        tag.setId(1L);
        tag.setName("test-tag");
    }

    @Test
    public void testAddTag() {
        Assert.assertTrue(tagDao.add(tag));
    }

    @Test
    public void testFindTag() {
        Assert.assertNotNull(tagDao.find(tag.getId()));
    }

    @Test
    public void testFindAllTags() {
        Assert.assertNotNull(tagDao.findAll());
    }

    @Test
    public void testUpdateTag() {
        String updatedString = "updated";
        tag.setName(updatedString);
        Assert.assertEquals(tag, tagDao.update(tag));
    }

    @Test
    public void testDeleteTag() {
        Assert.assertTrue(tagDao.delete(2L));
    }

}
