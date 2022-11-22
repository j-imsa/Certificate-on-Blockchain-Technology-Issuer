package com.innovationchain.certificateonblockchaintechnologyissuer.ws.io;

import com.innovationchain.certificateonblockchaintechnologyissuer.ws.io.entity.ConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<ConnectionEntity, Long> {
}
