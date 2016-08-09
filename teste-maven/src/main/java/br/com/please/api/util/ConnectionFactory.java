package br.com.please.api.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    
    private static EntityManagerFactory enf;
    private static ConnectionFactory connection;
    
    private ConnectionFactory() {     
       
        enf = Persistence.createEntityManagerFactory("please-api-persistence-unit");            
    }
    
    @Produces @RequestScoped
    public synchronized static EntityManager getEntityManager() throws Exception {                
     
        try{
            if(enf == null){
                connection = new ConnectionFactory();
            }      
        }
        catch(Exception e){      
        	//throw new ConnectDatabaseException("Não foi possível conectar ao banco de dados. Error: " + e.getMessage());
        	throw e;
        }
        
        return enf.createEntityManager();
    }
}
