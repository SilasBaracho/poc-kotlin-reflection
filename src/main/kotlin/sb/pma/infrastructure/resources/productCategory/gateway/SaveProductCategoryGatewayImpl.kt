package sb.pma.infrastructure.resources.productCategory.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.gateway.SaveProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.infrastructure.config.db.repository.ProductCategoryRepository
import sb.pma.infrastructure.resources.productCategory.adapter.ProductCategoryAdapter

@Component
class SaveProductCategoryGatewayImpl(
    private val productCategoryAdapter: ProductCategoryAdapter,
    private val productCategoryRepository: ProductCategoryRepository
): SaveProductCategoryGateway {

    override fun execute(productCategory: ProductCategory): ProductCategory {
        return productCategoryRepository.save(
            productCategoryAdapter.toSchema(productCategory)
        ).let {
            productCategoryAdapter.toDomain(it)
        }
    }
}