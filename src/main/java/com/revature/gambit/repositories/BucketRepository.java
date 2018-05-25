package com.revature.gambit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.gambit.entities.BucketDTO;

/**
 * 
 * Bucket repository for the bucket service.
 * 
 * @author Josh Dughi and Richard Vo | 1803-USF-MAR26 | Wezley Singleton
 *
 */

@Repository
public interface BucketRepository extends JpaRepository<BucketDTO, Integer> {

}
