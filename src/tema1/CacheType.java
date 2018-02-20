//package tema1;
/***
 * 
 * Clasa ce indica functionalitatile ce trebuie implementate de catre cele doua
 * tipuri de cache.
 * @author Mocanu Alexandru
 */

public interface CacheType {

	public int Check(String nume_proc, int numar);

	public void Add(int numar, String proc, int rezultat);
}
