package it.polito.ezshop;

import it.polito.ezshop.data.EZShopInterface;
import it.polito.ezshop.exceptions.InvalidCustomerNameException;
import it.polito.ezshop.view.EZShopGUI;

import java.sql.SQLException;

public class EZShop {

    public static void main(String[] args){

        EZShopInterface ezShop = new it.polito.ezshop.data.EZShop();
        EZShopGUI gui = new EZShopGUI(ezShop);

    }

}
