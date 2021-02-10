package tej.springboot.db_jpa.DemoSpringBootDataAccess.exception;

public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(Long id) {
        super("The product with " + id + " cannot be found.");
    }
}
