/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_mongodb_java;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author oracle
 */
public class MongoHandler {
    
    private static MongoClient cliente;
    private static MongoDatabase db;
    private static MongoCollection<Document> coleccion;    
    
    public void conectar(){
        //Conectar a mongo
        cliente=new MongoClient("localhost",27017);
        //cargar una db
        db=cliente.getDatabase("training");
        //cargar una colleccion de la db cargada anteriormente
        coleccion=db.getCollection("scores");
        //desactivamos los mensajes de log de mongo
        Logger x=Logger.getLogger("org.mongodb.driver");
        x.setLevel(Level.OFF);
    }
    
    public void mostrar(){
        //Asi escribimos una condicion para una consulta (clave,valor)
        BasicDBObject condicion= new BasicDBObject("kind","essay");
        //Creamos un cursor
        FindIterable<Document> cursor1=coleccion.find(condicion);
        //Creamos un objeto MongoCursor que será el que iteremos
        MongoCursor<Document> iterar=cursor1.iterator();
        while(iterar.hasNext()){
            Document doc=iterar.next();
            String kind = doc.getString("kind");
            double score = doc.getDouble("score");
            double student = doc.getDouble("student");
            
            System.out.println(kind+","+score+","+student);
        }
        iterar.close();
        cliente.close();
    }
    
    public void insertar(){
        Document nuevoDoc=new Document("kind","taller");
        nuevoDoc.append("score", 1111);
        nuevoDoc.append("enderezo",new Document("rua","urzaiz").append("numero", 27));
        coleccion.insertOne(nuevoDoc);
        cliente.close();
    }
    
    public void modificar(){
        BasicDBObject docABuscar= new BasicDBObject("kind","taller").append("score", 1111);
        BasicDBObject updatedDoc=new BasicDBObject("$set",new BasicDBObject("score",2222));
        coleccion.updateOne(docABuscar, updatedDoc);
        cliente.close();
    }
}
