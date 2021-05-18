package edu.pucp.gtics.lab6_gtics_20211.repository;

import edu.pucp.gtics.lab6_gtics_20211.entity.Juegos;
import edu.pucp.gtics.lab6_gtics_20211.entity.JuegosUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JuegosRepository extends JpaRepository<Juegos,Integer> {
    @Query(value = "select j.image as `imageURL`, j.nombre, g.nombre as `genero`,j.descripcion\n" +
            "from juegosxusuario jxu\n" +
            "inner join juegos j on jxu.idjuego=j.idjuego\n" +
            "inner join generos g on j.idgenero=g.idgenero\n" +
            "where jxu.idusuario=?1",nativeQuery = true)
    List<JuegosUserDto> obtenerJuegosPorUser(int idusuario);
}
