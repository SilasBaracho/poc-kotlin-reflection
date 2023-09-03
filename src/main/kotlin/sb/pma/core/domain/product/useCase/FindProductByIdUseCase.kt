package sb.pma.core.domain.product.useCase

import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.useCase.product.findById.FindProductByIdInput

interface FindProductByIdUseCase {

    operator fun invoke(payload: FindProductByIdInput): ProductOutput
}