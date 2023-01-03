package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {
    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // !!! get methodu
//       Student07 student =  session.get(Student07.class, 1001);
//        student.getBookList().forEach(System.out::println); // method reference
        //student.getBookList().forEach(b->System.out.println(b)); // lambda expression

        // !!! SQL ile öğrenci bilgilerini alalım ( öğrenci ismi ve kitap ismi )
//        String sqlQuery =
//                "SELECT s.student_name,b.name FROM student07 s INNER JOIN book07 b ON s.id=b.student_id";
//        List<Object[]> resulList1 = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] object: resulList1) {
//            System.out.println(Arrays.toString(object));
//        }

         //!!! yukardaki sorguyu HQL ile yazalım
//        String hqlQuery =
//                "SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=b.student.id";
//        List<Object[]> resultList2 = session.createQuery(hqlQuery).getResultList();
//        resultList2.forEach(oa -> System.out.println(Arrays.toString(oa)));

        // Delete işlemi SQL
//        String sqlQuery = "DELETE FROM book07";
//        int numberOfDeletedRecords = session.createSQLQuery(sqlQuery).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı : " + numberOfDeletedRecords);

        //
//        String sqlQuery2 = "Delete From student07";
//        int numberOfDeletedRecords1 = session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı : " + numberOfDeletedRecords1);

//        String sqlQuery3 = "DELETE FROM book07";
//        int numberOfDeletedRecords2 = session.createSQLQuery(sqlQuery3).executeUpdate();
//        System.out.println("Silinen Kayıt Sayısı : " + numberOfDeletedRecords2);

        // Delete işlemi HQL
//        String hqlQuery4 = "DELETE FROM Book07";
//        int numOfDeletedRecords3 = session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("Silinen kayit sayisi = " + numOfDeletedRecords3);

        // Delete işlemi HQL student
//        String hqlQuery5 = "DELETE FROM Student07";
//        int numOfDeletedRecords4 = session.createQuery(hqlQuery5).executeUpdate();
//        System.out.println("Silinen kayit sayisi = " + numOfDeletedRecords4);

        //Kitap ismi A Book olanı silelim
//        String hqlQuery6 = "Delete from Book07 b where b.name='A Book'";
//        int numOfDeletedRecords5 = session.createQuery(hqlQuery6).executeUpdate();
//        System.out.println("Silinen kayit sayisi = " + numOfDeletedRecords5);

        //Kitap bilgisi olan bir öğrenciyi silmek istersek bunun iki yolu var :
        //1) Book tablosundan ilişkili olduğu Book lar silinir daha sonra
        // istenen student objesi silinebilir.
        //2) Student entity clasının ilgili yerine Cascade / orphanRemoval

        // 1001 id'li student objemi delete metoduyla silelim
//        Student07 student = session.get(Student07.class,1001);
//        session.delete(student);

         //student.getBookList().set(0,null); //orphanRemoval=true , 0.indeksteki child'ı Child
        // tablosundan gider siler.

        // book ismi içinde "Java" geçen student kayıtlarını alalım (HQL)
//        String hqlQuery4 =
//                "Select s From Student07 s JOIN s.bookList b where b.name LIKE '%Java%'";
//        List<Student07> resultLis3 = session.createQuery(hqlQuery4, Student07.class).getResultList();
//        for (Student07 student07 : resultLis3){
//            System.out.println(student07);
//        }

        tx.commit();
        session.close();
        sf.close();
    }
}
