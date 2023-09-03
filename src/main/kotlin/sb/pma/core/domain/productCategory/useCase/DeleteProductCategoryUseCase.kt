package sb.pma.core.domain.productCategory.useCase

import sb.pma.core.useCase.productCategory.delete.DeleteProductCategoryInput

interface DeleteProductCategoryUseCase {

    operator fun invoke(payload: DeleteProductCategoryInput)
}