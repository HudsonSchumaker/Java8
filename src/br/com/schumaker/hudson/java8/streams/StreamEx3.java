package br.com.schumaker.hudson.java8.streams;

import br.com.schumaker.hudson.java8.lambdas.Usuario;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 *
 * @author hudson schumaker
 */
public class StreamEx3 {
    public static void main(String[] args) {
        //BiFunction para method reference chamar construtor q recebe 2 parametros
        BiFunction<String, Integer, Usuario> factory = Usuario::new;
        Usuario user1 = factory.apply("Henrique Schumaker", 50);
        Usuario user2 = factory.apply("Humberto Schumaker", 120);
        Usuario user3 = factory.apply("Hugo Schumaker", 190);
        Usuario user4 = factory.apply("Hudson Schumaker", 10);
        Usuario user5 = factory.apply("Gabriel Schumaker", 90);
        Usuario user6 = factory.apply("Nikolas Schumaker", 290);
        Usuario user7 = factory.apply("Elisabeth Schumaker", 195);
        Usuario user8 = factory.apply("Eliza Schumaker", 1000);
        Usuario user9 = factory.apply("Marcos Schumaker", 100);
        Usuario user10 = factory.apply("Wilson Schumaker", 1300);
        
        List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5,
            user6, user7, user8, user9, user10);
        
        //filtra usuarios com + de 100 pontos e os torna moderadores
        usuarios.stream()
                .filter(u -> u.getPontos() > 100)
                .forEach(Usuario::tornaModerador);
        
        //filtra usuarios moderadores e imprime-os
        usuarios.stream()
                .filter(u -> u.isModerador())
                .forEach(System.out::println);
    }
}