package sb.pma.core.domain.product.useCase

import sb.pma.core.useCase.product.delete.DeleteProductInput

interface DeleteProductUseCase {

    operator fun invoke(payload: DeleteProductInput)
}