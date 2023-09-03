package sb.pma.core.useCase.product.findById

import sb.pma.core.domain.product.gateway.FindProductByIdGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.core.domain.product.output.ProductOutput
import sb.pma.core.domain.product.output.ProductOutputImpl
import sb.pma.core.domain.product.useCase.FindProductByIdUseCase

class FindProductByIdUseCaseImpl(
    private val findProductByIdGateway: FindProductByIdGateway,
): FindProductByIdUseCase {

    override operator fun invoke(payload: FindProductByIdInput): ProductOutput {
        return findProductByIdGateway.execute(payload.id)
            .orElseThrow { NotFoundException("Product not found") }
            .let { ProductOutputImpl(it) }
    }
}