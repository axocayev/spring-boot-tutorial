package atl.academy.i18ndemo.repository;

import atl.academy.i18ndemo.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository  extends JpaRepository<ProductDetail,Long> {
}
