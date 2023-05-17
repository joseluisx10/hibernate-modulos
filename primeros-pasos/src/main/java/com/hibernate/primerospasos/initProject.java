package com.hibernate.primerospasos;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hibernate.entities.Usuario;
import com.hibernate.interfaces.DAO;
import com.hibernate.utiles.Util;

@Component
public class initProject implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u = new Usuario("juan@gmail.com", null, new Date() ,new Date());
		DAO<Usuario, String> bd = new Util();
		
	   //bd.guardar(u);
	    //bd.eliminar(u);
		
		Usuario u3= bd.buscar("user3@gmail.com");
		System.out.println(u3);
	}


}
