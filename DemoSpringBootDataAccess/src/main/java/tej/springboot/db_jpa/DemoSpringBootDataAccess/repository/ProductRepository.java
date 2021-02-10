package tej.springboot.db_jpa.DemoSpringBootDataAccess.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tej.springboot.db_jpa.DemoSpringBootDataAccess.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
