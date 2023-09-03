package sb.pma.core.domain.productCategory.useCase

import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.useCase.productCategory.create.CreateProductCategoryInput

interface CreateProductCategoryUseCase {

    operator fun invoke(payload: CreateProductCategoryInput): ProductCategoryOutput
}