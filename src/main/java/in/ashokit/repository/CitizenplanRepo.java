package in.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.CitizenEntity;

public interface CitizenplanRepo extends JpaRepository<CitizenEntity, Integer> {

	@Query("select distinct(planName) from CitizenEntity")
	List<String> getPlanName();

	@Query("select distinct(planStatus) from CitizenEntity")
	List<String> getplanStatus();
}
