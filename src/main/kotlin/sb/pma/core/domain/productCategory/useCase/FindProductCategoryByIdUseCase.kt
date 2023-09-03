package sb.pma.core.domain.productCategory.useCase

import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.useCase.productCategory.findById.FindProductCategoryByIdInput

interface FindProductCategoryByIdUseCase {

    operator fun invoke(payload: FindProductCategoryByIdInput): ProductCategoryOutput
}