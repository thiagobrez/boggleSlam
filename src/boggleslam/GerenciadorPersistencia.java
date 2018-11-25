
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerenciadorPersistencia {

	public static GerenciadorPersistencia gerenciadorPersistencia;
	private HashMap<String, String> cache = new HashMap<>();
    private final String fileName = "cache.boggle";
	
    private GerenciadorPersistencia() {
        load();
    }

	public static GerenciadorPersistencia getInstance() {
        if (gerenciadorPersistencia == null) {
            gerenciadorPersistencia = new GerenciadorPersistencia();
        }
        return gerenciadorPersistencia;
    }
	
    public void persistirPalavra(String palavra) {
		cache.put(palavra, palavra);
        persist();
    }
	
    public String get(String palavra) {
        return cache.get(palavra);
    }

    public ArrayList<String> getList() {
        return new ArrayList<>(cache.values());
    }
	
	public ArrayList<String> getKeys() {
		return new ArrayList<>(this.cache.keySet());
	}
	
    public void remove(String palavra) {
		cache.remove(palavra);
        persist();
    }

    private void persist() {
        try {
            FileOutputStream fOS = new FileOutputStream(fileName);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);

            oOS.writeObject(cache);

            oOS.flush();
            fOS.flush();

            oOS.close();
            fOS.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void load() {
        try {
            FileInputStream fIS = new FileInputStream(fileName);
            ObjectInputStream oIS = new ObjectInputStream(fIS);

            cache = (HashMap<String, String>) oIS.readObject();

            oIS.close();
            fIS.close();

        } catch (FileNotFoundException ex) {
            persist();
        } catch (IOException ex) {
            Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
			Logger.getLogger(GerenciadorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
		}
    }
}