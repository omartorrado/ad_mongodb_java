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
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author oracle
 */
public class Ad_mongodb_java {

    private static MongoClient cliente;
    private static MongoDatabase db;
    private static MongoCollection<Document> coleccion;
    
    public static void main(String[] args) {
        conectar();
    }
    
    public static void conectar(){
        //Conectar a mongo
        cliente=new MongoClient("localhost",27017);
        //cargar una db
        db=cliente.getDatabase("training");
        //cargar una colleccion de la db cargada anteriormente
        coleccion=db.getCollection("scores");
        //Asi escribimos una condicion para una consulta (clave,valor)
        BasicDBObject condicion= new BasicDBObject("kind","essay");
        //Creamos un cursor
        FindIterable<Document> cursor1=coleccion.find(condicion);
    }
    
}
