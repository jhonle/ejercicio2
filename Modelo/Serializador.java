package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;
/**
 * Clase que se encarga de guardar y recuperar datos 
 * de un archivo
 */
public class Serializador 
{                		
	private ObjectInputStream lectorDeObjeto;
	private ObjectOutputStream escritorDeObjeto;			
	/**
	 * Guarda un Obejto en un archivo
	 * @param objeto  obejeto que se desea guardar en el archivo
	 * @param nombreDelArchivo nombre del archivo en el que se desea guardar al objeto
	 * */
	public void escribirObjeto(Object objeto,String nombreDelArchivo)
	{
		try 
		{
			escritorDeObjeto=new ObjectOutputStream(new FileOutputStream(nombreDelArchivo));
			escritorDeObjeto.writeObject(objeto);
			escritorDeObjeto.close();
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}	
	/**
	 * Recupera el objeto guardado en un archivo
	 * @param  nombreArchivo nombre del archivo que contenga el Objeto guardado
	 * @return Objeto que se guardo en el archivo
	 * */
	public Object leerObjeto(String nombreArchivo )
	{
		Object retorno=null;
		try 
		{
			lectorDeObjeto=new ObjectInputStream(new FileInputStream(nombreArchivo));
			retorno=lectorDeObjeto.readObject();
			lectorDeObjeto.close();
		}
		catch (FileNotFoundException e) 
		{
		   // TODO Auto-generated catch block
			//e.printStackTrace();
			Serializador ser  = new Serializador();
			BaseDeDato datos= new BaseDeDato();
            ser.escribirObjeto(datos,"Datos.a");
			JOptionPane.showMessageDialog(null,"Se creo un nuevo Archivo de Datos 'Datos.a'. Esto solo se realiza en la primera Ejecucion del Programa" );

            
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;				
	}	
}
