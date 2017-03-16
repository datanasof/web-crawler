package dbManager;

import java.util.List; 
import java.util.Iterator; 
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import db.DBbuilder;
import db.Dealer;

public class ManageDealer {
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
      ManageDealer ME = new ManageDealer();

      /* Add few dealer records in database */
      Integer dealerID1 = ME.addDealer("Thomann",0,0);
      Integer dealerID2 = ME.addDealer("BAX",0,0);
      Integer dealerID3 = ME.addDealer("DAS",0,0);

      /* List down all the dealers */
      ME.listDealers();

      /* Update dealer's records */
      ME.updateDealer(dealerID1,0,0);

      /* Delete a dealer from the database */
      ME.deleteDealer(dealerID2);

      /* List down new list of the dealers */
      ME.listDealers();
   }
   /* Method to CREATE a dealer in the database */
   public Integer addDealer(String name, int pvmonthly, int pvyearly){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer productID = null;
      try{
         tx = session.beginTransaction();
         Dealer dealer = new Dealer(name,pvmonthly,pvyearly);
         productID = (Integer) session.save(dealer); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return productID;
   }
   /* Method to  READ all the dealers */
   public void listDealers( ){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List products = session.createQuery("FROM Dealer").list(); 
         for (Iterator iterator = 
                           products.iterator(); iterator.hasNext();){
            Dealer dealer = (Dealer) iterator.next(); 
            System.out.println("Dealer Name: " + dealer.getDealerName() + ", points: " + dealer.getPvmonthly() + "," + dealer.getPvyearly());             
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to UPDATE points for a dealer */
   public void updateDealer(Integer DealerID, int pvmonthly, int pvyearly){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Dealer dealer = (Dealer) session.get(Dealer.class, DealerID); 
         dealer.setPvmonthly(pvmonthly);
         dealer.setPvyearly(pvyearly);
		 session.update(dealer); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   /* Method to DELETE a dealer from the records */
   public void deleteDealer(Integer DealerID){
      Session session = factory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Dealer dealer = (Dealer)session.get(Dealer.class, DealerID); 
         session.delete(dealer); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}

