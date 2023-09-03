package sb.pma.core.useCase.productCategory.findByName

import sb.pma.core.domain.productCategory.gateway.FindByNameProductCategoryGateway
import sb.pma.infrastructure.exception.NotFoundException
import sb.pma.core.domain.productCategory.output.ProductCategoryOutput
import sb.pma.core.domain.productCategory.output.ProductCategoryOutputImpl
import sb.pma.core.domain.productCategory.useCase.FindProductCategoryByNameUseCase

class FindProductCategoryByNameUseCaseImpl(
    private val findByNameProductCategoryGateway: FindByNameProductCategoryGateway
): FindProductCategoryByNameUseCase {

    override operator fun invoke(payload: FindProductCategoryByNameInput): ProductCategoryOutput {
        return findByNameProductCategoryGateway.execute(payload.name)
            .orElseThrow { NotFoundException("Category not found") }
            .let { ProductCategoryOutputImpl(it) }
    }
}