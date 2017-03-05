package dbManager;

import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import db.DBbuilder;
import db.DBdata;
import db.Product;

public class ManageProduct {
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
      ManageProduct ME = new ManageProduct();

      /* Add few employee records in database */
      Integer prodID1 = ME.addProduct("Orion Studio");
      Integer prodID2 = ME.addProduct("Zen Tour");
      Integer prodID3 = ME.addProduct("Goliath");

      /* List down all the employees */
      ME.listProducts();

      /* Update employee's records */
      ME.updateProduct(prodID1, "OCX HD");

      /* Delete a product from the database */
      ME.deleteProduct(prodID2);

      /* List down new list of the employees */
      ME.listProducts();
   }
   /* Method to CREATE a product in the database */
   public Integer addProduct(String name){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer productID = null;
      try{
         tx = session.beginTransaction();
         Product product = new Product(name);
         productID = (Integer) session.save(product); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return productID;
   }
   /* Method to  READ all the employees */
   public void listProducts( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List products = session.createQuery("FROM Product").list(); 
         for (Iterator iterator = 
                           products.iterator(); iterator.hasNext();){
            Product product = (Product) iterator.next(); 
            System.out.println("Product Name: " + product.getProductName());             
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE Name for a product */
   public void updateProduct(Integer ProductID, String name ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Product product = (Product) session.get(Product.class, ProductID); 
         product.setProductName(name);
		 session.update(product); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE a product from the records */
   public void deleteProduct(Integer ProductID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Product product = (Product)session.get(Product.class, ProductID); 
         session.delete(product); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}
