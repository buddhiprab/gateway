package com.api.gateway.repository;

import com.api.gateway.model.RequestTrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*created by Buddhi*/

@Repository
public interface RequestTraceRepository extends JpaRepository<RequestTrace, Long> {
}
