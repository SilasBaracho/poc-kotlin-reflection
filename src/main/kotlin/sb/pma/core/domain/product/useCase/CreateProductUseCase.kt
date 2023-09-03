package sb.pma.core.domain.product.useCase

import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.useCase.product.create.CreateProductInput

interface CreateProductUseCase {

    operator fun invoke(payload: CreateProductInput): ProductOutput
}