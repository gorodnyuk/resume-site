package ru.gorodnyuk.resumesite.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.gorodnyuk.resumesite.model.StatisticsEntity;

public interface StatisticsRepository extends CrudRepository<StatisticsEntity, Long> {

    boolean existsByIp(String ip);

    @Modifying
    @Query(value = "UPDATE statistics " +
            "SET counter = counter + 1 " +
            "WHERE ip = :ip",
            nativeQuery = true)
    void updateStatisticByIp(@Param("ip") String ip);
}
