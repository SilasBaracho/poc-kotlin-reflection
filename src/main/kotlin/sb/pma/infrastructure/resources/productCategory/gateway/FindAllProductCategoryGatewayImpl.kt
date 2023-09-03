package sb.pma.infrastructure.resources.productCategory.gateway

import org.springframework.stereotype.Component
import sb.pma.core.domain.productCategory.gateway.FindAllProductCategoryGateway
import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.infrastructure.config.db.repository.ProductCategoryRepository
import sb.pma.infrastructure.resources.productCategory.adapter.ProductCategoryAdapter

@Component
class FindAllProductCategoryGatewayImpl(
    private val productCategoryAdapter: ProductCategoryAdapter,
    private val productCategoryRepository: ProductCategoryRepository
): FindAllProductCategoryGateway {

    override fun execute(): MutableList<ProductCategory> {
        val productCategories = mutableListOf<ProductCategory>()
        productCategoryRepository.findAll().map {
            val productCategory = productCategoryAdapter.toDomain(it)
            productCategories.add(productCategory)
        }

        return productCategories
    }
}