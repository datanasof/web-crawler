package dbManager;

import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import db.DBbuilder;
import db.Pricelist;

public class ManagePricelist {
   private static SessionFactory factory; 
   public static void main(String[] args) {
	   DBbuilder.start();
	   
      try{
    	  Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
         factory = new Configuration().configure().buildSessionFactory();
      }catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ManagePricelist ME = new ManagePricelist();

      /* Add few price records in database */
      Integer productPriceID1 = ME.addProductPrice(1,2590,"EUR");
      Integer productPriceID2 = ME.addProductPrice(2,1890,"EUR");
      Integer productPriceID3 = ME.addProductPrice(3,4550,"EUR");

      /* List down all the prices */
      ME.listProductPrices();

      /* Update product's price */
      ME.updateProductPrice(productPriceID1,2699,"USD");

      /* Delete a productPrice from the database */
      ME.deleteProductPrice(productPriceID3);

      /* List down new list of the product prices */
      ME.listProductPrices();
   }
   /* Method to CREATE a product price in the database */
   public Integer addProductPrice(int productID, int price, String currency){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer productPriceID = null;
      try{
         tx = session.beginTransaction();
         Pricelist pricelist = new Pricelist(productID,price,currency);
         productPriceID = (Integer) session.save(pricelist); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return productPriceID;
   }
   /* Method to  READ all the dealers */
   public void listProductPrices( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List productPrices = session.createQuery("FROM Pricelist").list(); 
         for (Iterator iterator = 
                           productPrices.iterator(); iterator.hasNext();){
            Pricelist pricelist = (Pricelist) iterator.next(); 
            System.out.println("Product: " + pricelist.getProductID() + ", price =  " + pricelist.getPrice() + " " + pricelist.getCurrency());             
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE product price */
   public void updateProductPrice(Integer productPriceID, int price, String currency){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Pricelist pricelist = (Pricelist) session.get(Pricelist.class, productPriceID); 
         pricelist.setPrice(price);
         pricelist.setCurrency(currency);
		 session.update(pricelist); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE a product price from the records */
   public void deleteProductPrice(Integer productPriceID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Pricelist pricelist = (Pricelist)session.get(Pricelist.class, productPriceID); 
         session.delete(pricelist); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}

