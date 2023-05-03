package za.co.health.eg.eheathservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.health.eg.eheathservice.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
