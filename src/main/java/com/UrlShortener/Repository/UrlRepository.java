package com.UrlShortener.Repository;

import com.UrlShortener.Model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, String> {
    public UrlEntity findByid(String id);
}
