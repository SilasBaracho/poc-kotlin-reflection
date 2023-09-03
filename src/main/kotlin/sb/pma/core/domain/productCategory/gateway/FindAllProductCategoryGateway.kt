package sb.pma.core.domain.productCategory.gateway

import sb.pma.core.domain.productCategory.model.ProductCategory

interface FindAllProductCategoryGateway {

    fun execute(): MutableList<ProductCategory>
}