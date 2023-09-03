package sb.pma.core.domain.productCategory.gateway

import sb.pma.core.domain.productCategory.model.ProductCategory

interface SaveProductCategoryGateway {

    fun execute(productCategory: ProductCategory): ProductCategory
}