package com.grupotres.back_personal_disponible.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupotres.back_personal_disponible.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	@Query
	("SELECT e from Empleado e WHERE e.status=?1")
	List<Empleado> findbyStatus(String status);
	
	 @Query("SELECT e FROM Empleado e WHERE e.bench = :benchDate")
	 List<Empleado> findByBench(@Param("benchDate") Date benchDate);
	
	@Query("SELECT e FROM Empleado e WHERE e.jornada = ?1")
	List<Empleado> findByJornada(BigDecimal jornada);
	
	@Query("SELECT e FROM Empleado e WHERE e.ciudad = ?1")
	List<Empleado> findByCiudad(String ciudad);

	@Query
	("SELECT e from Empleado e WHERE e.n4=?1")
	List<Empleado> findbyN4(String n4);
	
	@Query
	("SELECT e from Empleado e WHERE e.categoria = ?1")
	public List<Empleado> findbyCategoria(String categoria);
 
	/*@Query
	("SELECT e from Empleado e WHERE e.ccname = ?1")
	public List<Empleado> findbyCcname(String ccname);*/
	
	@Query
	("SELECT e FROM Empleado e WHERE e.scr BETWEEN 1 AND 100")
	List<Empleado> findbyScr(BigDecimal scr);

	@Query("SELECT e FROM Empleado e JOIN e.grupo g WHERE g.grupos LIKE %?1%")
	List<Empleado> findByGroups(String groupName);

	 @Query("SELECT DISTINCT e.status FROM Empleado e")
	  List<String> findAllDistinctStatuses();

	  @Query("SELECT DISTINCT e.ciudad FROM Empleado e")
	    List<String> findAllDistinctCiudades();
	  
	  @Query("SELECT DISTINCT e.jornada FROM Empleado e")
	    List<BigDecimal> findAllDistinctJornadas();

	  @Query("SELECT DISTINCT g.grupos FROM Empleado e JOIN e.grupo g")
	  List<String> findAllDistinctGroups();

	  @Query("SELECT DISTINCT e.n4 FROM Empleado e")
	    List<String> findAllDistinctN4s();
	  
	  @Query("SELECT DISTINCT e.categoria FROM Empleado e")
	    List<String> findAllDistinctCategorias();
	    
	    @Query("SELECT DISTINCT e.scr FROM Empleado e")
	    List<BigDecimal> findAllDistinctScrs();
}
