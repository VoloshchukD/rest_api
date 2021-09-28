package com.epam.esm.rest_api.dao;

import com.epam.esm.rest_api.configuration.TestDataSourceConfiguration;
import com.epam.esm.rest_api.entity.GiftCertificate;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class GiftCertificateDaoTest {

    @Autowired
    private GiftCertificateDao giftCertificateDao;

    private static GiftCertificate giftCertificate;

    @BeforeClass
    public static void initializeGiftCertificate() {
        giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setName("qwerty");
        giftCertificate.setLastUpdateDate(new Date());
        giftCertificate.setCreateDate(new Date());
        giftCertificate.setDescription("test");
        giftCertificate.setDuration(1);
        giftCertificate.setPrice(1);
    }

    @Test
    public void testAddGiftCertificate() {
        Assert.assertTrue(giftCertificateDao.add(giftCertificate));
    }

    @Test
    public void testFindCertificate() {
        Assert.assertNotNull(giftCertificateDao.find(giftCertificate.getId()));
    }

    @Test
    public void testFindAllCertificates() {
        Assert.assertNotNull(giftCertificateDao.findAll());
    }

    @Test
    public void testUpdateCertificate() {
        String updatedString = "updated";
        giftCertificate.setDescription(updatedString);
        Assert.assertEquals(giftCertificate, giftCertificateDao.update(giftCertificate));
    }

    @Test
    public void testDeleteCertificate() {
        Assert.assertTrue(giftCertificateDao.delete(2L));
    }

    @Test
    public void testFindByTagName() {
        Assert.assertNotNull(giftCertificateDao.findByTagName("test"));
    }

    @Test
    public void testFindByNameAndDescription() {
        Assert.assertNotNull(giftCertificateDao.findByNameAndDescription("qwer", "qwer"));
    }

    @Test
    public void testFindSorted() {
        Assert.assertNotNull(giftCertificateDao.findSorted("name", false));
    }

}
