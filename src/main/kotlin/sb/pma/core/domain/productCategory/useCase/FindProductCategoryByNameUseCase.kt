package sb.pma.core.domain.productCategory.useCase

import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.useCase.productCategory.findByName.FindProductCategoryByNameInput

interface FindProductCategoryByNameUseCase {

    operator fun invoke(payload: FindProductCategoryByNameInput): ProductCategoryOutput
}