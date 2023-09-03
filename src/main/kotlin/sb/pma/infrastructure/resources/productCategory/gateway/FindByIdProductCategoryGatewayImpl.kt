package sb.pma.infrastructure.resources.productCategory.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.gateway.FindByIdProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.infrastructure.config.db.repository.ProductCategoryRepository
import sb.pma.infrastructure.resources.productCategory.adapter.ProductCategoryAdapter
import java.util.Optional

@Component
class FindByIdProductCategoryGatewayImpl(
    private val productCategoryAdapter: ProductCategoryAdapter,
    private val productCategoryRepository: ProductCategoryRepository
): FindByIdProductCategoryGateway {

    override fun execute(id: Long): Optional<ProductCategory> {
        return productCategoryRepository.findById(id).map { productCategoryAdapter.toDomain(it) }
    }

}