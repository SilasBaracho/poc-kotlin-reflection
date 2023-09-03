package sb.pma.core.domain.productCategory.useCase

import sb.pma.core.domain.productCategory.output.ProductCategoryOutput

interface FindAllProductCategoryUseCase {

    operator fun invoke(): List<ProductCategoryOutput>
}