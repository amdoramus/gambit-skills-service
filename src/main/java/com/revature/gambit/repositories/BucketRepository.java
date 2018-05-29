package com.revature.gambit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.BucketDTO;

/**
 * @author Josh Dughi | 1803-USF-MAR26 | Wezley Singleton
 * @author Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 * 
 * Bucket repository for the bucket servic
 */
@Repository
public interface BucketRepository extends JpaRepository<BucketDTO, Integer> {

}
