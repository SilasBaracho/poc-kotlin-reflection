package sb.pma.infrastructure.resources.productCategory.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.gateway.FindByNameProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.infrastructure.config.db.repository.ProductCategoryRepository
import sb.pma.infrastructure.resources.productCategory.adapter.ProductCategoryAdapter
import java.util.Optional

@Component
class FindByNameProductCategoryGatewayImpl(
    private val productCategoryAdapter: ProductCategoryAdapter,
    private val productCategoryRepository: ProductCategoryRepository
): FindByNameProductCategoryGateway {

    override fun execute(name: String): Optional<ProductCategory> {
        return productCategoryRepository.findByName(name).map { productCategoryAdapter.toDomain(it) }
    }
}