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
import org.bson.Document;

/**
 *
 * @author oracle
 */
public class Ad_mongodb_java {

    
    
    public static void main(String[] args) {
        MongoHandler mongo=new MongoHandler();
        mongo.conectar();
        //mongo.insertar();
        //mongo.modificar();
        mongo.mostrar();
    }
    
    
    
    
    
}
