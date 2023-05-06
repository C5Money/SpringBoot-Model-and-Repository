package com.example.thuisopdracht11springboottiemodelenrepository.repositories;

import com.example.thuisopdracht11springboottiemodelenrepository.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    Optional<Television> findByNameContainingIgnoreCase (String name);


}
