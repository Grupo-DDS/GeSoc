package logueo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		try (MongoClient mongoClient = MongoClients
				.create("mongodb+srv://juan:57a8Otdhqg5i0TNW@cluster0.lksmg.mongodb.net/test")) {
			MongoDatabase gesoc = mongoClient.getDatabase("gesoc");
			MongoCollection<Document> logs = gesoc.getCollection("gesoc_logs");
			Document logDocumento = new Document("_id", new ObjectId());
			logDocumento.append("fecha", LocalDateTime.now().toString())
					.append("tipoOperacion", TipoOperacion.ALTA.toString()).append("entidadAfectada", "Producto");

			logs.insertOne(logDocumento);
		}
	}
}
