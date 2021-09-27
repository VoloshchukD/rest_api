package com.epam.esm.rest_api.service;

import com.epam.esm.rest_api.dao.GiftCertificateDao;
import com.epam.esm.rest_api.dao.impl.GiftCertificateDaoImpl;
import com.epam.esm.rest_api.entity.GiftCertificate;
import com.epam.esm.rest_api.service.impl.GiftCertificateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Date;

public class GiftCertificateServiceTest {

    private GiftCertificateService giftCertificateService;

    private GiftCertificateDao giftCertificateDao;

    private static GiftCertificate giftCertificate;

    @BeforeAll
    public static void initializeGiftCertificate() {
        giftCertificate = new GiftCertificate();
        giftCertificate.setId(1L);
        giftCertificate.setName("test-certificate");
        giftCertificate.setLastUpdateDate(new Date());
        giftCertificate.setCreateDate(new Date());
        giftCertificate.setDescription("test");
        giftCertificate.setDuration(1);
        giftCertificate.setPrice(1);
    }

    @BeforeEach
    public void setUpMocks() {
        giftCertificateDao = Mockito.mock(GiftCertificateDaoImpl.class);
        giftCertificateService = new GiftCertificateServiceImpl(giftCertificateDao);
    }

    @Test
    public void testAddGiftCertificate() {
        Mockito.when(giftCertificateDao.add(giftCertificate)).thenReturn(true);
        Assertions.assertTrue(giftCertificateService.add(giftCertificate));
    }

    @Test
    public void testFindGiftCertificate() {
        Mockito.when(giftCertificateDao.find(giftCertificate.getId())).thenReturn(giftCertificate);
        Assertions.assertEquals(giftCertificate, giftCertificateService.find(giftCertificate.getId()));
    }

    @Test
    public void testFindAllGiftCertificates() {
        Mockito.when(giftCertificateDao.findAll()).thenReturn(Collections.singletonList(giftCertificate));
        Assertions.assertNotNull(giftCertificateService.findAll());
    }

    @Test
    public void testUpdateGiftCertificate() {
        String updatedString = "updated";
        giftCertificate.setName(updatedString);
        Mockito.when(giftCertificateDao.update(giftCertificate)).thenReturn(giftCertificate);
        Assertions.assertEquals(giftCertificate, giftCertificateService.update(giftCertificate));
    }

    @Test
    public void testDeleteGiftCertificate() {
        Mockito.when(giftCertificateDao.delete(giftCertificate.getId())).thenReturn(true);
        Assertions.assertTrue(giftCertificateService.delete(giftCertificate.getId()));
    }

}
