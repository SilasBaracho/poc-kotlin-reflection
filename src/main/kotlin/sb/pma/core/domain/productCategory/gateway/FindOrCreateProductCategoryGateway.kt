package sb.pma.core.domain.productCategory.gateway

import sb.pma.core.domain.productCategory.model.ProductCategory
import sb.pma.core.useCase.productCategory.findByName.FindProductCategoryByNameInput

interface FindOrCreateProductCategoryGateway {

    fun execute(payload: FindProductCategoryByNameInput): ProductCategory
}