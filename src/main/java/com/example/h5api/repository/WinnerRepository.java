package com.example.h5api.repository;

import com.example.h5api.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WinnerRepository extends JpaRepository<Winner, Integer> {
    @Query(value = "SELECT * FROM Winner as winner WHERE campaign_id=?1 ORDER BY value_id ASC LIMIT 5", nativeQuery = true)
    List<Winner> findWinnerByCampaignId(Integer id);

    @Query(value = "SELECT max(campaign_id) as lastCampaign FROM winner", nativeQuery = true)
    Integer findLastCampaignId();


}
