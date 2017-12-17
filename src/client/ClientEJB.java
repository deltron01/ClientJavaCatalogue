package client;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.ICatalogueRemote;
//import metier.Produit;
import metier.Produit;

public class ClientEJB {

	public static void main(String[] args) {
		try{
			Properties p = new Properties();
			p.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			//p.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			//p.put("jboss.naming.client.ejb.context", true);
			//p.put(javax.naming.Context.PROVIDER_URL, "remote://localhost:4447");
			//p.put(javax.naming.Context.SECURITY_PRINCIPAL, "admin");
	        //p.put(javax.naming.Context.SECURITY_CREDENTIALS, "azerty");
			Context ctx = new InitialContext(p);
			ICatalogueRemote stub = (ICatalogueRemote) ctx.lookup("ejb:/CatalogueEJB/CAT!metier.ICatalogueRemote");
			//stub.addProduit(new Produit("HP", 6000));
			//stub.addProduit(new Produit("Acer", 7000));
			//stub.addProduit(new Produit("Asus", 9000));
		    List<Produit> prods = stub.getProduitsParMC("A");
		    for(Produit pr: prods){
		    	System.out.println(pr.getNomProduit());
		    }
		}catch(NamingException e){
			e.printStackTrace();
		}

	}

}
