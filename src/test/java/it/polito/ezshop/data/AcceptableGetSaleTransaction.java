package it.polito.ezshop.data;

import it.polito.ezshop.exceptions.InvalidTransactionIdException;
import it.polito.ezshop.exceptions.UnauthorizedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcceptableGetSaleTransaction {

    private it.polito.ezshop.data.EZShop shop;
    private int idSaleTransaction;

    @Before
    public void before() throws Exception{
        shop = new it.polito.ezshop.data.EZShop();
        shop.login("admin","ciao");
        idSaleTransaction = shop.startSaleTransaction();
    }

    @Test
    public void authTest() throws Exception {
        shop.logout();
        assertThrows(UnauthorizedException.class, () ->
                shop.getSaleTransaction(idSaleTransaction));

        shop.login("admin","ciao");
    }

    @Test
    public void testIdCorrect() {
        assertThrows(InvalidTransactionIdException.class, () ->
                shop.getSaleTransaction(null));

        assertThrows(InvalidTransactionIdException.class, () ->
                shop.getSaleTransaction(0));

        assertThrows(InvalidTransactionIdException.class, () ->
                shop.getSaleTransaction(-1));
    }

    @Test
    public void testNoTransactionPresent() throws Exception{
        assertNull(shop.getSaleTransaction(999));
    }

    @Test
    public void testCorrectCase() throws Exception{
       // todo FALLITO
        assertTrue( shop.getSaleTransaction(idSaleTransaction) instanceof it.polito.ezshop.model.SaleTransaction);

    }

    @After
    public void after() throws Exception {
        shop.deleteSaleTransaction(idSaleTransaction);
        shop.logout();
    }



}
