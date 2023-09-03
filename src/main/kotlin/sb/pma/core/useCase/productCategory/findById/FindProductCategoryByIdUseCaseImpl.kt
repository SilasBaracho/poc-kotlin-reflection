package sb.pma.core.useCase.productCategory.findById

import sb.pma.core.domain.productCategory.gateway.FindByIdProductCategoryGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.FindProductCategoryByIdUseCase

class FindProductCategoryByIdUseCaseImpl(
    private val findByIdProductCategoryGateway: FindByIdProductCategoryGateway
): FindProductCategoryByIdUseCase {

    override operator fun invoke(payload: FindProductCategoryByIdInput): ProductCategoryOutput {
        return findByIdProductCategoryGateway.execute(payload.id)
            .orElseThrow { NotFoundException("Category Not found") }
            .let { ProductCategoryOutputImpl(it) }
    }
}