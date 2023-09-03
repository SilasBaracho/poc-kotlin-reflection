package sb.pma.infrastructure.resources.productCategory.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.gateway.DeleteProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.infrastructure.config.db.repository.ProductCategoryRepository
import sb.pma.infrastructure.resources.productCategory.adapter.ProductCategoryAdapter

@Component
class DeleteProductCategoryGatewayImpl(
    private val productCategoryAdapter: ProductCategoryAdapter,
    private val productCategoryRepository: ProductCategoryRepository
): DeleteProductCategoryGateway {

    override fun execute(productCategory: ProductCategory) {
        val productCategorySchema = productCategoryAdapter.toSchema(productCategory)
        productCategoryRepository.delete(productCategorySchema)
    }
}