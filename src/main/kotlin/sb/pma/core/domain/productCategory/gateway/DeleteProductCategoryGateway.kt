package sb.pma.core.domain.productCategory.gateway

import sb.pma.core.domain.productCategory.model.ProductCategory

interface DeleteProductCategoryGateway {

    fun execute(productCategory: ProductCategory)
}