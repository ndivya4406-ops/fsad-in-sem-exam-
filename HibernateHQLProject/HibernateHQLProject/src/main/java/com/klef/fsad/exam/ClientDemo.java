package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Date;

public class ClientDemo {

public static void main(String[] args) {

SessionFactory factory =
new Configuration().configure().buildSessionFactory();

Session session = factory.openSession();

Transaction tx = session.beginTransaction();

Delivery d = new Delivery();

d.setName("Amazon Delivery");
d.setDate(new Date());
d.setStatus("Delivered");
d.setAddress("Hyderabad");

session.save(d);

tx.commit();

System.out.println("Record Inserted Successfully");

session.beginTransaction();

String hql = "delete from Delivery where id=?1";

Query q = session.createQuery(hql);
q.setParameter(1,1);

int r = q.executeUpdate();

session.getTransaction().commit();

System.out.println("Rows Deleted : " + r);

session.close();
factory.close();

}
}